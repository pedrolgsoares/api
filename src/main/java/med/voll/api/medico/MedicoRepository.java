package med.voll.api.medico;

import org.springframework.data.jpa.repository.JpaRepository;
//                                          JpaRepository<Classe,tipo_atributo_da_chave_primaria>
public interface MedicoRepository  extends JpaRepository<Medico,Long> {
}
