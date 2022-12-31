/**
 * 
 */
package ru.bankapi.fba.service.client;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import ru.bankapi.fba.entities.Client;
import ru.bankapi.fba.exception.ResourceNotFoundException;
import ru.bankapi.fba.repository.ClientRepository;

/**************************************************************************
 * Source File	 :  ClientServiceImpl.java
 * Author        :  Franck Armel Malko
 * Project name  :  Test
 * Created       :  13/12/2022
 * Modified   	 :  13/12/2022
 * Description	 :  Definition of the class ClientServiceImpl
 **************************************************************************/
@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {
	
	private final ClientRepository clientReposit = null;

	@Override
	public Client create(Client client) {
		// TODO Auto-generated method stub
		return clientReposit.save(client);
	}

	@Override
	public List<Client> readClients() {
		// TODO Auto-generated method stub
		return clientReposit.findAll();
	}

	@Override
	public Client readClientByID(Long idCli) {
		// TODO Auto-generated method stub
		return clientReposit.findById(idCli).orElseThrow(() -> new ResourceNotFoundException("" + idCli));
	}

	@Override
	public Client updateClient(Long id, Client client) {
		// TODO Auto-generated method stub
		return clientReposit.findById(id)
				.map(c-> {
					return clientReposit.save(client);
				}).orElseThrow(() -> new RuntimeException("Клиент не найден..."));
	}

	@Override
	public String deleteClient(Long idCli) {
		// TODO Auto-generated method stub
		return null;
	}
}