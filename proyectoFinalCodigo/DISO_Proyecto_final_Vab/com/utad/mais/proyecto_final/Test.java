package com.utad.mais.proyecto_final;

import com.utad.mais.proyecto_final.facade.GameController;

public class Test {

	public static void main(String[] args) {
		GameController gameController = GameController.getInstance();
		gameController.game();
	}

}
