package projetos.dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.data.jpa.repository.JpaRepository;
import projetos.dev.java10x.CadastroDeNinjas.Missoes.Model.MissoesModel;

public interface MissoesRepository extends JpaRepository<MissoesModel, Long> {
}
