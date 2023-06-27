package br.com.brunosan.screenmatch.repositories;

import br.com.brunosan.screenmatch.domain.filme.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmeRepository extends JpaRepository<Filme, Long> {
}
