package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the usuario_rol database table.
 * 
 */
@Entity
@Table(name="usuario_rol")
public class UsuarioRol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String consecutivo;

	private byte vigente;

	//bi-directional many-to-one association to Rol
	@ManyToOne
	@JoinColumn(name="codigo_rol")
	private Rol rol;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="login_usuario")
	private Usuario usuario;

	public UsuarioRol() {
	}

	public String getConsecutivo() {
		return this.consecutivo;
	}

	public void setConsecutivo(String consecutivo) {
		this.consecutivo = consecutivo;
	}

	public byte getVigente() {
		return this.vigente;
	}

	public void setVigente(byte vigente) {
		this.vigente = vigente;
	}

	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}