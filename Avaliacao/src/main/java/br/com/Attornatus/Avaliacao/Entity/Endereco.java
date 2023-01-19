package br.com.Attornatus.Avaliacao.Entity;

import br.com.Attornatus.Avaliacao.Domain.ValidationGroups;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.ConvertGroup;
import jakarta.validation.groups.Default;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Endereco {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String logradouro;

    @NotBlank
    private String cep;

    @NotBlank
    private String numero;

    @NotBlank
    private String cidade;


    @Valid
    //Para converter o Defaut do beanValidation para o meu
    @ConvertGroup(from = Default.class, to = ValidationGroups.PessoaId.class)
    @NotNull
    @ManyToOne
    private Pessoa pessoa;

}
