package com.utad.mais.proyecto_final.strategy;

import com.utad.mais.proyecto_final.abstractfactory.*;

// CLASE ABSTRACTA QUE DEFINE EL ORDEN DE LA EJECUCION
public abstract class AbstractEnemyStrategy implements EnemyStrategy {
	// Atributo
	protected EnemyTransition enemy;
	
	// Metodos abstractos: son los que se van a definir en las estrategias concretas
	public void damagePlayer() {}
	public void applyDefense() {}
	public void enemyHasDied() {}

	public void applyStrategy() {
		this.applyDefense();
		this.damagePlayer();	
		this.enemyHasDied();
	}
}
