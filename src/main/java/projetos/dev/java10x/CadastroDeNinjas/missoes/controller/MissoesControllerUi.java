package projetos.dev.java10x.CadastroDeNinjas.missoes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import projetos.dev.java10x.CadastroDeNinjas.missoes.dto.MissoesDTO;
import projetos.dev.java10x.CadastroDeNinjas.missoes.repository.MissoesRepository;
import projetos.dev.java10x.CadastroDeNinjas.missoes.service.MissoesService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/missoes/ui")
public class MissoesControllerUi {

    private final MissoesService missoesService;
    private final MissoesRepository missoesRepository;

    public MissoesControllerUi(MissoesService missoesService, MissoesRepository missoesRepository) {
        this.missoesService = missoesService;
        this.missoesRepository = missoesRepository;
    }

    @GetMapping("/adicionar")
    public String formularioAdicionarMissao(Model model) {
        model.addAttribute("missao", new MissoesDTO());
        return "adicionarMissao";
    }

    @PostMapping("/salvar")
    public String salvarMissao(@ModelAttribute MissoesDTO missao, RedirectAttributes redirectAttributes) {
        missoesService.adicionarMissoes(missao);
        redirectAttributes.addFlashAttribute("mensagem", "Missao cadastrada com sucesso");
        return "redirect:/missoes/ui/listar";
    }

    @GetMapping("/listar")
    public String listarMissoes(Model model) {
        List<MissoesDTO> missoes = missoesService.listarMissoes();
        model.addAttribute("missoes", missoes);
        return "listarMissoes";
    }

    @GetMapping("/atualizacao/{id}")
    public String formularioAtualizarMissao(Model model, @PathVariable Long id) {
        Optional<MissoesDTO> missoesDTOOptional = missoesService.listarMissoesId(id);
        if (missoesDTOOptional.isPresent()) {
            model.addAttribute("missao", missoesDTOOptional.get());
            return "atualizarMissao";
        } else {
            return "redirect:missoes/ui/listar";
        }
    }

    @PatchMapping("/atualizar/{id}")
    public String salvarMissaoAtualizada(@PathVariable Long id, @ModelAttribute MissoesDTO missao, RedirectAttributes redirectAttributes) {
        missoesService.atualizarMissao(id, missao);
        redirectAttributes.addFlashAttribute("mensagem", "Missao atualizada com sucesso");
        return "redirect:/missoes/ui/listar";
    }

    @GetMapping("/deletar/{id}")
    public String deletarMissaoPorId(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        try {
            missoesService.deletarMissao(id);
            redirectAttributes.addFlashAttribute("mensagem", "Missão excluída com sucesso!");
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("mensagem", e.getMessage());
        }

        return "redirect:/missoes/ui/listar";
    }
}
