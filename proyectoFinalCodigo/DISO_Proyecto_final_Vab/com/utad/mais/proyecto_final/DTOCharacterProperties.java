package com.utad.mais.proyecto_final;

public class DTOCharacterProperties {
	
	//Atributos
	private String name;
	private Integer life;
	private Integer strength;
	private Integer resistence;
	
	//Constructores
	public DTOCharacterProperties(String name, Integer life, Integer strength, Integer resistence) {
		super();
		this.name = name;
		this.life = life;
		this.strength = strength;
		this.resistence = resistence;
	}

	
	//Getters y setters
	public String getName() {
		return name;
	}

	public Integer getLife() {
		return life;
	}
	public void setLife(Integer life) {
		this.life = life;
	}

	public Integer getStrength() {
		return strength;
	}
	public void setStrength(Integer strength) {
		this.strength = strength;
	}

	public Integer getResistence() {
		return resistence;
	}
	public void setResistence(Integer resistence) {
		this.resistence = resistence;
	}

	
}
