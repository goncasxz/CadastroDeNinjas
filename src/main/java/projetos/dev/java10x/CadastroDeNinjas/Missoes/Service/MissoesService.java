package projetos.dev.java10x.CadastroDeNinjas.Missoes.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import projetos.dev.java10x.CadastroDeNinjas.Missoes.Model.MissoesModel;
import projetos.dev.java10x.CadastroDeNinjas.Missoes.Repository.MissoesRepository;


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
}
