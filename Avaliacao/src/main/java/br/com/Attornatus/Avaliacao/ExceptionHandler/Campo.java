package br.com.Attornatus.Avaliacao.ExceptionHandler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

//Para identificar o campo do erro e mostrar uma mensagem relacionada a ele

@AllArgsConstructor
@Getter
@Setter
public class Campo {

    private String campo;
    private String menssagem;

}
