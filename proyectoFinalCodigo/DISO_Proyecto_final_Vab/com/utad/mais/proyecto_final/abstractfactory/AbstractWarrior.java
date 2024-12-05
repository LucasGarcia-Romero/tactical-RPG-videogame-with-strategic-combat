package com.utad.mais.proyecto_final.abstractfactory;

import com.utad.mais.proyecto_final.DTOCharacterProperties;
import com.utad.mais.proyecto_final.decorator.*;
import com.utad.mais.proyecto_final.strategy.*;

public abstract class AbstractWarrior implements Warrior {

	//Atributos
	protected DTOCharacterProperties dtoCharacterProperties;
	protected EnemyStrategy enemyStrategy;
	protected CharacterAction weapon;
	
	
	//Getter y setters
	public EnemyStrategy getEnemyStrategy() {
		return enemyStrategy;
	}
	public void setEnemyStrategy(EnemyStrategy enemyStrategy) {
		this.enemyStrategy = enemyStrategy;
	}
	
	public CharacterAction getWeapon() {
		return this.weapon;
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
		
		this.weapon = new EnemyActionBaseComponent(dtoCharacterProperties);
		
		//Determinar la intensidad de ataque
		if(this.getStrength() > 8) 
			this.weapon = new IntensityAttackComponent(this.weapon);
		else if(this.getStrength() < 2) 
			this.weapon = new PochoAttackComponent(this.weapon);
	
		this.weapon = new SwordAttackComponent(this.weapon);
		
		//Imprimir mensaje
		System.out.println(this.weapon.getDescription());
	}
}
