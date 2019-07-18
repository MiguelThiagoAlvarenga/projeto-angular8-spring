package com.empresa.cadastroproposta.controllers;

import com.empresa.cadastroproposta.models.Proposta;
import com.empresa.cadastroproposta.services.PropostaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/proposta")
public class PropostasController {

    @Autowired
    PropostaService service;

    @PostMapping("/cadastrar")
    public @ResponseBody String ativarBarragem(@RequestBody Proposta proposta) {
        Proposta propostaSalva = service.cadastrar(proposta);
        String retorno = Objects.nonNull(propostaSalva) ? "Cadastro efetuado com sucesso." : "Erro ao cadastrar";
        return retorno;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/listar")
    public @ResponseBody List<Proposta> listar() {
        return service.listarPropostas();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/listarAprovadas")
    public @ResponseBody List<Proposta> listarAprovadas() {
        return service.listarAprovadas();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/porCpf/{cpf}")
    public @ResponseBody Proposta byCpfCliente(@PathVariable("cpf") String cpf){
        return service.byCpfCliente(cpf);
    }


}
