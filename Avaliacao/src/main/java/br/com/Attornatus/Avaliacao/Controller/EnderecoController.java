package br.com.Attornatus.Avaliacao.Controller;

import br.com.Attornatus.Avaliacao.Entity.Endereco;
import br.com.Attornatus.Avaliacao.Model.EnderecoModel;
import br.com.Attornatus.Avaliacao.Repository.EnderecoRepository;
import br.com.Attornatus.Avaliacao.Repository.PessoaRepository;
import br.com.Attornatus.Avaliacao.Service.EnderecoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<EnderecoModel> enderecoPrincial(@PathVariable Long pessoaId){

        return enderecoRepository.findById(pessoaId)
                .map(endereco -> {
                    EnderecoModel enderecoModel = new EnderecoModel();

                    enderecoModel.setId(endereco.getPessoa().getId());
                    enderecoModel.setNomePessoa(endereco.getPessoa().getNome());
                    enderecoModel.setDataNascimento(endereco.getPessoa().getData_nascimento());
                    enderecoModel.setEndereco_log(endereco.getPessoa().getEnd_Logradouro());
                    enderecoModel.setEnd_num(endereco.getPessoa().getNumero());

                    //enderecoModel.setEnd_cep(endereco.getPessoa().getCep());
                    //enderecoModel.setEnd_cidade(endereco.getPessoa().getCidade());

                    return  ResponseEntity.ok(enderecoModel);
                })
                .orElse(ResponseEntity.notFound().build());
    }


}
