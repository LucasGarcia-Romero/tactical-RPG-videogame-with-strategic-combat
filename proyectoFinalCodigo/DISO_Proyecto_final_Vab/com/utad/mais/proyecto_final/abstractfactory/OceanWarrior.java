package com.utad.mais.proyecto_final.abstractfactory;

import com.utad.mais.proyecto_final.*;
import com.utad.mais.proyecto_final.decorator.*;
import com.utad.mais.proyecto_final.strategy.*;

public class OceanWarrior extends AbstractWarrior {

	//Constructor
	public OceanWarrior() {
		this("OceanWarrior");
	}
	
	public OceanWarrior(String name) {
		super();
		this.dtoCharacterProperties = new DTOCharacterProperties(name, 4, 8, 10);
		this.enemyStrategy = new DefaultStrategy(this);
		this.weapon = new EnemyActionBaseComponent(dtoCharacterProperties);
	}
}