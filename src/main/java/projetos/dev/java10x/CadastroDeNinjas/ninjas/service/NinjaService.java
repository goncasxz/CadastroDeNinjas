package projetos.dev.java10x.CadastroDeNinjas.ninjas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetos.dev.java10x.CadastroDeNinjas.ninjas.dto.NinjaDTO;
import projetos.dev.java10x.CadastroDeNinjas.ninjas.mapper.NinjaMapper;
import projetos.dev.java10x.CadastroDeNinjas.ninjas.model.NinjaModel;
import projetos.dev.java10x.CadastroDeNinjas.ninjas.repository.NinjaRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    @Autowired
    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    //Adicionar um ninja
    public NinjaDTO criarNinja(NinjaDTO ninjaDTO) {
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        ninja = ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);
    }

    //Listar todos os ninjas
    public List<NinjaDTO> listarNinjas() {
        List<NinjaModel> ninjas = ninjaRepository.findAll(); //pega a lista de ninjas do banco e nao retorna por boa pratica de segurança
        return ninjas.stream() //transforma a lista de NinjaModel em um fluxo de dados
                .map(ninjaMapper::map) //faz uma chamada no metodo do ninjaMapper semelhante a ninja (variavel local) -> ninjaMapper.map(ninja) : no caso seria assim utilizando lambda
                .collect(Collectors.toList()); // transforma o retorno de DTO em uma collections - lista
    }

    //Listar os ninjas por ID
    public Optional<NinjaDTO> listarNinjasId(Long id) {
        Optional<NinjaModel> ninjaId = ninjaRepository.findById(id);
        return ninjaId.map(ninjaMapper::map);
    }
    
    //Atualizar ninja por ID
    public NinjaDTO atualizarNinja(Long id, NinjaDTO ninjaDTO) {
        Optional<NinjaModel> ninjaModelOptional = ninjaRepository.findById(id);

        if (ninjaModelOptional.isPresent()) {
            NinjaModel ninjaAtualizado = ninjaModelOptional.get();

            if (ninjaDTO.getNome() != null) {
                ninjaAtualizado.setNome(ninjaDTO.getNome());
            }

            if (ninjaDTO.getEmail() != null) {
                ninjaAtualizado.setEmail(ninjaDTO.getEmail());
            }

            if (ninjaDTO.getIdade() != null) {
                ninjaAtualizado.setIdade(ninjaDTO.getIdade());
            }

            if (ninjaDTO.getImgUrl() != null) {
                ninjaAtualizado.setImgUrl(ninjaDTO.getImgUrl());
            }

            if (ninjaDTO.getRank() != null) {
                ninjaAtualizado.setRank(ninjaDTO.getRank());
            }

            if (ninjaDTO.getMissoes() != null) {
                ninjaAtualizado.setMissoes(ninjaDTO.getMissoes());
            }

            ninjaAtualizado = ninjaRepository.save(ninjaAtualizado);
            return ninjaMapper.map(ninjaAtualizado);
        }
        return null;
    }

    //Deletar ninja por ID
    public void deletarPorId(Long id) {
        ninjaRepository.deleteById(id);
    }
}
