package com.utad.mais.proyecto_final.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.utad.mais.proyecto_final.Character;
import com.utad.mais.proyecto_final.abstractfactory.*;
import com.utad.mais.proyecto_final.decorator.*;
import com.utad.mais.proyecto_final.state.*;

public class GameController {
	
	//Atributos
	private static GameController gameController;				//Singleton
	private Calculator calculator;
	private Boolean seDefiende;
	private Manager manager;
	
	//Contadores
	private Integer roundCounter;
	private Integer turnCounter;

	private Integer currentWeapon;
	
	private Integer startTurn;

	//Personajes de la partida
	private Player player;										//State
	private EnemyTransition enemy;
	
	
	//Constructores
	private GameController() {
		super();
		this.player = new Player("Tod", 20, 20, 0);
		this.calculator = Calculator.getInstance();
		this.manager = Manager.getInstance();
		this.seDefiende = false;
		
		this.currentWeapon = 0;
		
		this.turnCounter = 1;
		this.roundCounter = 1;
	}	
	
	
	//Métodos
	public static synchronized GameController getInstance() {
		if(gameController == null) gameController = new GameController();
		return gameController;
	}
	
	public void game() {
		
		if(startGame()) 
			System.out.println("YAY! YOU WON :D");
		else
			System.out.println("GAME OVER :|");
		
	}
	
	public boolean startGame() {
		
		this.startTurn = (int) (Math.random()*2);
		
		this.changeWorld(new ForestEnemyFactory());
		
		//Si el jugador está vivo, pasamos al siguiente mundo
		if(!this.isAlive((Character)this.player)) return false;
		
		System.out.println("\nNEXT WORLD: OCEAN WORLD");
		this.changeWorld(new OceanEnemyFactory());
		
		//Si el jugador está vivo, pasamos al siguiente mundo
		if(!this.isAlive((Character)this.player)) return false;
		
		System.out.println("\nNEXT WORLD: DESERT WORLD");
		this.changeWorld(new DesertEnemyFactory());
		
		//Si el jugador está vivo, pasamos al siguiente mundo
		if(!this.isAlive((Character)this.player)) return false;
		
		return true;		
	}
	
	public Integer playersTurn() {
		
		System.out.println("\nTURN: " + this.turnCounter);
		this.turnCounter++;
		
		Scanner scan = new Scanner(System.in);
		int option = 0;
		
		//Le resta 1 de armadura ya que al defenderse suma - 1 en armadura por un solo turno
		if(this.seDefiende) {
			this.player.setResistence(this.player.getResistence() - 1);
		}
		
    	this.seDefiende = false;
    	
		do {
			System.out.println("Choose what to do in this turn:");
			System.out.println("1 - Attack");
			System.out.println("2 - Defend");
	
		    option = scan.nextInt();
		    
		    if(option == 1) {			//Ha decidido atacar
		    	do {
		    		System.out.println("Choose a weapon: ");
		            System.out.println("1. Sword");
		            System.out.println("2. Magic Wand");
		            System.out.println("3. Leek");
		            
		            this.currentWeapon = scan.nextInt();
				    
		    	}while(this.currentWeapon < 1 || this.currentWeapon > 3);
		    	
		    	this.currentWeapon -= 1;		//El arma seleccionada por el jugador
		    }
		    else if (option == 2) {				//Ha decidido defender
		    	this.seDefiende = true;
		    	this.player.setResistence(this.player.getResistence() + 1);			//Añade 1 de defensa hasta final de turno
		    }
		    else {
			    System.out.println("ERROR. Choose a valid option.");
		    }

		}while(option != 1 && option != 2);
		
		
		//Cambio de arma
			
		//Creamos nuevo componente base
		CharacterAction newBaseCharacterAction = new PlayerActionBaseComponent(this.player.getDtoCharacterProperties());
		
		//Actualizar intensificadores
		if(this.player.getStrength() > 6) 
			newBaseCharacterAction = new IntensityAttackComponent(newBaseCharacterAction);
		else if(this.player.getStrength() < 2) 
			newBaseCharacterAction = new PochoAttackComponent(newBaseCharacterAction);
		
		this.player.getInventory().get(this.currentWeapon).setCharacterAction(newBaseCharacterAction);
		//Guardar nueva arma
		newBaseCharacterAction = this.player.getInventory().get(this.currentWeapon);
		
		//Pasarle nuevo Decorator
		this.player.setCharacterAction(newBaseCharacterAction);
		
		
		return option;
	}
	
	
	public void changeWorld(AbstractEnemyFactory abstractEnemyFactory) {
		
		//Cambiamos de fábrica
		this.manager.setAbstractEnemyFactory(abstractEnemyFactory);
		
		//Cambiamos el enemigo
		this.enemy = randomEnemy();
		
		//Inicio de la partida
		this.play();
	}
	
	public EnemyTransition randomEnemy() {
		
		Integer indexEnemy = (int) (Math.random()*3);
		
		List<EnemyTransition> possibleEnemies = new ArrayList<EnemyTransition>();
		possibleEnemies.add(this.manager.getAbstractEnemyFactory().createWarrior());
		possibleEnemies.add(this.manager.getAbstractEnemyFactory().createWarlock());
		possibleEnemies.add(this.manager.getAbstractEnemyFactory().createMiku());
		
		return possibleEnemies.get(indexEnemy);
	}
	
	
	public void play() {
		
		System.out.println("ROUND: " + this.roundCounter);
		this.turnCounter = 1;
		
		Integer option = 0;
		
		while(this.isAlive((Character)this.player) && this.isAlive((Character)this.enemy)) {
			
			if(this.startTurn == 0) {
				option = this.playersTurn();
				this.player.play();
				this.calculator.applyDamageToEnemy(this.roundCounter, this.player, this.enemy, this.currentWeapon, option, seDefiende);
				this.enemy.play();
				this.calculator.applyDamageToPlayer(this.roundCounter, this.enemy, this.player);
				this.enemy.getEnemyStrategy().applyStrategy();
			}
			else {
				this.enemy.play();
				this.calculator.applyDamageToPlayer(this.roundCounter, this.enemy, this.player);
				option = this.playersTurn();
				this.player.play();
				this.calculator.applyDamageToEnemy(this.roundCounter, this.player, this.enemy, this.currentWeapon, option, seDefiende);
				this.enemy.getEnemyStrategy().applyStrategy();
			}
		}
		
		
		this.roundCounter++;
	}
	
	public Boolean isAlive(Character character) {
		return (character.getLife() > 0);
	}
	
}
