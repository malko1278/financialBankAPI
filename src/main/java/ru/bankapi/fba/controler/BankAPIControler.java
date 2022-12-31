/**
 * 
 */
package ru.bankapi.fba.controler;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import ru.bankapi.fba.entities.Client;
import ru.bankapi.fba.entities.ClientAccount;
import ru.bankapi.fba.entities.OrdreCaisse;
import ru.bankapi.fba.entities.Transaction;
import ru.bankapi.fba.service.account.ClientAccountService;
import ru.bankapi.fba.service.client.ClientService;
import ru.bankapi.fba.service.order_caiss.OrdreCaisseService;
import ru.bankapi.fba.service.transaction.TransactionService;

/**************************************************************************
 * Source File	 :  BankAPIControler.java
 * Author        :  Franck Armel Malko
 * Project name  :  Test
 * Created       :  13/12/2022
 * Modified   	 :  13/12/2022
 * Description	 :  Definition of the class BankAPIControler
 **************************************************************************/
@RestController
@RequestMapping("/bank_api")
@AllArgsConstructor
public class BankAPIControler {
	private final ClientService cliServive;
	private final TransactionService transServive;
	private final OrdreCaisseService orderCaissServive;
	private final ClientAccountService accountCliServive;
	private final ClientAccountService clientAccountService;
	
	/**
	 * @param cliServive
	 */
	public BankAPIControler(ClientService cliServive, ClientAccountService accountCliServive, TransactionService transServive, 
                            OrdreCaisseService orderCaissServive, ClientAccountService clientAccountService) {
		super();
		this.cliServive = cliServive;
		this.transServive = transServive;
		this.orderCaissServive = orderCaissServive;
		this.accountCliServive = accountCliServive;
		this.clientAccountService = clientAccountService;
	}
	
	@GetMapping("/client/read_all")
	public List<Client> readClients() {
		return cliServive.readClients();
	}
	
	@GetMapping("/client/read_client/{id}")
	public Client readClientByID(@PathVariable Long id) {
		return cliServive.readClientByID(id);
	}
	
	@GetMapping("/client/read_account/{id}")
	public List<ClientAccount> readAllAccount(@PathVariable Long id) {
		return accountCliServive.readAccountsClient(id);
	}
	
	@GetMapping("/client/account/transaction/{id}")
	public List<Transaction> readTransactionsAccount(@PathVariable Long idAccount) {
		return transServive.readTransactionsByAccountClient(idAccount);
	}
	
	@GetMapping("/client/account/check_out_order/{id}")
	public List<OrdreCaisse> readCheckOutsAccount(@PathVariable Long idAccount) {
		return orderCaissServive.readOrder_caisseByAccountClient(idAccount);
	}
	
	@PostMapping("/check_out_order/create/{passd_wd}")
	public OrdreCaisse createCheckOut(@RequestBody OrdreCaisse orderCass, @PathVariable String passd_wd) {
		OrdreCaisse ordreCaisse = null;
		ClientAccount cliAccount = clientAccountService.readAccountClient(orderCass.getAccountCliCheck().getIdent());
		if(cliAccount != null) {
			int type = 0;
			// пополнение, снятие
			if(orderCass.getType().equals("пополнение"))   cliAccount.setAmount(cliAccount.getAmount() + orderCass.getAmount());
			else {
				type = 1;
				if((cliAccount.getAmount() - orderCass.getAmount()) >= 0) {
					cliAccount.setAmount(cliAccount.getAmount() - orderCass.getAmount());
				} else  return ordreCaisse;
			}
			if(type == 1) {
				Client client = cliServive.readClientByID(cliAccount.getClientAccount().getId());
				if(client.getPassword().equals(passd_wd)) {
					clientAccountService.updateAccount(cliAccount.getIdent(), cliAccount);
					orderCass.setResult_execution("Совершенная транзакция");
					ordreCaisse = orderCaissServive.create(orderCass);
					transServive.create(new Transaction(orderCass.getAmount(), orderCass.getType(), "Совершенная транзакция", cliAccount, ordreCaisse, cliAccount));
				} else {
					orderCass.setResult_execution("Неверный пароль");
					ordreCaisse = orderCaissServive.create(orderCass);
					transServive.create(new Transaction(orderCass.getAmount(), orderCass.getType(), "Неверный пароль", cliAccount, ordreCaisse, cliAccount));
				}
			} else {
				clientAccountService.updateAccount(cliAccount.getIdent(), cliAccount);
				orderCass.setResult_execution("Совершенная транзакция");
				ordreCaisse = orderCaissServive.create(orderCass);
				transServive.create(new Transaction(orderCass.getAmount(), orderCass.getType(), "Совершенная транзакция", cliAccount, ordreCaisse, cliAccount));
			}
		}
		return ordreCaisse;
	}
	
