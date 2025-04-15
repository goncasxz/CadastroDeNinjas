package projetos.dev.java10x.CadastroDeNinjas.missoes.mapper;

import org.springframework.stereotype.Component;
import projetos.dev.java10x.CadastroDeNinjas.missoes.dto.MissoesDTO;
import projetos.dev.java10x.CadastroDeNinjas.missoes.model.MissoesModel;

@Component
public class MissoesMapper {

    public MissoesModel map(MissoesDTO missoesDTO){
        MissoesModel missoesModel = new MissoesModel();
        missoesModel.setId(missoesDTO.getId());
        missoesModel.setNome(missoesDTO.getNome());
        missoesModel.setRank(missoesDTO.getRank());
//        missoesModel.setNinjas(missoesDTO.getNinjas());

        return missoesModel;
    }

    public MissoesDTO map(MissoesModel missoesModel) {
        MissoesDTO missoesDTO = new MissoesDTO();
        missoesDTO.setId(missoesModel.getId());
        missoesDTO.setNome(missoesModel.getNome());
        missoesDTO.setRank(missoesModel.getRank());
//        missoesDTO.setNinjas(missoesModel.getNinjas());

        return missoesDTO;
    }
}
