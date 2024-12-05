package com.utad.mais.proyecto_final.decorator;

public class PochoAttackComponent extends AbstractCharacterActionComponentDecorator{
	
	public PochoAttackComponent(CharacterAction characterAction) {
		super();
		this.characterAction = characterAction;
	}

	@Override
	public String getDescription() {
		return this.getCharacterAction().getDescription() + "pocho";
	}
}