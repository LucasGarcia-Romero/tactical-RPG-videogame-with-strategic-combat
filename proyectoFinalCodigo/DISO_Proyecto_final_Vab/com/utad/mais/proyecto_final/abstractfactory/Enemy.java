package com.utad.mais.proyecto_final.abstractfactory;
import com.utad.mais.proyecto_final.Character;
import com.utad.mais.proyecto_final.strategy.EnemyStrategy;

public interface Enemy extends Character{
	public EnemyStrategy getEnemyStrategy();
}
