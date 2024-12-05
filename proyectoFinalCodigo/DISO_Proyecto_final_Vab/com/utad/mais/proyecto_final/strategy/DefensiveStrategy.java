package com.utad.mais.proyecto_final.strategy;

import com.utad.mais.proyecto_final.abstractfactory.EnemyTransition;

// ESTRATEGIA CONCRETA: ESTRATEGIA DE DEFENSA
public class DefensiveStrategy extends AbstractEnemyStrategy {
	
	public DefensiveStrategy(EnemyTransition enemy) {
		super();
		this.enemy = enemy;
	}
	
	//Métodos
	@Override
	public void applyDefense() {
		System.out.println(this.enemy.getName() + " is defending themself");
	}

}
