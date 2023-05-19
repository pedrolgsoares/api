package med.voll.api.medico;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
//                                          JpaRepository<Classe,tipo_atributo_da_chave_primaria>
public interface MedicoRepository  extends JpaRepository<Medico,Long> {
    Page<Medico> findAllByAtivoTrue(Pageable pageable);
}
