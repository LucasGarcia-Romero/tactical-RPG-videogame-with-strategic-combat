package com.utad.mais.proyecto_final.decorator;

public class SwordAttackComponent extends AbstractCharacterActionComponentDecorator {

	public SwordAttackComponent(CharacterAction characterAction) {
		super();
		this.characterAction = characterAction;
	}
	
	@Override
	public String getDescription() {
		return this.getCharacterAction().getDescription() + " sword";
	}

}
