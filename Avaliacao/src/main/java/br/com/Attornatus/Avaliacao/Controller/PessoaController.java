package br.com.Attornatus.Avaliacao.Controller;

import br.com.Attornatus.Avaliacao.Entity.Pessoa;
import br.com.Attornatus.Avaliacao.Repository.PessoaRepository;
import br.com.Attornatus.Avaliacao.Service.PessoaService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @PersistenceContext
    private EntityManager manager;

    private PessoaRepository pessoaRepository;
    private PessoaService pessoaService;

    @GetMapping("/listar")
    public List<Pessoa> listar(){
        return pessoaRepository.findAll();
    }

    @GetMapping("/{contem}")
    public List<Pessoa> listarcontem(@PathVariable String contem){

        return pessoaRepository.findByNomeContaining(contem);
    }
    //Pesquisa por nome
    @GetMapping("/nome/{nome}")
    public List<Pessoa> buscaporNome(@PathVariable String nome){

        return pessoaRepository.findAllByNome(nome);

    }

    //Pesquisa por Id
    @GetMapping("/id/{pessoaId}")
    public ResponseEntity<Pessoa> buscaporId(@PathVariable Long pessoaId){
        Optional<Pessoa> pessoa = pessoaRepository.findById(pessoaId);

       if(pessoa.isPresent()){
           return ResponseEntity.ok(pessoa.get());
       }
       return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pessoa inserir(@Valid @RequestBody Pessoa pessoa){
        return pessoaService.salvar(pessoa);
    }

    @PutMapping("/{pessoaId}")
    public ResponseEntity<Pessoa> atualizar(@PathVariable Long pessoaId, @Valid @RequestBody Pessoa pessoa){
        if(!pessoaRepository.existsById(pessoaId)){
            return ResponseEntity.notFound().build();
        }
        pessoa.setId(pessoaId);
        pessoa = pessoaService.salvar(pessoa);

        return ResponseEntity.ok(pessoa);
    }

    @DeleteMapping("/remover/{pessoaId}")
    public ResponseEntity<Void> remover(@PathVariable Long pessoaId){
        if(!pessoaRepository.existsById(pessoaId)){
            return ResponseEntity.notFound().build();
        }

        pessoaService.remover(pessoaId);

        return ResponseEntity.noContent().build();
    }

}
