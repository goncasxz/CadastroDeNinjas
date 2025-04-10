package projetos.dev.java10x.CadastroDeNinjas.Missoes.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import projetos.dev.java10x.CadastroDeNinjas.Missoes.Model.MissoesModel;
import projetos.dev.java10x.CadastroDeNinjas.Missoes.Repository.MissoesRepository;

import java.util.List;
import java.util.Optional;


@Service
public class MissoesService {

    private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    //Adicionar missao
    public MissoesModel adicionarMissoes(MissoesModel missao) {
        return missoesRepository.save(missao);
    }

    //Listar missoes
    public List<MissoesModel> listarMissoes() {
        return missoesRepository.findAll();
    }

    //Listar missoes por ID
    public Optional<MissoesModel> listarMissoesId(Long id){
        return missoesRepository.findById(id);
    }
}
