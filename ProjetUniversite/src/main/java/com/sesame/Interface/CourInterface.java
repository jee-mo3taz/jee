package com.sesame.Interface;

import java.util.Collection;


import com.sesame.DAO.Cours;

public interface CourInterface {
	public Collection<Cours> getAll();
	public Cours getId(Long id);
	public void Delete (Long id);
	public Cours Add(Cours c);
	public Cours Edit(Cours c);
	Boolean findId(Long id);
	public Collection<Object> findAllCoursBySalle();
}
