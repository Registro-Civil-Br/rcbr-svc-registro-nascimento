package br.com.rcbr.svc.nascimento.models.entity;

import br.com.rcbr.svc.nascimento.models.dto.request.PessoaRequest;
import br.com.rcbr.svc.nascimento.models.enums.EstadoEnum;
import br.com.rcbr.svc.nascimento.models.enums.GeneroEnum;
import lombok.*;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "RCBR_TB_PESSOA")
public class PessoaEntity {

    @Id
    @Type(type = "uuid-char")
    @Column(name = "UUID_ID_PES", nullable = false, updatable = false)
    @GeneratedValue(generator = "UUID")
    @Comment("Chave primária do pagamento - UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name = "STR_NOME_PES", nullable = false)
    private String nomeCompleto;

    @Column(name = "DT_DATANASCIMENTO_PES", nullable = false, updatable = false, length = 10)
    private String dataNascimento;

    @Column(name = "HR_HORANASCIMENTO_PES", nullable = false, updatable = false, length = 5)
    private String horaNascimento;

    @Column(name = "STR_CPF_PES", nullable = false, updatable = false, unique = true, length = 14)
    private String cpf;

    @Enumerated(EnumType.STRING)
    @Column(name = "ENUM_GENERO_PES", updatable = false, nullable = false)
    private GeneroEnum genero;

    @Enumerated(EnumType.STRING)
    @Column(name = "ENUM_ESTADONASCIMENTO_PES", updatable = false, nullable = false)
    private EstadoEnum estadoNascimento;

    public PessoaEntity buildEntityFromRequest(PessoaRequest pessoaRequest, String cpfGerado) {
        return PessoaEntity.builder()
                .nomeCompleto(pessoaRequest.getNomeCompleto())
                .dataNascimento(pessoaRequest.getDataNascimento())
                .horaNascimento(pessoaRequest.getHoraNascimento())
                .cpf(cpfGerado)
                .genero(pessoaRequest.getGenero())
                .estadoNascimento(pessoaRequest.getEstadoNascimento())
                .build();
    }
}
