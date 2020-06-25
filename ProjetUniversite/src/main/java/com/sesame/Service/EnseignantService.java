package com.sesame.Service;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sesame.DAO.Enseignant;
import com.sesame.Interface.EnseignantInterface;
import com.sesame.Repository.EnseignantRepository;

@Service
public class EnseignantService implements EnseignantInterface{
	@Autowired
	private EnseignantRepository ens;
	@Transactional
	@Override
	public Collection<Enseignant> getAll() {
		// TODO Auto-generated method stub
		return ens.findAll();
	}

	@Override
	public Enseignant getId(Long id) {
		// TODO Auto-generated method stub
		return ens.findById(id).get();
	}

	@Override
	public void Delete(Long id) {
		// TODO Auto-generated method stub
		ens.deleteById(id);
	}

	@Override
	public Enseignant Add(Enseignant c) {
		// TODO Auto-generated method stub
		return ens.save(c);
	}

	@Override
	public Enseignant Edit(Enseignant c) {
		// TODO Auto-generated method stub
		return ens.saveAndFlush(c);
	}

	
	@Override
	public Boolean findId(Long id) {
		// TODO Auto-generated method stub
		boolean res=false;
		if (ens.findByMatricul(id)==null){
				res=false;	
				}
		else {
		res=true;
		}
		return res;
	}
}
