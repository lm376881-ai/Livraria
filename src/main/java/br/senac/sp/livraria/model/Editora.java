package br.senac.sp.livraria.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

@Entity
@Table(name = "tb_editora")
public class Editora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private String nome;

    @Column(name = "url_site")
    private String urlSite;

    @Email(message = "O e-mail informado está incorreto!")
    private String email;





    public String nome() {
        return nome;
    }

    public Editora setNome(String nome) {
        this.nome = nome;
        return this;
    }



    public String email() {
        return email;
    }

    public Editora setEmail(String email) {
        this.email = email;
        return this;
    }

    public String urlSite() {
        return urlSite;
    }

    public Editora setUrlSite(String urlSite) {
        this.urlSite = urlSite;
        return this;
    }



    public Integer id() {
        return id;
    }

    public Editora setId(Integer id) {
        this.id = id;
        return this;
    }
}
