package projetos.dev.java10x.CadastroDeNinjas.ninjas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projetos.dev.java10x.CadastroDeNinjas.ninjas.model.NinjaModel;

public interface NinjaRepository extends JpaRepository<NinjaModel, Long> {
}
