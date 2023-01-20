package br.com.Attornatus.Avaliacao.Model;


import lombok.Getter;
import lombok.Setter;



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
