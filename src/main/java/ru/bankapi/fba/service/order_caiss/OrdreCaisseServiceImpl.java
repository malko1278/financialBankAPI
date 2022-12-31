/**
 * 
 */
package ru.bankapi.fba.service.order_caiss;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import ru.bankapi.fba.entities.OrdreCaisse;
import ru.bankapi.fba.repository.OrdreCaisseRepository;

/**************************************************************************
 * Source File	 :  OrdreCaisseServiceImpl.java
 * Author        :  Franck Armel Malko
 * Project name  :  Test
 * Created       :  13/12/2022
 * Modified   	 :  13/12/2022
 * Description	 :  Definition of the class OrdreCaisseServiceImpl
 **************************************************************************/
@Service
@AllArgsConstructor
public class OrdreCaisseServiceImpl implements OrdreCaisseService {
	
	private final OrdreCaisseRepository orderCaissReposit = null;

	@Override
	public OrdreCaisse create(OrdreCaisse oderCaiss) {
		// TODO Auto-generated method stub
		return orderCaissReposit.save(oderCaiss);
	}

	@Override
	public List<OrdreCaisse> readOrder_caisse() {
		// TODO Auto-generated method stub
		return orderCaissReposit.findAll();
	}

	@SuppressWarnings("null")
	@Override
	public List<OrdreCaisse> readOrder_caisseByAccountClient(Long idCli) {
		// TODO Auto-generated method stub
		List<OrdreCaisse> checkOutAccounts = orderCaissReposit.findAll();
		List<OrdreCaisse> listCheckOutAccounts = null;
		int i = 0;
		while(checkOutAccounts.size() > i) {
			if(checkOutAccounts.get(i).getAccountCliCheck().getIdent() == idCli)
				listCheckOutAccounts.add(checkOutAccounts.get(i));
			i++;
		}
		return listCheckOutAccounts;
	}

	@Override
	public OrdreCaisse updateOrdreCaisse(Long id, OrdreCaisse orderCais) {
		// TODO Auto-generated method stub
		return orderCaissReposit.findById(id)
				.map(c-> {
					return orderCaissReposit.save(orderCais);
				}).orElseThrow(() -> new RuntimeException("Заказ на оформление заказа не найден..."));
	}

	@Override
	public String deleteOrderCaisse(Long idOrder) {
		// TODO Auto-generated method stub
		return null;
	}
}