package br.com.rcbr.svc.nascimento.models.dto.response;

import br.com.rcbr.svc.nascimento.models.entity.PessoaEntity;
import br.com.rcbr.svc.nascimento.models.enums.EstadoEnum;
import br.com.rcbr.svc.nascimento.models.enums.GeneroEnum;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PessoaResponse {
    private UUID id;
    private String nomeCompleto;
    private String dataNascimento;
    private String horaNascimento;
    private String cpf;
    private GeneroEnum genero;
    private EstadoEnum estadoNascimento;

    public PessoaResponse buildResponseFromEntity(PessoaEntity pessoaEntity) {
        return PessoaResponse.builder()
                .id(pessoaEntity.getId())
                .nomeCompleto(pessoaEntity.getNomeCompleto())
                .dataNascimento(pessoaEntity.getDataNascimento())
                .horaNascimento(pessoaEntity.getHoraNascimento())
                .cpf(pessoaEntity.getCpf())
                .genero(pessoaEntity.getGenero())
                .estadoNascimento(pessoaEntity.getEstadoNascimento())
                .build();
    }
}
