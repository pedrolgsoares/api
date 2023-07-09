package med.voll.api.paciente;

public record DadosListagensPaciente(
         Long id,
         String nome,
         String email,
         String telefone,
         String cpf) {
    public DadosListagensPaciente(Paciente paciente){
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getTelefone(), paciente.getCpf());
    }

}
