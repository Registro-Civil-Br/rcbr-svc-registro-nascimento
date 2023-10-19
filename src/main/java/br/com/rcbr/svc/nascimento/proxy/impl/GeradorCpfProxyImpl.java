package br.com.rcbr.svc.nascimento.proxy.impl;

import br.com.rcbr.svc.nascimento.models.dto.request.PessoaRequest;
import br.com.rcbr.svc.nascimento.proxy.GeradorCpfProxy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class GeradorCpfProxyImpl {

    @Autowired
    GeradorCpfProxy geradorCpfProxy;

    public String acionaComunicacaoComServicoDeCriacaoDeCpf(PessoaRequest pessoaRequest) {
        return geradorCpfProxy.geraCpfPessoa(pessoaRequest).getBody();
    }
}
