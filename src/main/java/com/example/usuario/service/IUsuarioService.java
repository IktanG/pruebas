package com.example.usuario.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.usuario.entity.Usuarios;

@Service
public interface IUsuarioService {

	public List<Usuarios> findByid(Long id);
	public void save(Usuarios usuario);
	public List<Usuarios> findAll();
	boolean existsByid(Long id);
	public Usuarios NativefindByid(Long id);
	public void deleteById(Long id);
	public Page<Usuarios> findUsuarioPage(Pageable pageable);
	public Long findMaxByUsuarioParamsNative();
}
