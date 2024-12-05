package com.utad.mais.proyecto_final.abstractfactory;

public class OceanEnemyFactory implements AbstractEnemyFactory{
	
	public Warrior createWarrior() {
		return new OceanWarrior();
	}
	
	public Warlock createWarlock() {
		return new OceanWarlock();
	}
	
	public Miku createMiku() {
		return new OceanMiku();
	}

}
