package br.senac.sp.livraria.controller;

import br.senac.sp.livraria.model.Livro;
import br.senac.sp.livraria.service.LivroService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// POST http://localhost:8080/v1/api/livros
// GET http://localhost:8080/v1/api/livros

@RestController
@RequestMapping("/v1/api/livros") // mapear o local onde a minha requisição se encontra!!!
// responsável por receber as requisições
public class LivroController {

    // injeção de dependencia construtor a baixo, o spreengboot constroi
    private LivroService livroService;

    public LivroController(LivroService livroService){
        this.livroService = livroService;
    }
    //POST

    // app bruno\postman outro leitor api http hiper type protocolo que passa o livro para o java
        @PostMapping  // para postar o livro
        public ResponseEntity<Livro> salvar(@RequestBody Livro livro){
            Livro novoLivro = livroService.salvar(livro);
            return ResponseEntity.status(201).body(novoLivro);
        }

    // GET
        @GetMapping // para visualizar os dados postados
        public ResponseEntity<List<Livro>> listarLivros(){
            return ResponseEntity.ok(livroService.listarLivros());
        }


        // pode ter mais de um get porém precisa ser eliminada a ambiguidade como no exemplo abixo método é o mesmo porém com url diferente
        @GetMapping("/{id}") //id tem que ser o mesmo atributo no patch variable ("id") indicando qual o valor pegar na requisição;
        public String buscarPorId (@PathVariable ("id") int id){


            return "Você chamou o método buscar por ID: " + id;
        }

}
