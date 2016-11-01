package br.com.caelum.livraria.util;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class LogPharseListener implements PhaseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void afterPhase(PhaseEvent fEvent) {
		// TODO Auto-generated method stub
	}

	@Override
	public void beforePhase(PhaseEvent fEvent) {
		// TODO Auto-generated method stub
		System.out.println("Fase: " + fEvent.getPhaseId());
	}

	@Override
	public PhaseId getPhaseId() {
		// TODO Auto-generated method stub
		return PhaseId.ANY_PHASE;
	}
	
	

}
