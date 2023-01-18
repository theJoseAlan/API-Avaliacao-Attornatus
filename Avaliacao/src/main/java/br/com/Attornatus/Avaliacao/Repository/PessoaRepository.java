package br.com.Attornatus.Avaliacao.Repository;

import br.com.Attornatus.Avaliacao.Entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    Optional<Pessoa> findById(Long id);
    Optional<Pessoa> findByNome(String nome);

    List<Pessoa> findByNomeContaining(String palavra);

    List<Pessoa> findAllByNome(String nome);
}
