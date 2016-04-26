package com.algaworks.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.pectrus.login.Usuario;

import com.algaworks.model.Candidato;

@ManagedBean
@SessionScoped
public class CandidatosManager implements Serializable {

	private static final long serialVersionUID = 1L;

	private Usuario usuario = Usuario.newUsuario();

	public Candidato candidatoEdicao = new Candidato("", "", false);
	public List<Candidato> candidatos = new ArrayList<Candidato>();

	public CandidatosManager() {

		candidatos.add(new Candidato("rafael", "001", true));
		for (int i = 0; i < 4; i++) {
			candidatos.add(new Candidato("candidato_" + i, "00" + i, true));
		}

	}

	public String candidatoEdicao() {
		candidatoEdicao = new Candidato("edicao", "edicao", true);
		return "Votacao?faces-redirect=true";
	}

	public String novoCandidato() {
		candidatoEdicao = new Candidato("novo", "001", true);
		return "Votacao?faces-redirect=true";
	}

	public void salvar() {
		if (!candidatos.contains(candidatoEdicao)) {
			candidatos.add(candidatoEdicao);
		}
		candidatoEdicao = new Candidato("", "", true);

		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Candidato salvo com sucesso!"));
	}

	public List<Candidato> getClientes() {
		return candidatos;
	}

	public Candidato getCandidatoEdicao() {
		return candidatoEdicao;
	}

	public void setCandidatoEdicao(Candidato candidato) {
		this.candidatoEdicao = candidato;
	}

	public String login() {
		FacesContext context = FacesContext.getCurrentInstance();
		if ("admin".equals("admin") && "admin".equals("admin")) {
			this.usuario.setNome("admin");
			this.usuario.setDataLogin(new Date());

			return "/Votacao?faces-redirect=true";
		} else {
			FacesMessage mensagem = new FacesMessage("Usuário/senha inválidos!");
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
		}
		return null;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Candidato> getCandidatos() {
		return candidatos;
	}

	public void setCandidatos(List<Candidato> candidatos) {
		this.candidatos = candidatos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}