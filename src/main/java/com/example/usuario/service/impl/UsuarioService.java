package com.example.usuario.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.usuario.dao.IUsuarioDao;
import com.example.usuario.entity.Usuarios;
import com.example.usuario.repository.IUsuarioRepository;
import com.example.usuario.service.IUsuarioService;



@Service
public class UsuarioService  implements IUsuarioService{

	@Autowired
	private IUsuarioDao usuarioDao;
	
	@Autowired
	private IUsuarioRepository usuariorepo;


	@Override
	@Transactional(readOnly = true)
	public List<Usuarios> findByid(Long id) {
		// TODO Auto-generated method stub
		return usuarioDao.findByid(id);
	}

	@Override
	public void save(Usuarios usuario) {
		// TODO Auto-generated method stub
		usuarioDao.save(usuario);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Usuarios> findAll() {
		// TODO Auto-generated method stub
		return usuarioDao.findAll();
	}

	@Override
	public boolean existsByid(Long id) {
		// TODO Auto-generated method stub
		return usuariorepo.existsByid(id);
	}

	@Override
	public Usuarios NativefindByid(Long id) {
		// TODO Auto-generated method stub
		return usuarioDao.NativefindByid(id);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		usuarioDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Usuarios> findUsuarioPage(Pageable pageable) {
		// TODO Auto-generated method stub
		return usuarioDao.findUsuarioPage(pageable);
	}

	@Override
	public Long findMaxByUsuarioParamsNative() {
		// TODO Auto-generated method stub
		return usuarioDao.findMaxByUsuarioParamsNative();
	}



}
