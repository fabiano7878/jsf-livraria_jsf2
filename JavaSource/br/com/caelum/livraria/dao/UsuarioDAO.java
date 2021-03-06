package br.com.caelum.livraria.dao;

import java.io.Serializable;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import br.com.caelum.livraria.interceptors.Log;
import br.com.caelum.livraria.modelo.Usuario;

@Named
public class UsuarioDAO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	@Log
	public boolean validaUsuario(Usuario user){
		
//		EntityManager em = new JPAUtil().getEntityManager();
		TypedQuery<Usuario> query = manager.createQuery("select u from Usuario u where u.email = :pEmail and u.senha = :pSenha",Usuario.class);
		
		query.setParameter("pEmail", user.getEmail());
		query.setParameter("pSenha", user.getSenha());

		try{
			Usuario resultado = query.getSingleResult();			
		}catch(NoResultException ex){
			return false;
		}
		
//		em.close();
		
		return true;
	}
	
}
