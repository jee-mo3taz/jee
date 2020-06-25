package com.sesame.Interface;

import java.util.Collection;

import com.sesame.DAO.Etudiant;

public interface EtudiantInterface {
	public Collection<Etudiant> getAll();
	public Etudiant getId(Long id);
	public void Delete (Long id);
	public Etudiant Add(Etudiant c);
	public Etudiant Edit(Etudiant c);
	Boolean findId(Long id);
}
