package com.sesame.Service;

import java.util.Collection;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sesame.DAO.Cours;
import com.sesame.Interface.CourInterface;
import com.sesame.Repository.CourRepository;

@Service
public class CourService  implements CourInterface{
	@Autowired
	private CourRepository cours;
	@Transactional
	@Override
	public Collection<Cours> getAll() {
		// TODO Auto-generated method stub
		return cours.findAll();
	}

	@Override
	public Cours getId(Long id) {
		// TODO Auto-generated method stub
		return cours.findById(id).get();
	}

	@Override
	public void Delete(Long id) {
		// TODO Auto-generated method stub
		cours.deleteById(id);
	}

	@Override
	public Cours Add(Cours c) {
		// TODO Auto-generated method stub
		return cours.save(c);
	}

	@Override
	public Cours Edit(Cours c) {
		// TODO Auto-generated method stub
		return cours.saveAndFlush(c);
	}

	@Override
	public Boolean findId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Object> findAllCoursBySalle() {
		// TODO Auto-generated method stub
		return cours.findAllCoursBySalle();
	}
	
//	
//	@Override
//	public Boolean findId(Long code_c) {
//		// TODO Auto-generated method stub
//		boolean res=false;
//		if (cours.findByCode_C(code_c)==null){
//				res=false;	
//				}
//		else {
//		res=true;
//		}
//		return res;
//	}

}
