package br.com.brunosan.screenmatch.controller;

import br.com.brunosan.screenmatch.domain.filme.DadosCadastroFilme;
import br.com.brunosan.screenmatch.domain.filme.Filme;
import br.com.brunosan.screenmatch.repositories.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private FilmeRepository filmeRepository;

    @GetMapping("/formulario")
    public String carregaPaginaFormulario() {
        return "filmes/formulario";
    }

    @GetMapping
    public String carregaPaginaListagem(Model model) {
        model.addAttribute("lista", filmeRepository.findAll());
        return "filmes/listagem";
    }

    @PostMapping
    public String cadastraFilme(DadosCadastroFilme dados) {
        Filme filme = new Filme(dados);
        filmeRepository.save(filme);
        return "redirect:/filmes";
    }
}
