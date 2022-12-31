/**
 * 
 */
package ru.bankapi.fba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.bankapi.fba.entities.OrdreCaisse;

/**************************************************************************
 * Source File	 :  OrdreCaisseRepository.java
 * Author        :  Franck Armel Malko
 * Project name  :  Test
 * Created       :  13/12/2022
 * Modified   	 :  13/12/2022
 * Description	 :  Definition of the class OrdreCaisseRepository
 **************************************************************************/
public interface OrdreCaisseRepository extends JpaRepository<OrdreCaisse, Long> {}