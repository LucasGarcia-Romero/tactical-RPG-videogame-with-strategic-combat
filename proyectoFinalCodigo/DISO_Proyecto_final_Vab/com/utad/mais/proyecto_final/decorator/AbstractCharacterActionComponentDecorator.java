package com.utad.mais.proyecto_final.decorator;

public abstract class AbstractCharacterActionComponentDecorator implements CharacterActionComponentDecorator{
	
	//Atributos
	protected CharacterAction characterAction;

	public CharacterAction getCharacterAction() {
		return characterAction;
	}

	public void setCharacterAction(CharacterAction characterAction) {
		this.characterAction = characterAction;
	}
	
}
