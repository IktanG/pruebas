package com.example.usuario.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="TBL_USUARIOS")
public class Usuarios implements Serializable{

		private static final long serialVersionUID = 1L;
		
		@Id
		@Column(name = "id")
		@JsonProperty("id")
		private Long id;
		
		@Column(name = "nombre", length = 40)
		@JsonProperty("nombre")
		private String nombre;
		
		@Column(name = "email",length = 100)
		@JsonProperty("email")
		private String email;
		
		@Column(name = "gender",length = 100)
		@JsonProperty("gender")
		private String gender;
		
		@Column(name = "estatus")
		@JsonProperty("estatus")
		private Integer estatus;
		
		@Column(name = "imagen")
		@JsonProperty("imagen")
		private String imagen;


		//--------------------Metodo Get y SET----------------------------------	
		

		
		@JsonProperty("id")
		public Long getId() {
			return id;
		}
		@JsonProperty("id")
		public void setId(Long id) {
			this.id = id;
		}
		@JsonProperty("nombre")
		public String getNombre() {
			return nombre;
		}
		
		@JsonProperty("nombre")
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		@JsonProperty("email")
		public String getEmail() {
			return email;
		}
		@JsonProperty("email")
		public void setEmail(String email) {
			this.email = email;
		}
		@JsonProperty("gender")
		public String getGender() {
			return gender;
		}
		@JsonProperty("gender")
		public void setGender(String gender) {
			this.gender = gender;
		}
		@JsonProperty("estatus")
		public Integer getEstatus() {
			return estatus;
		}
		@JsonProperty("estatus")
		public void setEstatus(Integer estatus) {
			this.estatus = estatus;
		}
		@JsonProperty("imagen")
		public String getImagen() {
			return imagen;
		}
		@JsonProperty("imagen")
		public void setImagen(String imagen) {
			this.imagen = imagen;
		}
		
		//----------------------Metodo Constructor -----------------------------------
		public Usuarios() {
			super();
		}
		public Usuarios(Long id, String nombre, String email, String gender, Integer estatus, String imagen) {
			this.id= id;
			this.nombre = nombre;
			this.email = email;
			this.gender = gender;
			this.estatus = estatus;
			this.imagen = imagen;
		}
}

