package com.sesame.Interface;

import java.util.Collection;

import com.sesame.DAO.Universite;

public interface UniversiteInterface {

	public Collection<Universite> getAll();
	public Universite getId(Long id);
	public Boolean findId(Long id);
	public void Delete (Long id);
	public Universite Add(Universite c);
	public Universite Edit(Universite c);
}
