package br.com.grupomult.produtos.controller;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.grupomult.produtos.model.Produto;
import br.com.grupomult.produtos.repository.ProdutoRepository;

@RestController
@RequestMapping({ "/produtos" })
public class ProdutoController {
    // @Autowired
    private ProdutoRepository repository;

    ProdutoController(ProdutoRepository contactRepository) {
        this.repository = contactRepository;
    }

    @PostMapping
    public Produto create(@RequestBody Produto produto) {
        return repository.save(produto);
    }

    @GetMapping
    public List<Produto> RetreaveAll() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return repository.findAll();
    }
    
    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Produto> RetreaveById(@PathVariable long id){
        return repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Produto> update(@PathVariable("id") long id,
                                          @RequestBody Produto produto){
      return repository.findById(id)
        .map(record -> {
            record.setCategoria(produto.getCategoria());
            record.setValor(produto.getValor());
            Produto updated = repository.save(record);
            return ResponseEntity.ok().body(updated);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        System.out.println("dentro delete");
      return repository.findById(id)
          .map(record -> {
              repository.deleteById(id);
              return ResponseEntity.ok().build();
          }).orElse(ResponseEntity.notFound().build());
    }
}