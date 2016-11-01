package br.com.caelum.livraria.tx;

import java.io.Serializable;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;

@Transacional
@Interceptor
public class GerenciadorTransacao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	EntityManager manager;

	@AroundInvoke
	public Object transacaoTX(InvocationContext contexto)throws Exception {
		
		// abre transacao
		manager.getTransaction().begin();
		System.out.println("Begin Transação");
		
		//Metodo que processo o centro da Transação.
		Object resultado = contexto.proceed();
		
		// commita a transacao
		manager.getTransaction().commit();
		System.out.println("Commit Transação");
		
		return resultado;
	}
	
}
