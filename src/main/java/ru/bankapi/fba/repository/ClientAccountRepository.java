/**
 * 
 */
package ru.bankapi.fba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.bankapi.fba.entities.ClientAccount;

/**************************************************************************
 * Source File	 :  ClientAccountRepository.java
 * Author        :  Franck Armel Malko
 * Project name  :  Test
 * Created       :  13/12/2022
 * Modified   	 :  13/12/2022
 * Description	 :  Definition of the class ClientAccountRepository
 **************************************************************************/
public interface ClientAccountRepository extends JpaRepository<ClientAccount, Long> {}