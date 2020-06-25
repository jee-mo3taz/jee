package com.sesame.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sesame.DAO.Salle;
import com.sesame.DAO.Universite;

public interface SalleRepository  extends JpaRepository<Salle,Long> {

	
	public List<Salle> findByNomS(String ch);
	public List<Salle> findByCoursLibelle(String ch);
	public List<Salle> findByNumS(Long id);

	public Page<Salle> findByNomS(String ch,Pageable pageable);
	
	public List<Salle> findByNomSContaining(String ch);//%like selon un caraceree  donnée
	
}
