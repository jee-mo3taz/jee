package com.sesame.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sesame.DAO.Etudiant;
import com.sesame.DAO.Universite;

public interface EtudiantRepository  extends JpaRepository<Etudiant,Long>{

	public List<Etudiant> findByNuminsc(long id);
	public List<Etudiant> findByNometu(String ch);
	public List<Etudiant> findByPrenometu(String ch);
	public List<Etudiant> findByCoursLibelle(String ch);

	public Page<Etudiant> findByNometu(String ch,Pageable pageable);
	
	public List<Etudiant> findByNometuContaining(String ch);//%like selon un caraceree  donnée
	
	
}
