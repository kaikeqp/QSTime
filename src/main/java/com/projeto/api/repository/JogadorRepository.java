package com.projeto.api.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.api.models.Jogador;
import com.projeto.api.models.MeuTime;

@Repository
public interface JogadorRepository extends JpaRepository<Jogador, Integer>{


	List<Jogador> findByNomeContainingIgnoreCase(String nome);

}
