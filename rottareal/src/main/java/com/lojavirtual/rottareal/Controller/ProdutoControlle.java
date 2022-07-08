package com.lojavirtual.rottareal.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.data.util.Optionals;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lojavirtual.rottareal.model.Produto;
import com.lojavirtual.rottareal.repository.ProdutoRepository;

@RestController
@RequestMapping(path = "/produto")
public class ProdutoControlle {
    
    private ProdutoRepository produto;
    /*And Points Linhas A baixo */

@GetMapping(path="/")
    public List<Produto> listAllProdutos(){
        return produto.findAll();
    }

    
    
    @GetMapping(path="/{id}")
    public Optional<Produto> findProdutosById(@PathVariable int id){
        return produto.findById(id);
    }

    @PostMapping(path = "/")
    public Produto saveProduto (@RequestBody Produto prod) {
        return produto.save(prod);
    }

    @PutMapping(path = "/{id}")
    public void updateProduto(@PathVariable int id, @RequestBody Produto prod){
        var atual = produto.findById(id);
        if(atual.isPresent()){
            var atualProduto = atual.get();
            atualProduto.setDescricao(prod.getDescricao());
            atualProduto.setValor(prod.getValor());
            produto.save(atualProduto);
        }else{
            ResponseEntity.notFound().build();
        }


    }
    
    @DeleteMapping(path = "/{id}")
    public void deleteProduto(@PathVariable int id){
       var atual = produto.findById(id);
       if(atual.isPresent()){
        produto.deleteById(id);
       }else{ 
        ResponseEntity.notFound().build();
       }
    }
}

