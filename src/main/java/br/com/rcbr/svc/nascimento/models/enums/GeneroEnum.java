package br.com.rcbr.svc.nascimento.models.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GeneroEnum {

    MASCULINO (0, "Masculino"),
    FEMININO (1, "Feminino");

    private final int code;
    private final String desc;
}
