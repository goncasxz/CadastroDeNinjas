package projetos.dev.java10x.CadastroDeNinjas.Ninjas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projetos.dev.java10x.CadastroDeNinjas.Ninjas.Model.NinjaModel;

public interface NinjaRepository extends JpaRepository<NinjaModel, Long> {
}
