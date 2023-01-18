package br.com.Attornatus.Avaliacao.Service;

import br.com.Attornatus.Avaliacao.Entity.Pessoa;
import br.com.Attornatus.Avaliacao.Repository.PessoaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PessoaService {
    @Autowired
    PessoaRepository pessoaRepository;

    //Essa classe também serve para regras de negocio
    @Transactional//Esse metodo deve ser executado dentro de uma transação. Se algo der ruim, descarta tudo que foi feito
    public Pessoa salvar(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    @Transactional
    public void remover(Long pessoaId){
        pessoaRepository.deleteById(pessoaId);
    }

    public Optional<Pessoa> buscaPorNome(String nome){
        return pessoaRepository.findByNome(nome);
    }

}
