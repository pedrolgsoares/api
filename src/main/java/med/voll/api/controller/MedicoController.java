package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.medico.DadosCadastroMedico;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired //INTERFACE REPOSITORY -> FAZ O CARREGAMENTO REALIZANDO ASSIM A INJEÇÃO DE DEPENDENCIA
    private MedicoRepository repository;
    @PostMapping
    @Transactional // para uma transação ativa com banco de dados
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados){
        //          Entidade do tipo JPA Medico que recebe DTO dados
        repository.save(new Medico(dados));

    }
}
