package com.sesame.Service;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sesame.DAO.Universite;
import com.sesame.Interface.UniversiteInterface;
import com.sesame.Repository.UniversiteRepository;

@Service
public class UniversiteService implements UniversiteInterface {

	@Autowired
	private UniversiteRepository ur;
	
	@Transactional
	@Override
	public Collection<Universite> getAll() {
		
		return ur.findAll();
	}

	@Override
	public Universite getId(Long id) {
	
		return ur.findById(id).get();
	}

	@Override
	public void Delete(Long id) {
	
		ur.deleteById(id);
	}

	@Override
	public Universite Add(Universite c) {
		
		return ur.save(c);
	}

	@Override
	public Universite Edit(Universite c) {
	
		return ur.saveAndFlush(c);
	}

	@Override
	public Boolean findId(Long id) {
		
		boolean res=false;
		if (ur.findByCodeuniv(id)==null){
				res=false;	
				}
		else {
		res=true;
		}
		return res;
	}
	
	
}
