package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.nDao;
import com.example.demo.entity.Nvo;
import com.example.demo.service.nService;

@Service
public class nServiceImpl implements nService {
	
	@Autowired
	nDao ndao;
	
	@Override
	public List<Nvo> getList() {
		// TODO Auto-generated method stub
		return ndao.findAll();
	}

	@Override
	public void save(Nvo nvo) {
		// TODO Auto-generated method stub
		ndao.save(nvo);
	}

	@Override
	public Nvo getByIdx(long idx) {
		// TODO Auto-generated method stub
		return ndao.findByIdx(idx);
	}


	@Override
	public Nvo findByIdx(long idx) {
		// TODO Auto-generated method stub
		Nvo nvo = ndao.findByIdx(idx);
		return nvo;
	}

	
	@Override
	public void update(Nvo nvo) {
		// TODO Auto-generated method stub
		ndao.findByIdx(nvo.getIdx());
		ndao.save(nvo);
	}

	@Override
	public void deleteByIdx(long idx) {
		// TODO Auto-generated method stub
		ndao.deleteById(idx);
	}
}
