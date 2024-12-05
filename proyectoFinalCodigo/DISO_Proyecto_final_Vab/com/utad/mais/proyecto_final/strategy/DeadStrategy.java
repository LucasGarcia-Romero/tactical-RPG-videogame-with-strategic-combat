package com.utad.mais.proyecto_final.strategy;

import com.utad.mais.proyecto_final.abstractfactory.EnemyTransition;

public class DeadStrategy  extends AbstractEnemyStrategy {
	
	public DeadStrategy(EnemyTransition enemy) {
		super();
		this.enemy = enemy;
	}
	
	//Métodos
	@Override
	public void enemyHasDied() {
		System.out.println(this.enemy.getName() + " has died");
	}
}