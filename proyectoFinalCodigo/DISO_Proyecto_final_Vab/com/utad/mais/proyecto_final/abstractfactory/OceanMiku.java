package com.utad.mais.proyecto_final.abstractfactory;

import com.utad.mais.proyecto_final.*;
import com.utad.mais.proyecto_final.decorator.*;
import com.utad.mais.proyecto_final.strategy.*;

public class OceanMiku extends AbstractMiku {
	
	//Constructores
	public OceanMiku() {
		this("OceanMiku");
	}
	
	public OceanMiku(String name) {
		super();
		this.dtoCharacterProperties = new DTOCharacterProperties(name, 8, 10, 10);
		this.enemyStrategy = new DefaultStrategy(this);
		this.leek = new EnemyActionBaseComponent(dtoCharacterProperties);
		this.shiny = this.isShiny();
	}

}
