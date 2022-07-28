package com.example.usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.usuario.entity.Usuarios;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuarios, Long> {

    public boolean existsByid(Long id);

}
