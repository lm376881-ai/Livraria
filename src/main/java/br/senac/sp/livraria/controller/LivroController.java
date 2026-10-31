package br.senac.sp.livraria.controller;

import br.senac.sp.livraria.model.Livro;
import br.senac.sp.livraria.service.LivroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

// POST http://localhost:8080/v1/api/livros
// GET  http://localhost:8080/v1/api/livros

@RestController
@RequestMapping("/v1/api/livros")

public class LivroController {

    //injeção de indenpendecia
    private LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @PostMapping
    public ResponseEntity<Livro> salvar(@RequestBody Livro livro) {
        Livro novoLivro = livroService.salvar(livro);
        return ResponseEntity.status(201).body(novoLivro);
    }

    @GetMapping
    public ResponseEntity<List<Livro>> listaLivros() {
        return ResponseEntity.ok(livroService.listarLivros());

    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscarPorId(@PathVariable("id") int id) {
        Optional<Livro> livroEncontrado = livroService.buscarPorId(id);
        if (livroEncontrado.isPresent()) {
            return ResponseEntity.ok(livroEncontrado.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluir(@PathVariable("id") int id) {
        if (livroService.excluir(id)) {
            return ResponseEntity.status(204).build();
        }

        Map<String, Object> erro = new HashMap<>();
        erro.put("status", 404);
        erro.put("mensagem", "O livro com ID" + id + "não foi encontrado!");
        erro.put("timestamp", LocalDateTime.now());

        return ResponseEntity.status(404).body(erro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> atualizar (@RequestBody Livro livroAtualizado){

        Livro novoLivro = livroService.atualizarLivro(livroAtualizado);
        if (novoLivro != null){
            return ResponseEntity.status(200).body(novoLivro);
        }
        return ResponseEntity.status(404).build();
    }
}


