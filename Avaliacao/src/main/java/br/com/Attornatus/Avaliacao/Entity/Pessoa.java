package br.com.Attornatus.Avaliacao.Entity;

import br.com.Attornatus.Avaliacao.Domain.ValidationGroups;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.Default;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Entity
public class Pessoa {


    @NotNull(groups = ValidationGroups.PessoaId.class)
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank
    private String nome;

    @NotBlank
    private String data_nascimento;

    @NotBlank
    private String end_Logradouro;

    @NotBlank
    private String cep;

    @NotBlank
    private String numero;

    @NotBlank
    private String cidade;

    public Pessoa(){

    }

}