package projetos.dev.java10x.CadastroDeNinjas.ninjas.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projetos.dev.java10x.CadastroDeNinjas.ninjas.dto.NinjaDTO;
import projetos.dev.java10x.CadastroDeNinjas.ninjas.model.NinjaAtualizadoMapper;
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
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO ninjaDTO = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso" + ninjaDTO.getNome() + " (ID) " + ninjaDTO.getId());
    }

    // TODO: Procurar Ninjas por ID
    @GetMapping("/listar/{id}")
    public ResponseEntity<Object> mostrarNinjasPorId(@PathVariable Long id) {
        Optional<NinjaDTO> ninjaDTOOptional = ninjaService.listarNinjasId(id);
        if (ninjaDTOOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(ninjaDTOOptional.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja ID" + id + " não encontrado");
        }
    }

    // TODO: Mostrar todos os Ninjas
    @GetMapping("/listar")
    public List<NinjaDTO> listarNinjas() {
        return ninjaService.listarNinjas();
    }

    // TODO: Alterar dados dos Ninjas
    @PatchMapping("/alterar/{id}")
    public ResponseEntity<Object> alterarNinjaPorId(@PathVariable Long id,@RequestBody NinjaDTO ninjaAtualizado) {
        Optional<NinjaDTO> ninjaDTOOptional = ninjaService.listarNinjasId(id);
        if (ninjaDTOOptional.isPresent()) {
            NinjaDTO antigo = ninjaDTOOptional.get();
            NinjaDTO atualizado = ninjaService.atualizarNinja(id, ninjaAtualizado);
            NinjaDTO camposAlterados = NinjaAtualizadoMapper.compararCampos(antigo, atualizado);

            return ResponseEntity.status(HttpStatus.OK)
                    .body("Ninja ID " + id + " atualizado com sucesso:\n " + camposAlterados);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja ID" + id + " não encontrado");
        }
    }

    // TODO: Deletar Ninjas
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id) {
        if (ninjaService.listarNinjasId(id) != null) {
            ninjaService.deletarPorId(id);
            return ResponseEntity.ok("Ninja com o ID " + id + " deletado com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com o ID" + id + " não encontrado");
        }
    }


}
