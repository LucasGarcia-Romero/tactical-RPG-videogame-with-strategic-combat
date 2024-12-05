package com.utad.mais.proyecto_final.facade;

import com.utad.mais.proyecto_final.abstractfactory.*;
import com.utad.mais.proyecto_final.decorator.*;
import com.utad.mais.proyecto_final.state.*;
import com.utad.mais.proyecto_final.strategy.*;

public class Calculator {

	//Atributos
	private static Calculator calculator;
	
	//Constructor
	private Calculator() {
		super();
	}	
	//implementando la tecnica de refactorización extract method he sacado el calculo 
	//del daño de las distintas partes de applyDamageToPlayer donde se repetia multiples veces
	private int calculateDamage(Player victim, int intensity) {
		int damage=victim.getLife()-intensity+victim.getResistence();
		if(damage<0) {
			return 0;
		}
		return damage;
	}
	
	//Métodos
	public static synchronized Calculator getInstance() {
		if(calculator == null) calculator = new Calculator();
		return calculator;
	}
	
	public void applyDamageToPlayer(Integer round, EnemyTransition attacker, Player victim) {
		//Cambio de estrategia del atacante
		attacker.setEnemyStrategy(new OffensiveStrategy(attacker));
		
		//Comprobamos que el enemigo es un guerrero
		if(attacker instanceof Warrior) {
			
			if(hasDecoratorOf(((Warrior) attacker).getWeapon(), new IntensityAttackComponent(((Warrior) attacker).getWeapon())) instanceof IntensityAttackComponent) {
				//tiene una intensidad quita 3
				
				//baja la vida
				victim.setLife(calculateDamage(victim, 3));
				//llamamos a dañar player
				victim.setCurrentState(victim.getDamagedState());
				
			}
			else if(hasDecoratorOf(((Warrior) attacker).getWeapon(), new PochoAttackComponent(((Warrior) attacker).getWeapon())) instanceof PochoAttackComponent){
				//la intensidad es pocha, quita 1
				//baja la vida
				victim.setLife(calculateDamage(victim, 1));
				//llamamos a dañar player
				victim.setCurrentState(victim.getDamagedState());
				
				
			}
			else {
				//la intensidad es normal, quita 2
				//baja la vida
				victim.setLife(calculateDamage(victim, 2));
				//llamamos a dañar player
				victim.setCurrentState(victim.getDamagedState());			
			}
		}
		
		
		//Comprobamos que el enemigo es un mago
		else if(attacker instanceof Warlock) {
			if(hasDecoratorOf(((Warlock) attacker).getMagicPower(), new IntensityAttackComponent(((Warlock) attacker).getMagicPower())) instanceof IntensityAttackComponent) {
				//tiene una intensidad quita 3
				
				//baja la vida
				victim.setLife(calculateDamage(victim, 3));
				//llamamos a dañar player
				victim.setCurrentState(victim.getDamagedState());
				
			}
			else if(hasDecoratorOf(((Warlock) attacker).getMagicPower(), new PochoAttackComponent(((Warlock) attacker).getMagicPower())) instanceof PochoAttackComponent){
				//la intensidad es pocha, quita 1
				//baja la vida
				victim.setLife(calculateDamage(victim, 1));
				//llamamos a dañar player
				victim.setCurrentState(victim.getDamagedState());
				
				
			}
			else {
				//la intensidad es normal, quita 2
				//baja la vida
				victim.setLife(calculateDamage(victim, 2));
				//llamamos a dañar player
				victim.setCurrentState(victim.getDamagedState());			
			}
		}
		
		//Comprobamos que el enemigo es un mago
		else if(attacker instanceof Miku) {
			if(hasDecoratorOf(((Miku) attacker).getLeek(), new IntensityAttackComponent(((Miku) attacker).getLeek())) instanceof IntensityAttackComponent) {
				//tiene una intensidad quita 3
				
				//baja la vida
				victim.setLife(calculateDamage(victim, 3));
				//llamamos a dañar player
				victim.setCurrentState(victim.getDamagedState());
				
			}
			else if(hasDecoratorOf(((Miku) attacker).getLeek(), new PochoAttackComponent(((Miku) attacker).getLeek())) instanceof PochoAttackComponent){
				//la intensidad es pocha, quita 1
				//baja la vida
				victim.setLife(calculateDamage(victim, 1));
				//llamamos a dañar player
				victim.setCurrentState(victim.getDamagedState());
				
				
			}
			else {
				//la intensidad es normal, quita 2
				//baja la vida
				victim.setLife(calculateDamage(victim, 2));
				//llamamos a dañar player
				victim.setCurrentState(victim.getDamagedState());			
			}
		}
	}
	
