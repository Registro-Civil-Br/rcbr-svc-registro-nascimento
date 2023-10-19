package br.com.rcbr.svc.nascimento.proxy;

import br.com.rcbr.svc.nascimento.models.dto.request.PessoaRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "gerador-cpf", url = "localhost:8081")
public interface GeradorCpfProxy {

    @PostMapping("/api/v1/gerador-cpf")
    ResponseEntity<String> geraCpfPessoa(PessoaRequest pessoaRequest);

}
