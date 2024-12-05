package com.utad.mais.proyecto_final.decorator;

public class LeekAttackComponent extends AbstractCharacterActionComponentDecorator {
	
	public LeekAttackComponent(CharacterAction characterAction) {
		super();
		this.characterAction = characterAction;
	}

	@Override
	public String getDescription() {
		return this.getCharacterAction().getDescription() + " leek";
	}

}
