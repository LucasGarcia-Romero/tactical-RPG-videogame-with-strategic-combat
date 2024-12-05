package com.utad.mais.proyecto_final.strategy;

import com.utad.mais.proyecto_final.abstractfactory.EnemyTransition;

// ESTRATEGIA CONCRETA: ESTRATEGIA AGRESIVA
public class OffensiveStrategy extends AbstractEnemyStrategy {

	public OffensiveStrategy(EnemyTransition enemy) {
		super();
		this.enemy = enemy;
	}
	
	//Métodos
	@Override
	public void damagePlayer() {
		System.out.println(this.enemy.getName() + " is attacking");
	}

}
