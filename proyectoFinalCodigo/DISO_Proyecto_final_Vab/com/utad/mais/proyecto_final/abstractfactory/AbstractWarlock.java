package com.utad.mais.proyecto_final.abstractfactory;

import com.utad.mais.proyecto_final.*;
import com.utad.mais.proyecto_final.decorator.*;
import com.utad.mais.proyecto_final.strategy.*;

public abstract class AbstractWarlock implements Warlock {

	//Atributos
	protected DTOCharacterProperties dtoCharacterProperties;
	protected EnemyStrategy enemyStrategy;
	protected CharacterAction magicPower;
	
	
	//Getter y setters
	public EnemyStrategy getEnemyStrategy() {
		return enemyStrategy;
	}
	public void setEnemyStrategy(EnemyStrategy enemyStrategy) {
		this.enemyStrategy = enemyStrategy;
	}
	
	public CharacterAction getMagicPower() {
		return this.magicPower;
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
	public void play() {
		
		this.magicPower = new EnemyActionBaseComponent(dtoCharacterProperties);
		
		//Determinar la intensidad de ataque
		if(this.getStrength() > 8) 
			this.magicPower = new IntensityAttackComponent(this.magicPower);
		else if(this.getStrength() < 2) 
			this.magicPower = new PochoAttackComponent(this.magicPower);
	
		this.magicPower = new MagicAttackComponent(this.magicPower);
		
		//Imprimir mensaje
		System.out.println(this.magicPower.getDescription());
	}

}