	@PostMapping("/execute_transfert/{id_cli}/{passd_wd}/{first_num_compt}/{scd_num_compt}")
	public Transaction transfertBetweenAccounts(@RequestBody Transaction transact, @PathVariable Long id_cli, @PathVariable String passd_wd, 
			                                    @PathVariable String first_num_compt, @PathVariable String scd_num_compt) {
		String result = "";
		List<ClientAccount> accountClis = clientAccountService.readAccountsClient(id_cli);
		if(accountClis != null) {
			int i = 0;
			while(accountClis.size() > 2) {
				if(accountClis.get(i).getAccount_number().equals(first_num_compt) || accountClis.get(i).getAccount_number().equals(scd_num_compt)) {
					i++;
				} else {
					accountClis.remove(accountClis.get(i));
				}
			}
			ClientAccount A = null, B = null;
			if(accountClis.size() == 1) {
				if(accountClis.get(0).getAccount_number().equals(first_num_compt))   result = scd_num_compt + " : Номер счета неизвестен...";
				else   result = first_num_compt + " : Номер счета неизвестен...";
				A = accountClis.get(0);
			} else {
				if(accountClis.size() == 2) {
					if(accountClis.get(0).getAccount_number().equals(first_num_compt)) {
						A = accountClis.get(0);
						B = accountClis.get(1);
					} else {
						A = accountClis.get(1);
						B = accountClis.get(0);
					}
					Client client = cliServive.readClientByID(id_cli);
					if(client.getPassword().equals(passd_wd)) {
						if((A.getAmount() - transact.getAmount()) >= 0) {
							A.setAmount(A.getAmount() - transact.getAmount());
							B.setAmount(B.getAmount() + transact.getAmount());
							clientAccountService.updateAccount(A.getIdent(), A);
							clientAccountService.updateAccount(B.getIdent(), B);
							result = "Совершенная транзакция";
						} else   result = "Сумма, недостаточная для перевода";
					} else	 result = "Неверный пароль";
				}
			}
			transact.setAccounClient(A);
			transact.setAccounCliTran(A);
			transact.setResult_execution(result);
			transServive.create(transact);
		} else {
			// Отсутствие учетной записи в базе данных.
		}
		return transact;
	}
	
	@PostMapping("/execute_transfert/{passd_wd}/{first_num_compt}/{scd_num_compt}")
	public Transaction transferBetweenCustomers(@RequestBody Transaction transact, @PathVariable String passd_wd, 
			                                    @PathVariable String first_num_compt, @PathVariable String scd_num_compt) {
		String result = "";
		List<ClientAccount> accountClis = clientAccountService.readAccounts();
		if(accountClis != null) {
			int i = 0;
			while(accountClis.size() > 2) {
				if(accountClis.get(i).getAccount_number().equals(first_num_compt) || accountClis.get(i).getAccount_number().equals(scd_num_compt)) {
					i++;
				} else {
					accountClis.remove(accountClis.get(i));
				}
			}
			ClientAccount A = null, B = null;
			if(accountClis.size() == 1) {
				if(accountClis.get(0).getAccount_number().equals(first_num_compt))   result = scd_num_compt + " : Номер счета неизвестен...";
				else   result = first_num_compt + " : Номер счета неизвестен...";
				A = accountClis.get(0);
			} else {
				if(accountClis.size() == 2) {
					if(accountClis.get(0).getAccount_number().equals(first_num_compt)) {
						A = accountClis.get(0);
						B = accountClis.get(1);
					} else {
						A = accountClis.get(1);
						B = accountClis.get(0);
					}
					Client client = cliServive.readClientByID(A.getClientAccount().getId());
					if(client.getPassword().equals(passd_wd)) {
						if((A.getAmount() - transact.getAmount()) >= 0) {
							A.setAmount(A.getAmount() - transact.getAmount());
							B.setAmount(B.getAmount() + transact.getAmount());
							clientAccountService.updateAccount(A.getIdent(), A);
							clientAccountService.updateAccount(B.getIdent(), B);
							result = "Совершенная транзакция";
						} else   result = "Сумма, недостаточная для перевода";
					} else	 result = "Неверный пароль";
				}
			}
			transact.setAccounClient(A);
			transact.setAccounCliTran(A);
			transact.setResult_execution(result);
			transServive.create(transact);
		} else {
			// Отсутствие учетной записи в базе данных.
		}
		return transact;
	}
}