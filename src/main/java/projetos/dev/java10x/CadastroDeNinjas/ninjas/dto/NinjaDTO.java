package projetos.dev.java10x.CadastroDeNinjas.ninjas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import projetos.dev.java10x.CadastroDeNinjas.missoes.model.MissoesModel;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaDTO   {

    private Long id;
    private String nome;
    private String email;
    private String imgUrl;
    private Integer idade;
    private MissoesModel missoes;
    private String rank;
}
