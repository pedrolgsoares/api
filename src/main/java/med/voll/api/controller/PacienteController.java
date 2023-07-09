package med.voll.api.controller;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.medico.Medico;
import med.voll.api.paciente.DadosCadastroPaciente;
import med.voll.api.paciente.Paciente;
import med.voll.api.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("pacientes")
public class PacienteController {

    @Autowired //INTERFACE REPOSITORY -> FAZ O CARREGAMENTO REALIZANDO ASSIM A INJEÇÃO DE DEPENDENCIA
    private PacienteRepository pacienteRepository;
    @PostMapping
    @Transactional // para uma transação ativa com banco de dados
    public void cadastrar(@RequestBody @Valid DadosCadastroPaciente dados){
        //          Entidade do tipo JPA Medico que recebe DTO dados
        pacienteRepository.save(new Paciente(dados));

    }

}
