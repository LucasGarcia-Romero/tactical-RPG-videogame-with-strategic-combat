package com.utad.mais.proyecto_final.decorator;

public class MagicAttackComponent extends AbstractCharacterActionComponentDecorator {

	public MagicAttackComponent(CharacterAction characterAction) {
		super();
		this.characterAction = characterAction;
	}
	
	public String getDescription() {
		return this.getCharacterAction().getDescription() + " magic wand";
	}

}
