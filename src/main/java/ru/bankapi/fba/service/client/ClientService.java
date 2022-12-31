package ru.bankapi.fba.service.client;

import java.util.List;

import ru.bankapi.fba.entities.Client;

/**************************************************************************
 * Source File	 :  ClientService.java
 * Author        :  Franck Armel Malko
 * Project name  :  Test
 * Created       :  13/12/2022
 * Modified   	 :  13/12/2022
 * Description	 :  Definition of the class ClientService
 **************************************************************************/
public interface ClientService {
	Client create(Client client);
	List<Client> readClients();
	Client readClientByID(Long idCli);
	Client updateClient(Long id, Client client);
	String deleteClient(Long idCli);
}