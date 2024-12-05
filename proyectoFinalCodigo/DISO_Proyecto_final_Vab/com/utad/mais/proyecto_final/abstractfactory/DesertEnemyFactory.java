package com.utad.mais.proyecto_final.abstractfactory;

public class DesertEnemyFactory implements AbstractEnemyFactory {
	
	public Warrior createWarrior() {
		return new DesertWarrior();
	}
	
	public Warlock createWarlock() {
		return new DesertWarlock();
	}
	
	public Miku createMiku() {
		return new DesertMiku();
	}
}
