package br.com.pectrus.login;

import java.io.Serializable;
import java.util.Date;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;

@ManagedBean
@SessionScoped
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	static Usuario usuario = null ;
	
	public Usuario(){
		super();
	}
	
	public static Usuario newUsuario(){
		if(usuario == null){
			usuario = new Usuario();
		}
		return usuario ;
	}
	
	private String nome;
	private Date dataLogin;
	
	public boolean isLogado() {
		if(nome == null){
			return false;
		}else{
			return true ;
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataLogin() {
		return dataLogin;
	}

	public void setDataLogin(Date dataLogin) {
		this.dataLogin = dataLogin;
	}

}