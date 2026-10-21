package br.senac.sp.livraria.controller;

import br.senac.sp.livraria.model.Livro;
import org.springframework.web.bind.annotation.*;

// POST http://localhost:8080/v1/api/livros
// GET http://localhost:8080/v1/api/livros

@RestController
@RequestMapping("/v1/api/livros") // mapear o local onde a minha requisição se encontra!!!

public class LivroController {

    //POST

        @PostMapping  // para postar o livro
        public String salvar(@RequestBody Livro livro){

            System.out.println(livro.titulo());
            return "Você chamou o método para gravar o livro!";
        }

    // GET
        @GetMapping // para visualizar os dados postados
        public String listarLivros(){
            return "Você chamou um método para LISTAR um livro!";
        }

}
