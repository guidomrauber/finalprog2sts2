package com.example.main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="mutante")
public class Mutante {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true)
    public String dna2;
    
    @NotBlank
    @Column(unique = true)
    
   public String condicion;

	public Mutante() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Mutante(@NotBlank String dna2, @NotBlank String condicion) {
		super();
		this.dna2 = dna2;
		this.condicion = condicion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDna2() {
		return dna2;
	}

	public void setDna2(String dna2) {
		this.dna2 = dna2;
	}

	public String getCondicion() {
		return condicion;
	}

	public void setCondicion(String condicion) {
		this.condicion = condicion;
	}
    
}