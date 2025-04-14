package projetos.dev.java10x.CadastroDeNinjas.ninjas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetos.dev.java10x.CadastroDeNinjas.ninjas.dto.NinjaDTO;
import projetos.dev.java10x.CadastroDeNinjas.ninjas.mapper.NinjaMapper;
import projetos.dev.java10x.CadastroDeNinjas.ninjas.model.NinjaModel;
import projetos.dev.java10x.CadastroDeNinjas.ninjas.repository.NinjaRepository;

import java.util.List;
import java.util.Optional;

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
    public List<NinjaModel> listarNinjas() {
        return ninjaRepository.findAll();
    }

    //Listar os ninjas por ID
    public Optional<NinjaModel> listarNinjasId(Long id) {
        return ninjaRepository.findById(id);
    }
    
    //Atualizar ninja por ID
    public NinjaModel atualizarNinja(Long id, NinjaModel ninjaAtualizado) {
        if (ninjaRepository.existsById(id)) {
            ninjaAtualizado.setId(id);
            return ninjaRepository.save(ninjaAtualizado);
        }
        return null;
    }

    //Deletar ninja por ID
    public void deletarPorId(Long id) {
        ninjaRepository.deleteById(id);
    }
}
