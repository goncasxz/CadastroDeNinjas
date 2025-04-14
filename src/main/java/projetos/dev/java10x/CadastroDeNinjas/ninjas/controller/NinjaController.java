package projetos.dev.java10x.CadastroDeNinjas.ninjas.controller;
import org.springframework.web.bind.annotation.*;
import projetos.dev.java10x.CadastroDeNinjas.ninjas.dto.NinjaDTO;
import projetos.dev.java10x.CadastroDeNinjas.ninjas.model.NinjaModel;
import projetos.dev.java10x.CadastroDeNinjas.ninjas.service.NinjaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasVindas")
    public String boasVindas() {
        return "Essa é minha primeira mensagem nessa rota";
    }

    // TODO: Adicionar Ninjas
    @PostMapping("/criar")
    public NinjaDTO criarNinja(@RequestBody NinjaDTO ninja) {
        return ninjaService.criarNinja(ninja);
    }

    // TODO: Procurar Ninjas por ID
    @GetMapping("/listar/{id}")
    public Optional<NinjaModel> mostrarNinjasPorId(@PathVariable Long id) {
        return ninjaService.listarNinjasId(id);
    }

    // TODO: Mostrar todos os Ninjas
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas() {
        return ninjaService.listarNinjas();
    }

    // TODO: Alterar dados dos Ninjas
    @PutMapping("/alterar/{id}")
    public NinjaModel alterarNinjaPorId(@PathVariable Long id,@RequestBody NinjaModel ninjaAtualizado) {
        return ninjaService.atualizarNinja(id, ninjaAtualizado);
    }

    // TODO: Deletar Ninjas
    @DeleteMapping("/deletar/{id}")
    public void deletarNinjaPorId(@PathVariable Long id) {
        ninjaService.deletarPorId(id);
    }


}
