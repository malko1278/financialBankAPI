/**
 * 
 */
package ru.bankapi.fba.service.transaction;

import java.util.List;

import ru.bankapi.fba.entities.Transaction;

/**************************************************************************
 * Source File	 :  TransactionService.java
 * Author        :  Franck Armel Malko
 * Project name  :  Test
 * Created       :  13/12/2022
 * Modified   	 :  13/12/2022
 * Description	 :  Definition of the class TransactionService
 **************************************************************************/
public interface TransactionService {
	Transaction create(Transaction trans);
	List<Transaction> readTransactions();
	List<Transaction> readTransactionsByAccountClient(Long idCli);
	Transaction updateTransaction(Long id, Transaction transaction);
	String deleteTransaction(Long idTrans);
}