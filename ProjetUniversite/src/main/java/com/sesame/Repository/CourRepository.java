package com.sesame.Repository;

import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sesame.DAO.Cours;
import com.sesame.DAO.Universite;

public interface CourRepository  extends JpaRepository<Cours,Long> {

	public List<Cours> findByLibelle(String ch);
	//public List<Cours> findByCode_C(Long id);
	public List<Cours> findByEtudiantNometu(String ch);
	public List<Cours> findByEnseignantNomens(String ch);

	public Page<Cours> findByLibelle(String ch,Pageable pageable);
	
	public List<Cours> findByLibelleContaining(String ch);//%like selon un caraceree  donnée
	
	@Query( value = "SELECT c,c FROM cours,salle WHERE c.code_C=s.code_C  ", nativeQuery = true)
	public List<Object> findAllCoursBySalle();

}
