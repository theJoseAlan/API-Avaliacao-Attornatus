package br.com.Attornatus.Avaliacao.Service;

import br.com.Attornatus.Avaliacao.Domain.NegocioException;
import br.com.Attornatus.Avaliacao.Entity.Endereco;
import br.com.Attornatus.Avaliacao.Entity.Pessoa;
import br.com.Attornatus.Avaliacao.Repository.EnderecoRepository;
import br.com.Attornatus.Avaliacao.Repository.PessoaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@AllArgsConstructor
@Service
public class EnderecoService {

    private EnderecoRepository enderecoRepository;
    private PessoaRepository pessoaRepository;

    @Transactional
    public Endereco criarEndereco(Endereco endereco){

        Pessoa pessoa = pessoaRepository.findById(endereco.getPessoa()
                .getId()).orElseThrow(() -> new NegocioException("Pessoa não encontrada"));

        endereco.setPessoa(pessoa);

        return enderecoRepository.save(endereco);
    }


}
