package br.com.Attornatus.Avaliacao.Model;

import br.com.Attornatus.Avaliacao.Entity.Endereco;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EnderecoModel {

    private Long id;
    private String nomePessoa;
    private String dataNascimento;

    private String endereco_log;
    private String end_cep;
    private String end_num;
    private String end_cidade;

}
