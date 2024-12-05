package com.utad.mais.proyecto_final.abstractfactory;

import com.utad.mais.proyecto_final.*;
import com.utad.mais.proyecto_final.decorator.*;
import com.utad.mais.proyecto_final.strategy.*;

public class DesertWarlock extends AbstractWarlock {
	
	//Constructores
	public DesertWarlock() {
		this("DesertWarlock");
	}
	
	public DesertWarlock(String name) {
		super();
		this.dtoCharacterProperties = new DTOCharacterProperties(name, 8, 20, 8);
		this.enemyStrategy = new DefaultStrategy(this);
		this.magicPower = new EnemyActionBaseComponent(dtoCharacterProperties);
	}
}
