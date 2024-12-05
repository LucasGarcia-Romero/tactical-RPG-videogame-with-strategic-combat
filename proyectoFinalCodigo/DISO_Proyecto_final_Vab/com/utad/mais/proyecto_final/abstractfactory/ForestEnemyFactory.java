package com.utad.mais.proyecto_final.abstractfactory;

public class ForestEnemyFactory implements AbstractEnemyFactory{
	
	public Warrior createWarrior() {
		return new ForestWarrior();
	}
	
	public Warlock createWarlock() {
		return new ForestWarlock();
	}
	
	public Miku createMiku() {
		return new ForestMiku();
	}

}
