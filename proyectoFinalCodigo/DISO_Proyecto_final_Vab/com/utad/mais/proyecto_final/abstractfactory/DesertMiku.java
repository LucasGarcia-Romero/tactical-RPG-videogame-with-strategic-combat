package com.utad.mais.proyecto_final.abstractfactory;

import com.utad.mais.proyecto_final.*;
import com.utad.mais.proyecto_final.decorator.*;
import com.utad.mais.proyecto_final.strategy.*;

public class DesertMiku extends AbstractMiku {
	
	//Constructores
	public DesertMiku() {
		this("DesertMiku");
	}
	
	public DesertMiku(String name) {
		super();
		this.dtoCharacterProperties = new DTOCharacterProperties(name, 10, 20, 20);
		this.enemyStrategy = new DefaultStrategy(this);
		this.leek = new EnemyActionBaseComponent(dtoCharacterProperties);
		this.shiny = this.isShiny();
	}

}
