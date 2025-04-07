package projetos.dev.java10x.CadastroDeNinjas.Missoes.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    @GetMapping("/listar")
    public String listarMissoes() {
        return "missoes listadas com sucesso";
    }

    @PostMapping("/criar")
    public String criarMissao() {
        return "missao criada com sucesso";
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
