package com.sesame.Interface;

import java.util.Collection;

import com.sesame.DAO.Salle;

public interface SalleInterface {
	public Collection<Salle> getAll();
	public Salle getId(Long id);
	public void Delete (Long id);
	public Salle Add(Salle c);
	public Salle Edit(Salle c);
	Boolean findId(Long id);
}
