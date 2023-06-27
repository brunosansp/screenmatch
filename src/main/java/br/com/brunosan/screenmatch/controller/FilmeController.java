package br.com.brunosan.screenmatch.controller;

import br.com.brunosan.screenmatch.domain.filme.DadosCadastroFilme;
import br.com.brunosan.screenmatch.domain.filme.Filme;
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

    private List<Filme> filmes = new ArrayList<>();

    @GetMapping("/formulario")
    public String carregaPaginaFormulario() {
        return "filmes/formulario";
    }

    @GetMapping
    public String carregaPaginaListagem(Model model) {
        model.addAttribute("lista", filmes);
        return "filmes/listagem";
    }

    @PostMapping
    public String cadastraFilme(DadosCadastroFilme dados) {
        Filme filme = new Filme(dados);
        filmes.add(filme);
        return "redirect:/filmes";
    }
}
