package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.dao.nDao;
import com.example.demo.entity.Nvo;
import com.example.demo.service.nService;


@Service
public class nServiceImpl implements nService {

	@Autowired
	private nDao ndao;

	@Override
	public List<Nvo> getList() {
		// TODO Auto-generated method stub
		return ndao.findAll();
	}

	@Override
	public void save(Nvo nvo) {
		// TODO Auto-generated method stub
//		Nvo n = new Nvo();
//		n.setImgName(nvo.getImgName());
//		n.setImgOriName(nvo.getImgOriName());
//		n.setImgUrl(nvo.getImgUrl());
		ndao.save(nvo);
	}

	@Override
	public Nvo getByIdx(long idx) {
		// TODO Auto-generated method stub
		return ndao.findByIdx(idx);
	}
	//idx를 가져와서 보기위함이고

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
	//idx를 찾아서 데이터를 수정해줄것이기 때문에 entity를 매개변수로 받은것임

	@Override
	public void deleteByIdx(long idx) {
		// TODO Auto-generated method stub
		ndao.deleteById(idx);
	}


	@Override
	public List<Nvo> findByTitleContainingIgnoreCase(String keyword) {
		// TODO Auto-generated method stub
		return ndao.findByTitleContainingIgnoreCase(keyword);
	}





	public Page<Nvo> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return ndao.findAll(pageable);
	}

	@Override
	public List<Nvo> findByWriterContainingIgnoreCase(String keyWord) {
		// TODO Auto-generated method stub
		return ndao.findByWriterContainingIgnoreCase(keyWord);
	}

//	@Override
//	public Page<Nvo> findAll(
//			org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable pageable) {
//		// TODO Auto-generated method stub
//		return null;
//	}








}
