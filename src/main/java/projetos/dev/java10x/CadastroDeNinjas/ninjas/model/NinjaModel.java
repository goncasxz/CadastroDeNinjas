package projetos.dev.java10x.CadastroDeNinjas.ninjas.model;

import jakarta.persistence.*;
import lombok.*;
import projetos.dev.java10x.CadastroDeNinjas.missoes.model.MissoesModel;

@Entity
@Table(name = "tb_cadastro")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "missoes")
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(unique = true)
    private String email;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "idade")
    private Integer idade;

    @Column(name = "rank")
    private String rank;

    // @ManyToOne - 1 Ninja tem 1 unica missao
    @ManyToOne
    @JoinColumn(name = "missoes_id") //foreign key
    private MissoesModel missoes;
}
