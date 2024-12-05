package com.utad.mais.proyecto_final.state;

public class DamagedState extends AbstractPlayerState {

	
	//Constructor
	public DamagedState(Player player) {
		super();
		this.player = player;
	}

	//Método específico
	@Override
	public void process() {
		this.actionDamagedState();
	}
	
	@Override
	public void actionDamagedState() {
		//cuando recibe daño
		System.out.println("The player " + player.getName() + " has been damaged, actual life has been lowered down to " + player.getLife());
		
		//si está vivo y tiene una vida menor que 3 corazones
		if(player.getLife() > 0 && player.getLife() <= 3) {
			player.setCurrentState(player.getParalizedState());
		}
		else {
			player.setCurrentState(player.getActiveState());
		}
	}	
}
