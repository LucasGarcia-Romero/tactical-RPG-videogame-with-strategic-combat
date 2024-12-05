package com.utad.mais.proyecto_final.abstractfactory;

import com.utad.mais.proyecto_final.*;
import com.utad.mais.proyecto_final.decorator.*;
import com.utad.mais.proyecto_final.strategy.*;

public class DesertWarrior extends AbstractWarrior {

	//Constructor
	public DesertWarrior() {
		this("DesertWarrior");
	}
	
	public DesertWarrior(String name) {
		super();
		this.dtoCharacterProperties = new DTOCharacterProperties(name, 7, 10, 15);
		this.enemyStrategy = new DefaultStrategy(this);
		this.weapon = new EnemyActionBaseComponent(dtoCharacterProperties);
	}
}