	public void applyDamageToEnemy(Integer round, Player attacker, EnemyTransition victim, Integer currentWeapon, Integer optionDefense, Boolean defend) {
		
		if(attacker.getCurrentState() instanceof ActiveState) {
			
			//Cambio de estrategia del enemigo
			victim.setEnemyStrategy(new DefensiveStrategy(victim));
			
			//Mensaje de ataque de Tod
			if(optionDefense == 1) System.out.println(attacker.getCharacterAction().getDescription());
			else System.out.println(attacker.getName() + " is defending themself");
			
			//puede atacar
			if(!defend) {
				if(hasDecoratorOf(((Player) attacker).getInventory().get(currentWeapon), new IntensityAttackComponent(((Player) attacker).getInventory().get(currentWeapon))) instanceof IntensityAttackComponent) {
					//tiene una intensidad quita 3
					
					//baja la vida
					victim.setLife(victim.getLife()-3);
					
				}
				else if(hasDecoratorOf(((Player) attacker).getInventory().get(currentWeapon), new PochoAttackComponent(((Player) attacker).getInventory().get(currentWeapon))) instanceof PochoAttackComponent){
					//la intensidad es pocha, quita 1
					//baja la vida
					victim.setLife(victim.getLife()-1);		
				}
				else {
					//la intensidad es normal, quita 2
					//baja la vida
					victim.setLife(victim.getLife()-2);			
				}
				
				if(victim.getLife() <= 0) {
					victim.setLife(0);
					victim.setEnemyStrategy(new DeadStrategy(victim));						//Cambio de estrategia
				}
			System.out.println("Enemy has " + victim.getLife() + " life points");		//Muestra de la vida del enemigo
			}
		}
		else {
			
			//Cambio de estrategia del enemigo
			victim.setEnemyStrategy(new DefaultStrategy(victim));
			
			System.out.println("Player can´t attack this turn");
		}
		
	}
	
	
	public static CharacterAction hasDecoratorOf(CharacterAction characterAction, CharacterActionComponentDecorator characterActionComponentDecorator) {
		
		if ( (!(characterAction instanceof CharacterActionComponentDecorator)) ||
				((CharacterActionComponentDecorator) characterAction).getCharacterAction().getClass().equals(characterActionComponentDecorator.getClass())){
			return characterAction;
		} else {
			return hasDecoratorOf (((CharacterActionComponentDecorator) characterAction).getCharacterAction(), characterActionComponentDecorator);
		}
	}
	
	public static CharacterActionComponentDecorator instanceHasComponentDecorator(CharacterAction characterAction,CharacterActionComponentDecorator characterActionComponentDecorator) {
		CharacterAction componentSearched =	hasDecoratorOf(characterAction, characterActionComponentDecorator);
		if ((componentSearched	instanceof CharacterActionComponentDecorator) && ((CharacterActionComponentDecorator) componentSearched).getCharacterAction().getClass().equals(characterActionComponentDecorator.getClass())){
			return (CharacterActionComponentDecorator) componentSearched;
		} 
		else {
			return null;
		}
	}
	

}
