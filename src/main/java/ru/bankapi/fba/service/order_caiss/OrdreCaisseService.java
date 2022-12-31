/**
 * 
 */
package ru.bankapi.fba.service.order_caiss;

import java.util.List;

import ru.bankapi.fba.entities.OrdreCaisse;

/**************************************************************************
 * Source File	 :  OrdreCaisseService.java
 * Author        :  Franck Armel Malko
 * Project name  :  Test
 * Created       :  13/12/2022
 * Modified   	 :  13/12/2022
 * Description	 :  Definition of the class OrdreCaisseService
 **************************************************************************/
public interface OrdreCaisseService {
	OrdreCaisse create(OrdreCaisse oderCaiss);
	List<OrdreCaisse> readOrder_caisse();
	List<OrdreCaisse> readOrder_caisseByAccountClient(Long idCli);
	OrdreCaisse updateOrdreCaisse(Long id, OrdreCaisse orderCais);
	String deleteOrderCaisse(Long idOrder);
}