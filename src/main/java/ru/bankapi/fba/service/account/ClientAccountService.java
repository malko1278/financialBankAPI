/**
 * 
 */
package ru.bankapi.fba.service.account;

import java.util.List;

import ru.bankapi.fba.entities.ClientAccount;

/**************************************************************************
 * Source File	 :  ClientAccountService.java
 * Author        :  Franck Armel Malko
 * Project name  :  Test
 * Created       :  13/12/2022
 * Modified   	 :  13/12/2022
 * Description	 :  Definition of the class ClientAccountService
 **************************************************************************/
public interface ClientAccountService {
	ClientAccount create(ClientAccount clientAcc);
	List<ClientAccount> readAccounts();
	ClientAccount readAccountClient(Long idCli);
	List<ClientAccount> readAccountsClient(Long idCli);
	ClientAccount updateAccount(Long id, ClientAccount cliAcc);
	String deleteAccount(Long idCli);
}