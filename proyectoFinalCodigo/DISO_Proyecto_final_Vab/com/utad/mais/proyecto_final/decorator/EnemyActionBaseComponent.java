package com.utad.mais.proyecto_final.decorator;

import com.utad.mais.proyecto_final.DTOCharacterProperties;

public class EnemyActionBaseComponent  implements ActionBaseComponent {

	//Atributos
	private CharacterType characterType;
	private DTOCharacterProperties dtoCharacterProperties;
	
	public EnemyActionBaseComponent(DTOCharacterProperties dtoCharacterProperties) {
		this.characterType = CharacterType.ENEMY;
		this.dtoCharacterProperties = dtoCharacterProperties;
	}

	@Override
	public String getDescription() {
		return "["+ this.getCharacterType() + "] " + this.dtoCharacterProperties.getName() + " attacks with: ";
	}

	@Override
	public CharacterType getCharacterType() {
		return this.characterType;
	}

	@Override	//inutil pero en las pizzas lo hicimos
	public String toString() {
		return this.getDescription();
	}
	
}
