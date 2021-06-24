package com.projeto.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.api.models.Jogador;
import com.projeto.api.models.MeuTime;
import com.projeto.api.repository.JogadorRepository;
import com.projeto.api.repository.MeuTimeRespository;

@Controller
@RequestMapping("/time")
public class MeuTimeController {

	
	@Autowired
	private MeuTimeRespository repTime;
	
	@Autowired
	private JogadorRepository repJog;
	
	
	//CRIAR TIME
	@GetMapping("/criar")
	public ModelAndView criarTime(MeuTime time) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home/criarTime");
		mv.addObject("criarTime", new MeuTime());
		return mv;
	}
	
	@PostMapping("/criar")
	public ModelAndView criarTime(@Valid MeuTime time,BindingResult br ) {
		ModelAndView mv = new ModelAndView();
		if(br.hasErrors()) {
			mv.setViewName("home/criarTime");
			mv.addObject("criarTime");
		}else {
			mv.setViewName("redirect:/time/criar");
			repTime.save(time);
		}
		return mv;
	}
	
	
	//LISTAR TIMES
	@GetMapping("/lista")
	public ModelAndView listarTime() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home/listTime");
		mv.addObject("listTime", repTime.findAll());
		return mv;
	}
	
	//MENU JOGADORES
	@GetMapping("/{id}")
	public ModelAndView listarTime(@PathVariable("id") Integer id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home/listTimeJog");
		mv.addObject("listTime", repTime.getById(id));
		mv.addObject("listJog", repJog.findAll());
		return mv;
	}
	
	//ADICIONAR JOGADORES
	@PostMapping
	public ModelAndView addJog(@PathVariable("id") Integer id, Jogador jogador) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home/listTimeJog");
		mv.addObject("listTime", repTime.getById(id));
		mv.addObject("listJog", repJog.findAll());
		MeuTime time = repTime.getById(id);
		time.setJogador(time.getJogador().add(jogador));
		repTime.save(time);
		
	return mv;
		}
	
	//PESQUISAR JOGADOR
	@PostMapping("**/pesquisarJogador")
	public ModelAndView pesquisaJogador(@RequestParam("nome") String nome) {
		ModelAndView mv = new ModelAndView("home/listTimeJog");
		mv.addObject("listJog", repJog.findByNomeContainingIgnoreCase(nome));
//		mv.addObject("jogador", new Jogador());
		return mv;
	}
}
