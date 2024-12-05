package com.utad.mais.proyecto_final.strategy;

import com.utad.mais.proyecto_final.abstractfactory.EnemyTransition;

// ESTRATEGIA CONCRETA: ESTRATEGIA POR DEFECTO
public class DefaultStrategy extends AbstractEnemyStrategy {
	
	public DefaultStrategy(EnemyTransition enemy) {
		super();
		this.enemy = enemy;
	}

	//Métodos
	@Override
	public void damagePlayer() {
		System.out.println(this.enemy.getName() + " is in their default strategy");
	}

	@Override
	public void applyDefense() {
	}

}
