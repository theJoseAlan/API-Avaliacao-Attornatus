package br.com.Attornatus.Avaliacao.Repository;

import br.com.Attornatus.Avaliacao.Entity.Endereco;
import br.com.Attornatus.Avaliacao.Entity.Pessoa;
import org.hibernate.sql.Delete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    List<Endereco> findAllByPessoa(Pessoa pessoa);


    Endereco deleteAllById(Long pessoaId);

    Boolean existsByPessoa(Pessoa pessoa);
}
