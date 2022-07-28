package com.example.usuario.controller;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.usuario.entity.Usuarios;
import com.example.usuario.service.IUsuarioService;

@RestController
@RequestMapping("/User")
public class UsuariosRestController {

	@Autowired
	private IUsuarioService usuarioService;

	// ---------------------Muestra el listado de usuarios
	// registrados-----------------------------
	@GetMapping("/All")
	public ResponseEntity<?> UserList() {
		List<Usuarios> listadoU = usuarioService.findAll();
		if (listadoU.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Usuarios>>(listadoU, HttpStatus.OK);
	}

	// --------------------------------Crea un nuevo
	// usuario--------------------------------
	@PostMapping("/New")
	public ResponseEntity<?> NewUser(@Valid @RequestBody Usuarios usuario) {
		Long id= usuarioService.findMaxByUsuarioParamsNative();
		Usuarios newUser = new Usuarios(id+1, usuario.getNombre(), usuario.getEmail(), usuario.getGender(),
				usuario.getEstatus(), usuario.getImagen());
		usuarioService.save(newUser);
		return new ResponseEntity<>("Usuario Registrado Correctamente", HttpStatus.OK);

	}

	@GetMapping("/Search/{usuario}")
	public ResponseEntity<?> SearchUser(@PathVariable(value = "usuario") Long id) {
		Usuarios listadoU = usuarioService.NativefindByid(id);
		if (listadoU == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(listadoU, HttpStatus.OK);
	}

	@DeleteMapping("/Delete/{idusuario}")
	public ResponseEntity<?> DeleteUserID(@PathVariable(value = "idusuario") Long id) {
		if (usuarioService.existsByid(id) == false) {
			return new ResponseEntity<>("Usuario no encontrado", HttpStatus.BAD_REQUEST);
		}
		usuarioService.deleteById(id);
		return new ResponseEntity<>("Usuario Eliminado", HttpStatus.OK);
	}

	@GetMapping("/List/{page}")
	public ResponseEntity<?> UsuarioPage(Pageable pageResquest) {
		Page<Usuarios> ListUsuario = usuarioService.findUsuarioPage(pageResquest);
		if (ListUsuario.isEmpty()) {
			return new ResponseEntity<>("Usuarios no encontrados", HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Page<Usuarios>>(ListUsuario, HttpStatus.OK);
	}
	
	//--------------------------------Actualizar informacion del usuario--------------------------------
	@PutMapping("/Update")
    public ResponseEntity<?> UpdateUser(@Valid @RequestBody Usuarios usuario){
         if(usuarioService.existsByid(usuario.getId())==false){
             return new ResponseEntity<>("Usuario no Existente",HttpStatus.NO_CONTENT);
         }
         Usuarios ActUser = new Usuarios(usuario.getId(),usuario.getNombre(), usuario.getEmail(), usuario.getGender(),
 				usuario.getEstatus(), usuario.getImagen());
         usuarioService.save(ActUser);      
         return new ResponseEntity<>("Usuario Actualizado Correctamente",HttpStatus.OK);
     }

}
