package com.utad.mais.proyecto_final.abstractfactory;

import com.utad.mais.proyecto_final.*;
import com.utad.mais.proyecto_final.decorator.*;
import com.utad.mais.proyecto_final.strategy.*;

public class ForestMiku extends AbstractMiku {
	
	//Constructores
	public ForestMiku() {
		this("ForestMiku");
	}
	
	public ForestMiku(String name) {
		super();
		this.dtoCharacterProperties = new DTOCharacterProperties(name, 5, 5, 5);
		this.enemyStrategy = new DefaultStrategy(this);
		this.leek = new EnemyActionBaseComponent(dtoCharacterProperties);
		this.shiny = this.isShiny();
	}

}
