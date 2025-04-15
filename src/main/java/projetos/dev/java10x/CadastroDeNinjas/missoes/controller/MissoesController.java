package projetos.dev.java10x.CadastroDeNinjas.missoes.controller;

import org.springframework.web.bind.annotation.*;
import projetos.dev.java10x.CadastroDeNinjas.missoes.dto.MissoesDTO;
import projetos.dev.java10x.CadastroDeNinjas.missoes.service.MissoesService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @GetMapping("/listar")
    public List<MissoesDTO> listarMissoes() {
        return missoesService.listarMissoes();
    }

    @GetMapping("/listar/{id}")
    public Optional<MissoesDTO> listarMissoesId(@PathVariable Long id) {
        return missoesService.listarMissoesId(id);
    }

    @PostMapping("/criar")
    public MissoesDTO criarMissoes(@RequestBody MissoesDTO missao) {
        return missoesService.adicionarMissoes(missao);
    }

    @PatchMapping("/alterar/{id}")
    public MissoesDTO alterarMissao(@PathVariable Long id, @RequestBody MissoesDTO missao) {
        return missoesService.atualizarMissao(id, missao);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarMissao(@PathVariable Long id) {
        missoesService.deletarMissao(id);
    }


}
