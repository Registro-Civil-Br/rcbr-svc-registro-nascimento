package br.com.rcbr.svc.nascimento.models.dto.request;

import br.com.rcbr.svc.nascimento.models.enums.EstadoEnum;
import br.com.rcbr.svc.nascimento.models.enums.GeneroEnum;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@ToString
public class PessoaRequest {

    @NotEmpty(message = "O nome da pessoa não pode ser vazio")
    @Size(message = "O nome completo da pessoa não pode possuir mais de {max} caracteres", max = 120)
    private String nomeCompleto;

    @NotEmpty(message = "A data de nascimento da pessoa não pode ser vazia")
    @Pattern(message = "O padrão enviado de data de nascimento enviado é inválido", regexp = "\\d{2}/\\d{2}/\\d{4}")
    private String dataNascimento;

    @NotEmpty(message = "A hora de nascimento da pessoa não pode ser vazia")
    @Pattern(message = "O padrão de hora de nascimento enviado é inválido", regexp = "\\d{2}:\\d{2}")
    private String horaNascimento;

    @NotNull(message = "O gênero da pessoa não pode ser nulo")
    private GeneroEnum genero;

    @NotNull(message = "O estado de nascimento da pessoa não pode ser nulo")
    private EstadoEnum estadoNascimento;
}
