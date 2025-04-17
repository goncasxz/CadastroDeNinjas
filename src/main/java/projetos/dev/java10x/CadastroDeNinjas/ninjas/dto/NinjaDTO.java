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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("NinjaDTO{");

        if (id != null) sb.append("id=").append(id).append(", ");
        if (nome != null) sb.append("nome='").append(nome).append("', ");
        if (email != null) sb.append("email='").append(email).append("', ");
        if (idade != null) sb.append("idade=").append(idade).append(", ");
        if (imgUrl != null) sb.append("imgUrl='").append(imgUrl).append("', ");
        if (rank != null) sb.append("rank='").append(rank).append("', ");
        if (missoes != null) sb.append("missoes=").append(missoes).append(", ");

        if (sb.lastIndexOf(", ") == sb.length() - 2) {
            sb.delete(sb.length() - 2, sb.length());
        }

        sb.append("}");
        return sb.toString();
    }
}
