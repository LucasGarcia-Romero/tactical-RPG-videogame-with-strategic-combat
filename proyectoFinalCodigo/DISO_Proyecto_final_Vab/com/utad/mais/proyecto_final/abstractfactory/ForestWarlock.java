package com.utad.mais.proyecto_final.abstractfactory;

import com.utad.mais.proyecto_final.*;
import com.utad.mais.proyecto_final.decorator.*;
import com.utad.mais.proyecto_final.strategy.*;

public class ForestWarlock extends AbstractWarlock {
	
	//Constructores
	public ForestWarlock() {
		this("ForestWarlock");
	}
	
	public ForestWarlock(String name) {
		super();
		this.dtoCharacterProperties = new DTOCharacterProperties(name, 3, 5, 3);
		this.enemyStrategy = new DefaultStrategy(this);
		this.magicPower = new EnemyActionBaseComponent(dtoCharacterProperties);
	}
}