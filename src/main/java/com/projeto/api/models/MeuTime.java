package com.projeto.api.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotBlank;

import com.projeto.api.enuns.Cor;

import lombok.Data;

@Entity
@Data
public class MeuTime {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cod_time;
	
	@Column(name = "nome")
	@NotBlank(message = "O nome não pode ser nulo")
	private String nome;
	
	@Column(name = "cor")
	@Enumerated(EnumType.STRING)
	private Cor cor;

	@OneToMany
	@JoinColumn(name="jogador")
	private List<Jogador> jogador;
}
