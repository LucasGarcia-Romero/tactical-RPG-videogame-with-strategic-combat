package com.utad.mais.proyecto_final.abstractfactory;

import com.utad.mais.proyecto_final.strategy.*;

public interface EnemyTransition extends Enemy{

	public void setLife(Integer i);
	public void setEnemyStrategy(EnemyStrategy enemyStrategy);
	
}
