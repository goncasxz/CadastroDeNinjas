package projetos.dev.java10x.CadastroDeNinjas.Ninjas.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/boasVindas")
    public String boasVindas() {
        return "Essa é minha primeira mensagem nessa rota";
    }

    // TODO: Adicionar Ninjas
    @PostMapping("/criar")
    public String criarNinja() {
        return "ninja Criado";
    }

    // TODO: Procurar Ninjas por ID
    @GetMapping("/todosID")
    public String mostrarNinjasPorId() {
        return "Mostrar todos os ninjas por ID";
    }

    // TODO: Mostrar todos os Ninjas
    @GetMapping("/all")
    public String mostrarNinjas() {
        return "Mostrar todos os ninjas";
    }

    // TODO: Alterar dados dos Ninjas
    @PutMapping("/alterarID")
    public String alterarNinjaPorId() {
        return "Alterar ninja por id";
    }

    // TODO: Deletar Ninjas
    @DeleteMapping("/deletarID")
    public String deletarNinjaPorId() {
        return "Deletar ninja por ID";
    }


}
