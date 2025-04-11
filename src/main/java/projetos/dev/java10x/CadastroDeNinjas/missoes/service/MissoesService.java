package projetos.dev.java10x.CadastroDeNinjas.missoes.service;

import org.springframework.stereotype.Service;
import projetos.dev.java10x.CadastroDeNinjas.missoes.model.MissoesModel;
import projetos.dev.java10x.CadastroDeNinjas.missoes.repository.MissoesRepository;

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
