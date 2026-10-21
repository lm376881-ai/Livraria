package br.senac.sp.livraria.model;


//no classe records vão dentro do construtor da classe()
public record Livro(
        int id,
        String titulo,
        String autor,
        String editora,
        double preco,
        int anoEdicao
) {
    public void setId (int id){
        this.id = id;
    }




}
