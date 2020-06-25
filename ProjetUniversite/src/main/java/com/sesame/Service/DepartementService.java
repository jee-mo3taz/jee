package com.sesame.Service;

import java.util.Collection;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sesame.DAO.Departements;
import com.sesame.Interface.DepartementInterface;
import com.sesame.Repository.DepartementRepository;

@Service
public class DepartementService implements DepartementInterface {
	@Autowired
	private DepartementRepository dep;
	@Transactional
	@Override
	public Collection<Departements> getAll() {
		// TODO Auto-generated method stub
		return dep.findAll();
	}

	@Override
	public Departements getId(Long id) {
		// TODO Auto-generated method stub
		return dep.findById(id).get();
	}

	@Override
	public void Delete(Long id) {
		// TODO Auto-generated method stub
		dep.deleteById(id);
	}

	@Override
	public Departements Add(Departements c) {
		// TODO Auto-generated method stub
		return dep.save(c);
	}

	@Override
	public Departements Edit(Departements c) {
		// TODO Auto-generated method stub
		return dep.saveAndFlush(c);
	}
	
	
	@Override
	public Boolean findId(Long id) {
		// TODO Auto-generated method stub
		boolean res=false;
		if (dep.findByCodedep(id)==null){
				res=false;	
				}
		else {
		res=true;
		}
		return res;
	}

}
