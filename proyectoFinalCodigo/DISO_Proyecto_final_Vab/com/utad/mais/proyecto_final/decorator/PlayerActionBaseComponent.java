package com.utad.mais.proyecto_final.decorator;

import com.utad.mais.proyecto_final.DTOCharacterProperties;

public class PlayerActionBaseComponent implements ActionBaseComponent {
	
	//Atributos
	private CharacterType characterType;
	private DTOCharacterProperties dtoCharacterProperties;
	
	public PlayerActionBaseComponent(DTOCharacterProperties dtoCharacterProperties) {
		super();
		this.characterType = CharacterType.PLAYER;
		this.dtoCharacterProperties = dtoCharacterProperties;
	}

	@Override
	public String getDescription() {
		return  "["+ this.getCharacterType() + "] " + this.dtoCharacterProperties.getName() + " attacks with: ";
	}

	@Override
	public CharacterType getCharacterType() {
		return this.characterType;
	}
	
}
