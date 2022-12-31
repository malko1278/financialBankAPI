/**
 * 
 */
package ru.bankapi.fba.service.transaction;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import ru.bankapi.fba.entities.Transaction;
import ru.bankapi.fba.repository.TransactionRepository;

/**************************************************************************
 * Source File	 :  TransactionServiceImpl.java
 * Author        :  Franck Armel Malko
 * Project name  :  Test
 * Created       :  13/12/2022
 * Modified   	 :  13/12/2022
 * Description	 :  Definition of the class TransactionServiceImpl
 **************************************************************************/
@Service
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService {
	
	private final TransactionRepository transactionReposit = null;

	@Override
	public Transaction create(Transaction trans) {
		// TODO Auto-generated method stub
		return transactionReposit.save(trans);
	}

	@Override
	public List<Transaction> readTransactions() {
		// TODO Auto-generated method stub
		return transactionReposit.findAll();
	}

	@SuppressWarnings("null")
	@Override
	public List<Transaction> readTransactionsByAccountClient(Long idCli) {
		// TODO Auto-generated method stub
		List<Transaction> transactionAccounts = transactionReposit.findAll();
		List<Transaction> listTransactAccounts = null;
		int i = 0;
		while(transactionAccounts.size() > i) {
			if(transactionAccounts.get(i).getAccounClient().getIdent() == idCli)   listTransactAccounts.add(transactionAccounts.get(i));
			i++;
		}
		return listTransactAccounts;
	}

	@Override
	public Transaction updateTransaction(Long id, Transaction transaction) {
		// TODO Auto-generated method stub
		return transactionReposit.findById(id)
				.map(c-> {
					return transactionReposit.save(transaction);
				}).orElseThrow(() -> new RuntimeException("Транзакция не найдена..."));
	}

	@Override
	public String deleteTransaction(Long idTrans) {
		// TODO Auto-generated method stub
		return null;
	}
}