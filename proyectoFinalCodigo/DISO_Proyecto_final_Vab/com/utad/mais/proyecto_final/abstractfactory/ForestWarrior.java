package com.utad.mais.proyecto_final.abstractfactory;

import com.utad.mais.proyecto_final.*;
import com.utad.mais.proyecto_final.decorator.*;
import com.utad.mais.proyecto_final.strategy.*;

public class ForestWarrior extends AbstractWarrior {

	//Constructores
	public ForestWarrior() {
		this("ForestWarrior");
	}
	
	public ForestWarrior(String name) {
		super();
		this.dtoCharacterProperties = new DTOCharacterProperties(name, 2, 2, 5);
		this.enemyStrategy = new DefaultStrategy(this);
		this.weapon = new EnemyActionBaseComponent(dtoCharacterProperties);
	}

}
