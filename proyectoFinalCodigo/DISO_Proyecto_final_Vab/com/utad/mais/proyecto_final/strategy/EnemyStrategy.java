package com.utad.mais.proyecto_final.strategy;

// INTERFAZ QUE DEFINE EL PATRON DE SERVICIO
public interface EnemyStrategy extends ServiceStrategy {
	
	public void damagePlayer();
	public void applyDefense();
	public void enemyHasDied();
	
}
