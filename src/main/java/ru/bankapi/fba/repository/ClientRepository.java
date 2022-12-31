/**
 * 
 */
package ru.bankapi.fba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.bankapi.fba.entities.Client;

/**************************************************************************
 * Source File	 :  ClientRepository.java
 * Author        :  Franck Armel Malko
 * Project name  :  Test
 * Created       :  13/12/2022
 * Modified   	 :  13/12/2022
 * Description	 :  Definition of the class ClientRepository
 **************************************************************************/
public interface ClientRepository extends JpaRepository<Client, Long> {}