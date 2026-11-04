package br.senac.sp.livraria.service;

import br.senac.sp.livraria.model.Livro;
import br.senac.sp.livraria.repository.LivroRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service

public class LivroService {

    private LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {

        this.livroRepository = livroRepository;
    }

    //Metodo para cadastrar livro
    public Livro salvar(Livro livro) {

        return livroRepository.save(livro);
    }

    public List<Livro> listarLivros() {

        return livroRepository.findAll();
    }

    public Optional<Livro> buscarPorId(int id) {

        return livroRepository.findById(id);
    }

    public boolean excluir(int id) {
        //Verificar se o livro existe no banco de dados
        Optional<Livro> livroExcluir = livroRepository.findById(id);

        //Se o livro exister ele será apagado, caso contrário, retornamos false
        if (livroExcluir.isPresent()) {
            livroRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Livro atualizar(Livro novoLivro){

        Optional<Livro> livroAtual = livroRepository.findById(novoLivro.getId());

        if (livroAtual.isPresent()) {
            return livroRepository.save(novoLivro);
        }

        return null;


    }

}