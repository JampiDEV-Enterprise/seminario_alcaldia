package com.web.repository.servicesImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.entities.Usuario;
import com.web.repository.dao.IUsuarioDao;
import com.web.repository.services.UsuarioService;

@Service
public class UserServiceImpl implements UsuarioService{

	@Autowired
	private IUsuarioDao userDao;
	
	@Override
	@Transactional
	public Usuario save(Usuario usuario) {
		// TODO Auto-generated method stub
		return userDao.save(usuario);
	}

	@Override
	@Transactional
	public Usuario findByEmail(String email) {
		// TODO Auto-generated method stub
		return userDao.findByEmail(email);
	}

	@Override
	@Transactional
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}
	

}
