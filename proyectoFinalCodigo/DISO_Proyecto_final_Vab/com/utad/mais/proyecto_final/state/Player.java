package com.utad.mais.proyecto_final.state;

import java.util.ArrayList;
import java.util.List;

import com.utad.mais.proyecto_final.*;
import com.utad.mais.proyecto_final.Character; //hay que importarlo aparte?
import com.utad.mais.proyecto_final.decorator.*;

public class Player implements Character{
	
	//Atributos
	private DTOCharacterProperties dtoCharacterProperties;
	private List<CharacterActionComponentDecorator> inventory;
	
	private PlayerState currentState;
	private PlayerState damagedState;
	private PlayerState paralizedState;
	private PlayerState activeState;
	
	private CharacterAction characterAction;
	
	public Player(String name, Integer life, Integer strength, Integer resistence) {
		
		super();
		this.dtoCharacterProperties = new DTOCharacterProperties(name, life, strength, resistence);
		this.currentState = new ActiveState(this);
		this.damagedState = new DamagedState(this);
		this.paralizedState = new ParalizedState(this);
		this.activeState = this.currentState;
		this.characterAction = new PlayerActionBaseComponent(this.dtoCharacterProperties);
		this.inventory = this.addWeaponsInventory();
	}
	
	public List<CharacterActionComponentDecorator> addWeaponsInventory() {
		
		List<CharacterActionComponentDecorator> inv = new ArrayList<CharacterActionComponentDecorator>();
		
		inv.add(new SwordAttackComponent(this.characterAction));
		inv.add(new MagicAttackComponent(this.characterAction));
		inv.add(new LeekAttackComponent(this.characterAction));
		
		return inv;
	}
	
	//Getter y setter del estado actual
	public PlayerState getCurrentState() {
		return currentState;
	}
	public void setCurrentState(PlayerState currentState) {
		this.currentState = currentState;
	}

	//Getters de los estados
	public PlayerState getDamagedState() {
		return damagedState;
	}

	public PlayerState getParalizedState() {
		return paralizedState;
	}

	public PlayerState getActiveState() {
		return activeState;
	}
	
	public List<CharacterActionComponentDecorator> getInventory() {
		return inventory;
	}
	

	public CharacterAction getCharacterAction() {
		return characterAction;
	}
	public void setCharacterAction(CharacterAction characterAction) {
		this.characterAction = characterAction;
	}

	
	//Método específico
	public void play() {
		this.currentState.process();
	}
	
	
	//Getter y setter de DTO
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

	public DTOCharacterProperties getDtoCharacterProperties() {
		return dtoCharacterProperties;
	}
	
	
	
}
