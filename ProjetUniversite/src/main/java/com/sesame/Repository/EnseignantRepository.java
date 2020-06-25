package com.sesame.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sesame.DAO.Enseignant;
import com.sesame.DAO.Universite;

public interface EnseignantRepository  extends JpaRepository<Enseignant,Long> {

	public List<Enseignant> findByMatricul(Long id);
	public List<Enseignant> findByNomens(String ch);
	public List<Enseignant> findByPrenomens(String ch);
	public List<Enseignant> findByCoursLibelle(String ch);
	public List<Enseignant> findByDepartementsNomdep(String ch);

	public Page<Enseignant> findByNomens(String ch,Pageable pageable);
	
	public List<Enseignant> findByNomensContaining(String ch);//%like selon un caraceree  donnée
	
}
