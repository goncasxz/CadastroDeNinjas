package projetos.dev.java10x.CadastroDeNinjas.missoes.service;

import org.springframework.stereotype.Service;
import projetos.dev.java10x.CadastroDeNinjas.missoes.dto.MissoesDTO;
import projetos.dev.java10x.CadastroDeNinjas.missoes.mapper.MissoesMapper;
import projetos.dev.java10x.CadastroDeNinjas.missoes.model.MissoesModel;
import projetos.dev.java10x.CadastroDeNinjas.missoes.repository.MissoesRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class MissoesService {

    private MissoesRepository missoesRepository;
    private MissoesMapper missoesMapper;

    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper) {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
    }

    //Adicionar missao
    public MissoesDTO adicionarMissoes(MissoesDTO missao) {
        MissoesModel missoes = missoesMapper.map(missao);
        missoes = missoesRepository.save(missoes);
        return missoesMapper.map(missoes);
    }

    //Listar missoes
    public List<MissoesDTO> listarMissoes() {
        List<MissoesModel> missoes = missoesRepository.findAll();
        return missoes.stream()
                .map(missoesMapper::map)
                .collect(Collectors.toList());
    }

    //Listar missoes por ID
    public Optional<MissoesDTO> listarMissoesId(Long id){
        Optional<MissoesModel> modelOptional = missoesRepository.findById(id);
        return modelOptional.map(missoesMapper::map);
    }

    //Atualizar missoes por id
    public MissoesDTO atualizarMissao(Long id, MissoesDTO missoesDTO) {
        Optional<MissoesModel> optionalMissoesModel = missoesRepository.findById(id);

        if (optionalMissoesModel.isPresent()) {
            MissoesModel missaoAtualizada = optionalMissoesModel.get();

            if (missoesDTO.getNome() != null) {
                missaoAtualizada.setNome(missoesDTO.getNome());
            }

            if (missoesDTO.getRank() != null) {
                missaoAtualizada.setRank(missoesDTO.getRank());
            }

//            if (missoesDTO.getNinjas() != null) {
//                missaoAtualizada.setNinjas(missoesDTO.getNinjas());
//            }

            missaoAtualizada = missoesRepository.save(missaoAtualizada);
            return missoesMapper.map(missaoAtualizada);
        }
        return null;
    }

    public void deletarMissao(Long id) {
        Optional<MissoesModel> optionalMissoesModel = missoesRepository.findById(id);
        if (optionalMissoesModel.isPresent()) {
            MissoesModel missao = optionalMissoesModel.get();
            if (missao.getNinjas() != null && !missao.getNinjas().isEmpty()){
                throw new RuntimeException("Não é possível excluir a missão. Existem ninjas associados.");
            }
        }
        missoesRepository.deleteById(id);
    }
}
