package com.utad.mais.proyecto_final.abstractfactory;


public class Manager {
	
	//Atributos
	private static Manager manager;				//Singleton
	private AbstractEnemyFactory abstractEnemyFactory;			//Factory
	
	
	//Constructores
	private Manager() {
		super();
	}	
	
	
	//getters & setters
	public AbstractEnemyFactory getAbstractEnemyFactory() {
		return abstractEnemyFactory;
	}
	public void setAbstractEnemyFactory(AbstractEnemyFactory abstractEnemyFactory) {
		this.abstractEnemyFactory = abstractEnemyFactory;
	}
	
	
	//Métodos
	public static synchronized Manager getInstance() {
		if(manager == null) manager = new Manager();
		return manager;
	}
	
	public Warrior createWarrior() {
		return this.abstractEnemyFactory.createWarrior();
	}
	public Warlock createWarlock() {
		return this.abstractEnemyFactory.createWarlock();
	}
	public Miku createMiku() {
		return this.abstractEnemyFactory.createMiku();
	}
}