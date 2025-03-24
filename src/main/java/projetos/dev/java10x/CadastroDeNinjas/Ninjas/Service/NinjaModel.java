package projetos.dev.java10x.CadastroDeNinjas.Ninjas.Service;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import projetos.dev.java10x.CadastroDeNinjas.Missoes.Service.MissoesModel;

import java.util.List;

@Entity
@Table(name = "tb_cadastro")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private int idade;

    // @ManyToOne - 1 Ninja tem 1 unica missao
    @ManyToOne
    @JoinColumn(name = "missoes_id") //foreign key
    private MissoesModel missoes;


}
