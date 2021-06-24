package com.projeto.api.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.api.models.Jogador;
import com.projeto.api.repository.JogadorRepository;

@Controller
@RequestMapping("/jogador")
public class JogadorController {

	@Autowired
	private JogadorRepository repJog;
	
	
	// CRIAR JOGADOR
	
	@GetMapping("/criar")
	public ModelAndView criarJogador(Jogador ojogador) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home/criarJog");
		mv.addObject("criarJog", new Jogador());
		return mv;
	}
	
	@PostMapping("/criar")
	public ModelAndView criarJogador(@Valid Jogador ojogador, BindingResult br) {
		ModelAndView mv = new ModelAndView();
		if(br.hasErrors()) {
			mv.setViewName("home/criarJog");
			mv.addObject("criarJog");
		}else {
			mv.setViewName("redirect:/jogador/lista");
			repJog.save(ojogador);
	}
		return mv;
	}
	
	
	//LISTAR JOGADOR
	@GetMapping("lista")
	public ModelAndView listarJogador() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home/listJog");
		mv.addObject("listJog", repJog.findAll());
		return mv;
	}
	
	
	//EDITAR JOGADOR
	
	@GetMapping("/alterar/{id}")
	public ModelAndView alterarJogador(@PathVariable("id") Integer id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home/editarJog");
		mv.addObject("editJog" , repJog.getById(id));
		return mv;
	}
	
	
	@PostMapping("/alterar")
	public ModelAndView alterarJogador(Jogador ojogador) {
		ModelAndView mv = new ModelAndView();
			mv.setViewName("redirect:/jogador/lista");
			repJog.save(ojogador);
//		}
		return mv;
	}
	
	//EXCLUIR JOGADOR
	
	@GetMapping("/excluir/{id}")
	public String excluirJogador(@PathVariable("id") Integer id) {
		repJog.deleteById(id);
		return "redirect:/jogador/lista";
	}
	
	
	
}
