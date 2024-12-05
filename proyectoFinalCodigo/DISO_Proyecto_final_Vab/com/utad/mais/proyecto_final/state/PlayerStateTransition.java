package com.utad.mais.proyecto_final.state;

public interface PlayerStateTransition extends PlayerState {
	
	public void actionDamagedState();
	public void actionParalizedState();
	public void actionActiveState();
	
}
