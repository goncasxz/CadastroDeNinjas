package projetos.dev.java10x.CadastroDeNinjas.ninjas.controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    private final  NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    // TODO: Adicionar Ninjas
    @PostMapping("/criar")
    @Operation(summary = "Cria novo ninja", description = "Rota cria um novo ninja e insere no DB")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na criação do Ninja")
    })
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO ninjaDTO = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso" + ninjaDTO.getNome() + " (ID) " + ninjaDTO.getId());
    }

    // TODO: Procurar Ninjas por ID
    @GetMapping("/listar/{id}")
    @Operation(summary = "Lista ninja por ID", description = "Rota lista um ninja pelo seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado")
    })
    public ResponseEntity<Object> mostrarNinjasPorId(
            @Parameter(description = "Usuario envia ID no caminho da requisição")
            @PathVariable Long id) {
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
    @Operation(summary = "Lista todos os ninja", description = "Rota lista todos os Ninjas cadastrados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna lista com Ninjas")
    })
    public List<NinjaDTO> listarNinjas() {
        return ninjaService.listarNinjas();
    }

    // TODO: Alterar dados dos Ninjas
    @PatchMapping("/alterar/{id}")
    @Operation(summary = "Altera ninja por ID", description = "Rota altera um ninja pelo seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado")
    })
    public ResponseEntity<Object> alterarNinjaPorId(
            @Parameter(description = "Usuario envia ID no caminho da requisição")
            @PathVariable Long id,
            @Parameter(description = "Usuario envia dados do Ninja a ser atualizado pelo corpo da requisição")
            @RequestBody NinjaDTO ninjaAtualizado) {

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
    @Operation(summary = "Deleta ninja por ID", description = "Rota deleta um ninja pelo seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado")
    })
    public ResponseEntity<String> deletarNinjaPorId(
            @Parameter(description = "Usuario passa ID no caminho da requisição")
            @PathVariable Long id) {
        if (ninjaService.listarNinjasId(id) != null) {
            ninjaService.deletarPorId(id);
            return ResponseEntity.ok("Ninja com o ID " + id + " deletado com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com o ID" + id + " não encontrado");
        }
    }


}
