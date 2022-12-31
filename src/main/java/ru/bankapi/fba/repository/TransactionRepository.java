/**
 * 
 */
package ru.bankapi.fba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.bankapi.fba.entities.Transaction;

/**************************************************************************
 * Source File	 :  TransactionRepository.java
 * Author        :  Franck Armel Malko
 * Project name  :  Test
 * Created       :  13/12/2022
 * Modified   	 :  13/12/2022
 * Description	 :  Definition of the class TransactionRepository
 **************************************************************************/
public interface TransactionRepository extends JpaRepository<Transaction, Long> {}