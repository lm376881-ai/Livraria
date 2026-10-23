package br.senac.sp.livraria.controller;

import br.senac.sp.livraria.model.Livro;
import org.springframework.web.bind.annotation.*;


// POST http://localhost:8080/v1/api/editoras
// GET http://localhost:8080/v1/api/editoras

@RestController
@RequestMapping("/v1/api/editoras")

public class EditoraController {

    @PostMapping
    public String salvar(@RequestBody Livro livro){
        System.out.println(livro.titulo());
        return "Você chamou o método para gravar uma editora!";
    }

    @GetMapping
    public String listarEditoras(){
        return "Listando Editoras";
    }
}
