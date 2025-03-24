package projetos.dev.java10x.CadastroDeNinjas.Missoes.Service;

import jakarta.persistence.*;
import projetos.dev.java10x.CadastroDeNinjas.Ninjas.Service.NinjaModel;

@Entity
@Table(name = "tb_missoes")
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome ;
    private String rank;
    private NinjaModel ninja;

    public MissoesModel() {
    }

    public MissoesModel(Long id, String nome, String rank, NinjaModel ninja) {
        this.id = id;
        this.nome = nome;
        this.rank = rank;
        this.ninja = ninja;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public NinjaModel getNinja() {
        return ninja;
    }

    public void setNinja(NinjaModel ninja) {
        this.ninja = ninja;
    }
}
