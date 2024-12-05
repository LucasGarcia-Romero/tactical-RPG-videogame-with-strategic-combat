package com.utad.mais.proyecto_final.decorator;

public class IntensityAttackComponent extends AbstractCharacterActionComponentDecorator{
	
	public IntensityAttackComponent(CharacterAction characterAction) {
		super();
		this.characterAction = characterAction;
	}

	@Override
	public String getDescription() {
		return this.getCharacterAction().getDescription() + "powerful";
	}
}
