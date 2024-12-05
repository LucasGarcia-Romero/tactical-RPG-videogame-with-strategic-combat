package com.utad.mais.proyecto_final.abstractfactory;

import com.utad.mais.proyecto_final.decorator.*;

public interface Warrior extends EnemyTransition{
	
	public CharacterAction getWeapon(); 
	
}
