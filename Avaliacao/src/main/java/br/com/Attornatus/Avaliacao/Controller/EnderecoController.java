package br.com.Attornatus.Avaliacao.Controller;

import br.com.Attornatus.Avaliacao.Domain.NegocioException;
import br.com.Attornatus.Avaliacao.Entity.Endereco;
import br.com.Attornatus.Avaliacao.Entity.Pessoa;
import br.com.Attornatus.Avaliacao.Repository.EnderecoRepository;
import br.com.Attornatus.Avaliacao.Repository.PessoaRepository;
import br.com.Attornatus.Avaliacao.Service.EnderecoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    private EnderecoService enderecoService;
    private final EnderecoRepository enderecoRepository;
    private final PessoaRepository pessoaRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Endereco adcionar(@Valid @RequestBody Endereco endereco){
        return enderecoService.criarEndereco(endereco);
    }

    @GetMapping("/listar")
    private List<Endereco> lista(){
        return enderecoRepository.findAll();
    }

    @GetMapping("/listar/{pessoaId}")
    public List<Endereco> listaEnderecoPorPessoa(@PathVariable Long pessoaId){

        return enderecoRepository.findAllByPessoa(pessoaRepository.findById(pessoaId).get());
    }

    @GetMapping("/principal/{pessoaId}")
    public Pessoa enderecoPrincipal(@PathVariable Long pessoaId){

        Pessoa pessoa = pessoaRepository.findById(pessoaId).
                orElseThrow(() -> new NegocioException("Pessoa não encontrada"));

        return pessoa;
    }

}
