package com.example.usuario.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.example.usuario.entity.Usuarios;


public interface IUsuarioDao extends PagingAndSortingRepository<Usuarios, Long> {
	
	public List<Usuarios> findByid(Long id);
	public List<Usuarios> findAll();
	boolean existsByid(Long id);
	@Query(value = "SELECT * FROM TBL_USUARIOS t WHERE t.id=:id",nativeQuery = true)
	public Usuarios NativefindByid(@Param("id") Long id);
	
	@Query(value = "SELECT * FROM TBL_USUARIOS LIMIT 100",nativeQuery = true)
	public Page<Usuarios> findUsuarioPage(Pageable pageable);

	/*Extrae el ultimo numero de turno*/ 
	@Query(value = "SELECT MAX(id) "
			+ "FROM TBL_USUARIOS" ,nativeQuery = true)
	public Long findMaxByUsuarioParamsNative();
}
