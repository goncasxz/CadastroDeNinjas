package projetos.dev.java10x.CadastroDeNinjas.missoes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import projetos.dev.java10x.CadastroDeNinjas.ninjas.model.NinjaModel;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MissoesDTO {

    private Long id;
    private String nome ;
    private String rank;
//    private List<NinjaModel> ninjas;

}
