package com.utad.mais.proyecto_final.abstractfactory;

import com.utad.mais.proyecto_final.*;
import com.utad.mais.proyecto_final.decorator.*;
import com.utad.mais.proyecto_final.strategy.*;

public class OceanWarlock extends AbstractWarlock {

	//Constructores
	public OceanWarlock() {
		this("OceanWarlock");
	}
	
	public OceanWarlock(String name) {
		super();
		this.dtoCharacterProperties = new DTOCharacterProperties(name, 5, 8, 5);
		this.enemyStrategy = new DefaultStrategy(this);
		this.magicPower = new EnemyActionBaseComponent(dtoCharacterProperties);
	}

}
