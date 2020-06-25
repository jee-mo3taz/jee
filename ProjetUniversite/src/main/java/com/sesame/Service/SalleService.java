package com.sesame.Service;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sesame.DAO.Salle;
import com.sesame.Interface.SalleInterface;
import com.sesame.Repository.SalleRepository;

@Service
public class SalleService implements SalleInterface{

	@Autowired
	private SalleRepository salle;
	@Transactional
	@Override
	public Collection<Salle> getAll() {
		// TODO Auto-generated method stub
		return salle.findAll();
	}

	@Override
	public Salle getId(Long id) {
		// TODO Auto-generated method stub
		return salle.findById(id).get();
	}

	@Override
	public void Delete(Long id) {
		// TODO Auto-generated method stub
		salle.deleteById(id);
	}

	@Override
	public Salle Add(Salle c) {
		// TODO Auto-generated method stub
		return salle.save(c);
	}

	@Override
	public Salle Edit(Salle c) {
		// TODO Auto-generated method stub
		return salle.saveAndFlush(c);
	}

	
	@Override
	public Boolean findId(Long id) {
		// TODO Auto-generated method stub
		boolean res=false;
		if (salle.findByNumS(id)==null){
				res=false;	
				}
		else {
		res=true;
		}
		return res;
	}
}
