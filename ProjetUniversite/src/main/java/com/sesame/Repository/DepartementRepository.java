package com.sesame.Repository;

import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sesame.DAO.Departements;
import com.sesame.DAO.Universite;

public interface DepartementRepository  extends JpaRepository<Departements,Long> {

	public List<Departements> findByCodedep(long id);
	public List<Departements> findByNomdep(String ch);
	public List<Departements> findByUniversiteNomuniv(String ch);

	public Page<Departements> findByNomdep(String ch,Pageable pageable);
	
	public List<Departements> findByNomdepContaining(String ch);//%like selon un caraceree  donnée
}
