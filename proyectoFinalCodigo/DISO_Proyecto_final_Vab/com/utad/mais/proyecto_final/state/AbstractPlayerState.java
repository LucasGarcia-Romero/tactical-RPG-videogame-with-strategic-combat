package com.utad.mais.proyecto_final.state;

public abstract class AbstractPlayerState implements PlayerStateTransition {

	//Atributos
	protected Player player;	//Context
	
	
	//Métodos específicos
	@Override
	public abstract void process();
	

	@Override
	public void actionDamagedState() {
		System.out.println("ERROR. The current state does not permit this action.");
	}

	@Override
	public void actionParalizedState() {
		System.out.println("ERROR. The current state does not permit this action.");
	}

	@Override
	public void actionActiveState() {
		System.out.println("ERROR. The current state does not permit this action.");
	}

}
