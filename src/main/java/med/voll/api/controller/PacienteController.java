package med.voll.api.controller;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.paciente.DadosCadastroPaciente;
import med.voll.api.paciente.DadosListagensPaciente;
import med.voll.api.paciente.Paciente;
import med.voll.api.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    @GetMapping
    // Não será necessário a anotação @Transactional, pois não haverá envios ou alterações para nossa tabela
    public Page<DadosListagensPaciente> listar(@PageableDefault(size = 10,sort = {"nome"}) Pageable pageable){ // gerando uma sobrecarga com pageable
        return pacienteRepository.findAllByAtivoTrue(pageable).map(DadosListagensPaciente::new);
        //operador de referência de método em Java, é usado para chamar um método referindo-se a ele
        //diretamente com a ajuda de sua classe. Eles se comportam exatamente como as expressões lambda.
        //A única diferença que tem das expressões lambda é que ela usa referência direta ao método por nome
        //em vez de fornecer um delegado ao método. SINTAXE: <Class name>::<method name>
    }
}
