package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping
    // Não será necessário a anotação @Transactional, pois não haverá envios ou alterações para nossa tabela
    public Page<DadosListagensMedico> listar(@PageableDefault(size = 10,sort = {"nome"}) Pageable pageable){ // gerando uma sobrecarga com pageable
        return repository.findAllByAtivoTrue(pageable).map(DadosListagensMedico::new);
        //operador de referência de método em Java, é usado para chamar um método referindo-se a ele
        //diretamente com a ajuda de sua classe. Eles se comportam exatamente como as expressões lambda.
        //A única diferença que tem das expressões lambda é que ela usa referência direta ao método por nome
        //em vez de fornecer um delegado ao método. SINTAXE: <Class name>::<method name>
    }
    @PutMapping
    @Transactional // para uma transação ativa com banco de dados
    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados){
        //          Entidade do tipo JPA Medico que recebe DTO dados
        Medico medico = repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);

    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        Medico medico = repository.getReferenceById(id);
        medico.excluir();
    }
}
