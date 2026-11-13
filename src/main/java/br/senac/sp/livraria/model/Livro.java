package br.senac.sp.livraria.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

// Mapeando a classe Livro com a tabela tbl_livro no banco de dados
@Entity
@Table(name = "tb_livro")
public class Livro {

       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private Integer id;

       @NotBlank(message = "O título do livro é obrigatório!")
       private String titulo;

       @NotBlank(message = "O nome do autor é obrigatório!")
       @Size(min = 3, max = 20, message = "O campo autor deve ter no mínimo 3 caracteres e no máximo 20 caracteres.")
       private String autor;

       @ManyToOne
       @JoinColumn(name = "id_editora", nullable = false)
       private Editora editora;

       @Positive(message = "O preço do livro deve ser maior que zero!")
       private double preco;

       @Column(name = "ano_edicao")
       private int anoEdicao;

       @Column(name = "data_lancamento")
       @PastOrPresent(message = "A data de lançamento deve ser uma data no passado!")
       private LocalDate dataLancamento;

       public LocalDate getDataLancamento() {
              return dataLancamento;
       }

       public void setDataLancamento(LocalDate dataLancamento) {
              this.dataLancamento = dataLancamento;
       }

       public Integer getId() {
              return id;
       }

       public void setId(Integer id) {
              this.id = id;
       }

       public String getTitulo() {
              return titulo;
       }

       public void setTitulo(String titulo) {
              this.titulo = titulo;
       }

       public String getAutor() {
              return autor;
       }

       public void setAutor(String autor) {
              this.autor = autor;
       }

       public Editora getEditora() {
              return editora;
       }

       public void setEditora(Editora editora) {
              this.editora = editora;
       }

       public double getPreco() {
              return preco;
       }

       public void setPreco(double preco) {
              this.preco = preco;
       }

       public int getAnoEdicao() {
              return anoEdicao;
       }

       public void setAnoEdicao(int anoEdicao) {
              this.anoEdicao = anoEdicao;
       }
}