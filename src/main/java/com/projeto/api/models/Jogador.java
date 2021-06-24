package com.projeto.api.models;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data

public class Jogador extends AtributoJog{

	
//	private static final long serialVersionUID=1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cod_jogador;
	
	@Column(name="nome")
	@NotBlank(message = "Preencha o nome")
	private String nome;
	
	@Column(name="goleiro")
	private Boolean goleiro;

//	@Column(name="time")
//	private MeuTime time;
	
	@Column(name = "nivel")
	private Double nivel;
	
//	@OneToMany
//	@JoinColumn(name="atributo")
//	private List<AtributoJog> atributo;
	
}
