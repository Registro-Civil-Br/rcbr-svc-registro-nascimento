package br.com.rcbr.svc.nascimento.controllers;

import br.com.rcbr.svc.nascimento.models.dto.request.PessoaRequest;
import br.com.rcbr.svc.nascimento.models.dto.response.PessoaResponse;
import br.com.rcbr.svc.nascimento.services.CertidaoNascimentoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/certidao-nascimento")
public class CertidaoNascimentoController {

    @Autowired
    CertidaoNascimentoService certidaoNascimentoService;

    @PostMapping
    public ResponseEntity<PessoaResponse> cadastraNascimentoPessoa(PessoaRequest pessoaRequest) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(certidaoNascimentoService.realizaCriacaoDeCertidaoDeNascimento(pessoaRequest));
    }

}
