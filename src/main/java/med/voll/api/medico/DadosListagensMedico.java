package med.voll.api.medico;

public record DadosListagensMedico(
        String nome,
        String email,
        String crm,
        Especialidade especialidade) {
    public DadosListagensMedico(Medico medico){
        this(medico.getNome(),medico.getEmail(),medico.getCrm(),medico.getEspecialidade());
    }
}
