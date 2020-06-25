package com.sesame.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sesame.DAO.Universite;

public interface UniversiteRepository extends JpaRepository<Universite,Long> {

	public List<Universite> findByNomuniv(String ch);
	public List<Universite> findByCodeuniv(Long id);
	//public Boolean findByCodeUNV(Long id);

	//public List<Universite> findByDepartementsNomDEP(String ch);

	public Page<Universite> findByNomuniv(String ch,Pageable pageable);
	
	public List<Universite> findByNomunivContaining(String ch);//%like selon un caraceree  donnée


}
