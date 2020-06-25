package com.sesame.Interface;

import java.util.Collection;


import com.sesame.DAO.Departements;

public interface DepartementInterface {
	public Collection<Departements> getAll();
	public Departements getId(Long id);
	public void Delete (Long id);
	public Departements Add(Departements c);
	public Departements Edit(Departements c);
	Boolean findId(Long id);
}
