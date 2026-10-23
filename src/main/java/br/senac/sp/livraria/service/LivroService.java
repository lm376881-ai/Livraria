package br.senac.sp.livraria.service;

import br.senac.sp.livraria.model.Livro;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;


@Service

public class LivroService {

    private final List<Livro> livros = new ArrayList<>();
    private final AtomicInteger geradorDeId = new AtomicInteger(1);  // utilizado para gerar IDs


    // Método para cadastrar o produto //

    public Livro salvar(Livro livro) {
        Livro novoLivro = new Livro(
                geradorDeId.getAndIncrement(),
                livro.titulo(),
                livro.autor(),
                livro.editora(),
                livro.preco(),
                livro.anoEdicao()
        );
        livros.add(novoLivro);
        return novoLivro;


    }

    public List<Livro> listarLivros() {
        return livros;
    }

    public Optional<Livro> buscarPorId(int id) {
        Optional<Livro> livroEnontrado = livros
                .stream()
                .filter(livro -> livro.id() == id)
                .findFirst(); // ao encontrar o livro para o looping

        return livroEnontrado;

    }

}


