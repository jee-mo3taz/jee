package com.sesame.Interface;

import java.util.Collection;

import com.sesame.DAO.Enseignant;

public interface EnseignantInterface {
	public Collection<Enseignant> getAll();
	public Enseignant getId(Long id);
	public void Delete (Long id);
	public Enseignant Add(Enseignant c);
	public Enseignant Edit(Enseignant c);
	Boolean findId(Long id);
}
