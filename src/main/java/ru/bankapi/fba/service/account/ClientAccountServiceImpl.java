/**
 * 
 */
package ru.bankapi.fba.service.account;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import ru.bankapi.fba.entities.ClientAccount;
import ru.bankapi.fba.repository.ClientAccountRepository;

/**************************************************************************
 * Source File	 :  ClientAccountServiceImpl.java
 * Author        :  Franck Armel Malko
 * Project name  :  Test
 * Created       :  13/12/2022
 * Modified   	 :  13/12/2022
 * Description	 :  Definition of the class ClientAccountServiceImpl
 **************************************************************************/
@Service
@AllArgsConstructor
public class ClientAccountServiceImpl implements ClientAccountService {
	
	private final ClientAccountRepository clientAccountReposit = null;

	@Override
	public ClientAccount create(ClientAccount clientAcc) {
		// TODO Auto-generated method stub
		return clientAccountReposit.save(clientAcc);
	}

	@Override
	public List<ClientAccount> readAccounts() {
		// TODO Auto-generated method stub
		return clientAccountReposit.findAll();
	}

	@Override
	public ClientAccount readAccountClient(Long idAccount) {
		// TODO Auto-generated method stub
		return clientAccountReposit.findById(idAccount).get();
	}

	@SuppressWarnings("null")
	@Override
	@Transactional
	public List<ClientAccount> readAccountsClient(Long idCli) {
		// TODO Auto-generated method stub
		List<ClientAccount> accountClis = clientAccountReposit.findAll();
		List<ClientAccount> listAccountClis = null;
		int i = 0;
		while(accountClis.size() > i) {
			if(accountClis.get(i).getClientAccount().getId() == idCli)   listAccountClis.add(accountClis.get(i));
			i++;
		}
		return listAccountClis;
	}

	@Override
	public ClientAccount updateAccount(Long id, ClientAccount cliAcc) {
		// TODO Auto-generated method stub
		return clientAccountReposit.findById(id)
				.map(c-> {
					return clientAccountReposit.save(cliAcc);
				}).orElseThrow(() -> new RuntimeException("Учетная запись клиента не найдена..."));
	}

	@Override
	public String deleteAccount(Long idCli) {
		// TODO Auto-generated method stub
		return null;
	}
}