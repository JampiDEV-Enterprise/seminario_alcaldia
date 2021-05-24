package com.web.repository.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.entities.Noticia;
import com.web.repository.dao.INoticiaDao;
import com.web.repository.services.NoticiaService;

@Service
public class NoticiaServiceImpl implements NoticiaService {

	@Autowired
	private INoticiaDao noticiaDao;
	
	@Override
	public List<Noticia> findAll() {
		try {
			return (List<Noticia>)noticiaDao.findAll();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public Noticia findById(int id) {
		try {
			return noticiaDao.findById(id).orElse(null);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public String remove(int id) {
		try {
			noticiaDao.deleteById(id);
			return "Noticia eliminada";
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public Noticia save(Noticia noticia) {
		try {
			return noticiaDao.save(noticia);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
