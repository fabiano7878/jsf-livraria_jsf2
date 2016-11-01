package br.com.caelum.livraria.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.livraria.dao.AutorDAO;
import br.com.caelum.livraria.modelo.Autor;
import br.com.caelum.livraria.modelo.AutorDataModel;
import br.com.caelum.livraria.tx.Transacional;
import br.com.caelum.livraria.util.RedirectView;

@Named
@ViewScoped
public class AutorBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Autor autor = new Autor();
	private List<Autor> autores;
	private AutorDataModel autorDataModel = new AutorDataModel();
	
	@Inject
	private AutorDAO dao;
	
	@Inject
	FacesContext context;
	
	public Autor getAutor() {
		return autor;
	}
	
	@Transacional
	public RedirectView gravar() {
		RedirectView rv = new RedirectView("autor");
		if (this.autor.getId() == null) {
			System.out.println("Gravando autor: " + this.autor.getNome());
			this.dao.adiciona(this.autor);
			this.autores = this.dao.listaTodos();
		} else if ("/login.xhtml".equals((String) context.getExternalContext()
				.getSessionMap().get("paginaAnterior"))) {
			System.out.println("Atualizando dados do autor: e direcionando para pagina Livro"
					+ this.autor.getNome());
			this.dao.atualiza(this.autor);
		} else {
			System.out.println("Atualizando dados do autor: e fica na pagina Autor."
					+ this.autor.getNome());
			this.dao.atualiza(this.autor);
			rv = new RedirectView("autor");
		}
		this.autor = new Autor();
		return rv;
	}

	public void carregar(Autor pAutor) {
		System.out.println("Carregar/Atualizar o autor.");
		this.autor = pAutor;
	}
	
	@Transacional
	public void remover(Autor autor) {
		System.out.println("Removendo autor");
		this.dao.remove(autor);
		this.autores = this.dao.listaTodos();
		
	}

	public void carregaAutorPorId() {
		System.out.println("Carrega Autor por Id!");
		this.autor = this.dao.buscaPorId(this.autor
				.getAutorId());
	}

	/**
	 * @return the autores
	 */
	public List<Autor> getAutores() {
		if(this.autores == null){
			this.autores = this.dao.listaTodos(); 
		}
		return autores;
	}

	/**
	 * @return the autorDataModel
	 */
	public AutorDataModel getAutorDataModel() {
		return autorDataModel;
	}
	
	
}
