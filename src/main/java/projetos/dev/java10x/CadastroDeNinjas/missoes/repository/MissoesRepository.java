package projetos.dev.java10x.CadastroDeNinjas.missoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projetos.dev.java10x.CadastroDeNinjas.missoes.model.MissoesModel;

public interface MissoesRepository extends JpaRepository<MissoesModel, Long> {
}
