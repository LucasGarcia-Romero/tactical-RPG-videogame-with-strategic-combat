package com.utad.mais.proyecto_final.abstractfactory;

import com.utad.mais.proyecto_final.*;
import com.utad.mais.proyecto_final.decorator.*;
import com.utad.mais.proyecto_final.strategy.*;

public abstract class AbstractMiku implements Miku {
	
	//Atributos
	protected DTOCharacterProperties dtoCharacterProperties;
	protected EnemyStrategy enemyStrategy;
	protected CharacterAction leek;
	protected Boolean shiny;
	
	
	//Getter y setters
	
	public EnemyStrategy getEnemyStrategy() {
		return enemyStrategy;
	}
	public void setEnemyStrategy(EnemyStrategy enemyStrategy) {
		this.enemyStrategy = enemyStrategy;
	}

	public CharacterAction getLeek() {
		return this.leek;
	}
	
	public Boolean getShiny() {
		return this.shiny;
	}
	
	//Getters y setter de DTO
	public String getName() {
		return dtoCharacterProperties.getName();
	}
	
	public Integer getLife() {
		return dtoCharacterProperties.getLife();
	}
	public void setLife(Integer life) {
		dtoCharacterProperties.setLife(life);
	}
	
	public Integer getStrength() {
		return dtoCharacterProperties.getStrength();
	}
	public void setStrength(Integer strength) {
		this.dtoCharacterProperties.setStrength(strength);
	}

	public Integer getResistence() {
		return this.dtoCharacterProperties.getResistence();
	}
	public void setResistence(Integer resistence) {
		this.dtoCharacterProperties.setResistence(resistence);
	}
	
	
	//Método de juego
	public Boolean isShiny() {
		if(Math.random() * 3 == 1) return true;
		else return false; 
	}
	
	public void play() {
		
		this.leek = new EnemyActionBaseComponent(dtoCharacterProperties);
		
		//Determinar la intensidad de ataque
		if(this.getStrength() > 8) 
			this.leek = new IntensityAttackComponent(this.leek);
		else if(this.getStrength() < 2) 
			this.leek = new PochoAttackComponent(this.leek);
	
		this.leek = new LeekAttackComponent(this.leek);
		
		//Imprimir mensaje
		System.out.println(this.leek.getDescription());
	}
	
		
}
