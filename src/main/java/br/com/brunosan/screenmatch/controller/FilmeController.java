package br.com.brunosan.screenmatch.controller;

import br.com.brunosan.screenmatch.domain.filme.DadosAlteracaoFilme;
import br.com.brunosan.screenmatch.domain.filme.DadosCadastroFilme;
import br.com.brunosan.screenmatch.domain.filme.Filme;
import br.com.brunosan.screenmatch.repositories.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private FilmeRepository filmeRepository;

    @GetMapping("/formulario")
    public String carregaPaginaFormulario(Long id, Model model) {
        if (id != null) {
            Filme filme = filmeRepository.getReferenceById(id);
            model.addAttribute("filme", filme);
        }
        return "filmes/formulario";
    }

    @GetMapping
    public String carregaPaginaListagem(Model model) {
        model.addAttribute("lista", filmeRepository.findAll());
        return "filmes/listagem";
    }

    @PostMapping
    @Transactional
    public String cadastraFilme(DadosCadastroFilme dados) {
        Filme filme = new Filme(dados);
        filmeRepository.save(filme);
        return "redirect:/filmes";
    }

    @DeleteMapping
    @Transactional
    public String removeFilme(Long id) {
        filmeRepository.deleteById(id);
        return "redirect:/filmes";
    }

    @PutMapping
    @Transactional
    public String editarFilme(DadosAlteracaoFilme dados) {
        Filme filme = filmeRepository.getReferenceById(dados.id());
        filme.atualizaFilme(dados);
        return "redirect:/filmes";
    }
}
