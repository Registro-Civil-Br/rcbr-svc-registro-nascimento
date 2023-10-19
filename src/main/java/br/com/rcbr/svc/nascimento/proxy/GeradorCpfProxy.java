package br.com.rcbr.svc.nascimento.proxy;

import br.com.rcbr.svc.nascimento.models.enums.EstadoEnum;
import br.com.rcbr.svc.nascimento.proxy.responses.CpfResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "SVC-GATEWAY/cpf")
public interface GeradorCpfProxy {

    @PostMapping
    ResponseEntity<CpfResponse> geraCpfPessoa(EstadoEnum estadoEnum);

}
