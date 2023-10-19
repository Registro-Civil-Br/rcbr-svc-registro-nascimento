package br.com.rcbr.svc.nascimento.proxy.impl;

import br.com.rcbr.svc.nascimento.models.enums.EstadoEnum;
import br.com.rcbr.svc.nascimento.proxy.GeradorCpfProxy;
import br.com.rcbr.svc.nascimento.proxy.responses.CpfResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class GeradorCpfProxyImpl {

    @Autowired
    GeradorCpfProxy geradorCpfProxy;

    public CpfResponse acionaComunicacaoComServicoDeCriacaoDeCpf(EstadoEnum estadoEnum) {
        return geradorCpfProxy.geraCpfPessoa(estadoEnum).getBody();
    }
}
