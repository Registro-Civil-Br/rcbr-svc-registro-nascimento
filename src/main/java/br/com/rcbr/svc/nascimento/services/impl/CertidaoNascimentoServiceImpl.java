package br.com.rcbr.svc.nascimento.services.impl;

import br.com.rcbr.svc.nascimento.models.dto.request.PessoaRequest;
import br.com.rcbr.svc.nascimento.models.dto.response.PessoaResponse;
import br.com.rcbr.svc.nascimento.models.entity.PessoaEntity;
import br.com.rcbr.svc.nascimento.proxy.impl.GeradorCpfProxyImpl;
import br.com.rcbr.svc.nascimento.repositories.PessoaRepository;
import br.com.rcbr.svc.nascimento.services.CertidaoNascimentoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CertidaoNascimentoServiceImpl implements CertidaoNascimentoService {

    @Autowired
    GeradorCpfProxyImpl geradorCpfProxyImpl;

    @Autowired
    PessoaRepository pessoaRepository;

    @Override
    public PessoaResponse realizaCriacaoDeCertidaoDeNascimento(PessoaRequest pessoaRequest) {
        log.info("Método de serviço responsável pela criação da pessoa acessado com sucesso");

        log.info("Iniciando acesso ao método de acionamento de comunicação com o serviço de criação de " +
                "novo cpf através dos dados recebidos pela requisição...");
        // TODO String cpfGerado = geradorCpfProxyImpl.acionaComunicacaoComServicoDeCriacaoDeCpf(pessoaRequest);
        String cpfGerado = "471.534.278-21";
        log.info("Acionamento do serviço gerador de Cpf finalizado com sucesso");

        log.info("Iniciando acesso ao método responsável por realizar a conversão do objeto Request " +
                "recebido pelos parâmetros do método para um objeto do tipo Entity...");
        PessoaEntity pessoaEntity = new PessoaEntity().buildEntityFromRequest(pessoaRequest, cpfGerado);
        log.info("Conversão finalizada com sucesso");

        log.info("Iniciando persistência da pessoa no banco de dados...");
        PessoaEntity pessoaPersistida = pessoaRepository.save(pessoaEntity);
        log.info("Pessoa persistida com sucesso");

        log.info("Iniciando acesso ao método responsável por realizar a conversão do objeto Entity " +
                "para objeto do tipo response...");
        PessoaResponse pessoaResponse = new PessoaResponse().buildResponseFromEntity(pessoaPersistida);
        log.info("Conversão para objeto do tipo response finalizada com sucesso");

        log.info("Retornando objeto response criado...");
        return pessoaResponse;
    }
}
