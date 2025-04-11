package projetos.dev.java10x.CadastroDeNinjas.ninjas.service;

import org.springframework.stereotype.Service;
import projetos.dev.java10x.CadastroDeNinjas.ninjas.model.NinjaModel;
import projetos.dev.java10x.CadastroDeNinjas.ninjas.repository.NinjaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    //Adicionar um ninja
    public NinjaModel criarNinja(NinjaModel ninja) {
        return ninjaRepository.save(ninja);
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
