package br.com.Attornatus.Avaliacao.ExceptionHandler;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class Problema {

    private int status;

    private LocalDateTime dataHora;

    private String titulo;

    List<Campo> campos;

}
