package br.com.rcbr.svc.nascimento.services;

import br.com.rcbr.svc.nascimento.models.dto.request.PessoaRequest;
import br.com.rcbr.svc.nascimento.models.dto.response.PessoaResponse;

import javax.transaction.Transactional;

public interface CertidaoNascimentoService {

    @Transactional
    PessoaResponse realizaCriacaoDeCertidaoDeNascimento(PessoaRequest pessoaRequest);
}
