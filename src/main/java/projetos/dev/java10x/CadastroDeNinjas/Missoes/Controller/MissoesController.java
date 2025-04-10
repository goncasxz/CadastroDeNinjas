package projetos.dev.java10x.CadastroDeNinjas.Missoes.Controller;

import org.springframework.web.bind.annotation.*;
import projetos.dev.java10x.CadastroDeNinjas.Missoes.Model.MissoesModel;
import projetos.dev.java10x.CadastroDeNinjas.Missoes.Service.MissoesService;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @GetMapping("/listar")
    public String listarMissoes() {
        return "missoes listadas com sucesso";
    }

    @PostMapping("/criar")
    public MissoesModel criarMissoes(@RequestBody MissoesModel missao) {
        return missoesService.adicionarMissoes(missao);
    }

    @PutMapping("/alterarID")
    public String alterarMissao() {
        return "missao alterada com sucesso";
    }

    @DeleteMapping("/deletarID")
    public String deletarMissao() {
        return "missao deletada com sucesso";
    }


}
