package br.com.caelum.livraria.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.caelum.livraria.interceptors.Log;
import br.com.caelum.livraria.modelo.Venda;

public class VendaDAO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager em;
	
	private DAO<Venda> dao;
	
	@PostConstruct
	public void init(){
		this.dao = new DAO<Venda>(em, Venda.class);
	}

	/**
	 * @return
	 * @see br.com.caelum.livraria.dao.DAO#listaTodos()
	 */
	@Log
	public List<Venda> listaTodos() {
		System.out.println("Vou no DAO e devolvo a Lista de Vendas ------ VendaDAO ");
		return dao.listaTodos();
	}
	
	

}
