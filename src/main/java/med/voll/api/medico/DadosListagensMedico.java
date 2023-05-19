package med.voll.api.medico;

public record DadosListagensMedico(
        Long id,
        String nome,
        String email,
        String crm,
        Especialidade especialidade) {
    public DadosListagensMedico(Medico medico){
        this(medico.getId(), medico.getNome(),medico.getEmail(),medico.getCrm(),medico.getEspecialidade());
    }
}
