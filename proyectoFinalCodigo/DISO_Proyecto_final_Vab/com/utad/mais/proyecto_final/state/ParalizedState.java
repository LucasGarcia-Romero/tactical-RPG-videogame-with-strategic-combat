package com.utad.mais.proyecto_final.state;

public class ParalizedState extends AbstractPlayerState {
	//añadimos un bool de control para evitar que sea inmortal
	private Boolean curado=false;
	
	//Constructor
	public ParalizedState(Player player) {
		super();
		this.player = player;
	}

	//metodo especifico
	@Override
	public void process() {
		this.actionParalizedState();	
	}
	
	public void actionParalizedState() {
		if(!curado) {
		
			player.setLife(player.getLife()+3);
			System.out.println("The hp is low, the player " + player.getName() + "is now entering in healing state, actual life increased to " + player.getLife());
			//actualizo el booleano
			curado=true;
		}
		//en caso de haberse curado
		else {
			player.setCurrentState(player.getActiveState());
			//en caso de no poder curar skipeamos el estado paralizado
			player.getCurrentState().process();
		}
	}

}
