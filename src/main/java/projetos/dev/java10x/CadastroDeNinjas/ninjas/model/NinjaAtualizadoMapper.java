package projetos.dev.java10x.CadastroDeNinjas.ninjas.model;

import projetos.dev.java10x.CadastroDeNinjas.ninjas.dto.NinjaDTO;

public class NinjaAtualizadoMapper {
    public static NinjaDTO compararCampos(NinjaDTO antigo, NinjaDTO atual) {
        NinjaDTO diferencas = new NinjaDTO();

        if (atual.getNome() != null && !atual.getNome().equals(antigo.getNome())) {
            diferencas.setNome(atual.getNome());
        }

        if (atual.getEmail() != null && !atual.getEmail().equals(antigo.getEmail())) {
            diferencas.setEmail(atual.getEmail());
        }

        if (atual.getIdade() != null && !atual.getIdade().equals(antigo.getIdade())) {
            diferencas.setIdade(atual.getIdade());
        }

        if (atual.getImgUrl() != null && !atual.getImgUrl().equals(antigo.getImgUrl())) {
            diferencas.setImgUrl(atual.getImgUrl());
        }

        if (atual.getRank() != null && !atual.getRank().equals(antigo.getRank())) {
            diferencas.setRank(atual.getRank());
        }

        if (atual.getMissoes() != null && !atual.getMissoes().equals(antigo.getMissoes())) {
            diferencas.setMissoes(atual.getMissoes());
        }
        diferencas.setId(antigo.getId()); // manter o ID para referência
        return diferencas;
    }
}
