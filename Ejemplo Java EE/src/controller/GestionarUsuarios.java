package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Rol;
import model.Usuario;
import model.UsuarioRol;

public class GestionarUsuarios {

	private EntityManagerFactory emf;
	private EntityManager em;
	
	private Rol rol;
	private Usuario usuario;
	private UsuarioRol usuarioRol;
	
	
	private List<Rol> roles;
	private List<Usuario> usuarios;
	private List<UsuarioRol> usuariosRoles;
	
	//Constructor
	public GestionarUsuarios() {
		this.emf = Persistence.createEntityManagerFactory("EjemploJavaEE");
		this.em = this.emf.createEntityManager();
		this.limpiar();
	}
	
	//Metodos Limpiar
	public void limpiar() {
		this.rol = new Rol();
		this.usuario = new Usuario();
		this.usuarioRol = new UsuarioRol();
	}
	
	//Metodos Roles
	public void limpiarRoles() {
		this.rol = new Rol();
		this.roles = this.consultarRoles();
	}
	
	private List<Rol> consultarRoles() {
		String jpql = " SELECT r FROM Rol r ";
		Query query = this.em.createQuery(jpql);
		List<Rol> roles = query.getResultList();
		return roles;
	}
		
	public void asignarRol(Rol rol) {
		this.rol = rol;
	}
	
	public void crearRol() {
		try {
			this.em.getTransaction().begin();
			this.em.persist(rol);
			this.em.getTransaction().commit();
			this.em = this.emf.createEntityManager();
			this.limpiarRoles();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void modificarRol() {
		try {
			this.em.getTransaction().begin();
			this.em.merge(rol);
			this.em.getTransaction().commit();
			this.em = this.emf.createEntityManager();
			this.limpiarRoles();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void eliminarRol(Rol rol) {
		this.rol = rol;
		try {
			this.em.getTransaction().begin();
			this.em.remove(rol);
			this.em.getTransaction().commit();
			this.em = this.emf.createEntityManager();
			this.limpiarRoles();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	//Metodos Usuarios
	public void limpiarUsuarios() {
		this.usuario = new Usuario();
		this.usuarios = this.consultarUsuarios();
	}
	
	private List<Usuario> consultarUsuarios() {
		String jpql = " SELECT u FROM Usuario u ";
		Query query = this.em.createQuery(jpql);
		List<Usuario> usuarios = query.getResultList();
		return usuarios;
	}
	
	//Metodos Usuarios Roles
	public void limpiarUsuariosRoles() {
		this.usuarioRol = new UsuarioRol();
		this.usuariosRoles = this.consultarUsuariosRoles();
	}
	
	public List<UsuarioRol> consultarUsuariosRoles() {
		String jpql = " SELECT ur FROM UsuarioRol ur ";
		Query query = this.em.createQuery(jpql);
		List<UsuarioRol> usuariosRoles = query.getResultList();
		return usuariosRoles;
	}

	//Gets y Setters
	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public UsuarioRol getUsuarioRol() {
		return usuarioRol;
	}

	public void setUsuarioRol(UsuarioRol usuarioRol) {
		this.usuarioRol = usuarioRol;
	}

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<UsuarioRol> getUsuariosRoles() {
		return usuariosRoles;
	}

	public void setUsuariosRoles(List<UsuarioRol> usuariosRoles) {
		this.usuariosRoles = usuariosRoles;
	}
	
}
