package projetos.dev.java10x.CadastroDeNinjas.ninjas.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import projetos.dev.java10x.CadastroDeNinjas.missoes.model.MissoesModel;
import projetos.dev.java10x.CadastroDeNinjas.missoes.repository.MissoesRepository;
import projetos.dev.java10x.CadastroDeNinjas.ninjas.dto.NinjaDTO;
import projetos.dev.java10x.CadastroDeNinjas.ninjas.service.NinjaService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/ninjas/ui")
public class NinjaControllerUi {

    private final NinjaService ninjaService;
    private final MissoesRepository missoesRepository;

    public NinjaControllerUi(NinjaService ninjaService, MissoesRepository missoesRepository) {
        this.ninjaService = ninjaService;
        this.missoesRepository = missoesRepository;
    }

    @GetMapping("/adicionar")
    public String formularioAdiconarNinja(Model model) {
        model.addAttribute("ninja", new NinjaDTO());
        return "adicionarNinja";
    }

    @PostMapping("/salvar")
    public String salvarNinja(@ModelAttribute NinjaDTO ninja, RedirectAttributes redirectAttributes) {
        if (ninja.getMissoes() == null) {
            redirectAttributes.addFlashAttribute("mensagem", "Missão não foi encontrada.");
            return "redirect:/ninjas/ui/adicionar";
        }
        ninjaService.criarNinja(ninja);
        redirectAttributes.addFlashAttribute("mensagem", "Ninja cadastrado com sucesso");
        return "redirect:/ninjas/ui/listar";
    }

    @GetMapping("/listar")
    public String listarNinjas(Model model) {
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        model.addAttribute("ninjas", ninjas);
        return "listarNinjas";
    }

    @GetMapping("/listar/{id}")
    public String mostrarNinjasPorId(@PathVariable Long id, Model model) {
        Optional<NinjaDTO> ninja = ninjaService.listarNinjasId(id);
        if (ninja.isPresent()) {
            model.addAttribute("ninja", ninja.get());
            return "detalhesNinja";
        } else {
            model.addAttribute("mensagem", "Ninja não encontrado");
            return "listarNinjas";
        }
    }

    @GetMapping("/deletar/{id}")
    public String deletarNinjaPorId(@PathVariable Long id) {
        ninjaService.deletarPorId(id);
        return "redirect:/ninjas/ui/listar";
    }
}
