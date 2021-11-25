package com.produtos.apirest.controller;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Produtos")
@CrossOrigin(origins = "*")
public class ProdutoController {

    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping("/produtos")
    @ApiOperation(value = "Retorna uma lista de produtos")
    public List<Produto> listaProdutos() {

        return produtoRepository.findAll();
    }
    @GetMapping("/produto/{id}")
    @ApiOperation(value = "Retorna um produto pelo id")
    public Produto listaProdutoUnico(@PathVariable(value = "id") long id) {

        return produtoRepository.findById(id);
    }

    @PostMapping("/produto")
    @ApiOperation(value = "Salva um produto")
    public Produto salvaProduto(@RequestBody Produto produto) {

        return produtoRepository.save(produto);
    }

    @DeleteMapping("/produto/{id}")
    @ApiOperation(value = "Deleta um produto")
    public void deletaProduto(@PathVariable(value = "id") long id) {

        produtoRepository.deleteById(id);
    }

    @PutMapping("/produto")
    @ApiOperation(value = "Atualiza um produto")
    public Produto atualizaProduto(@RequestBody Produto produto) {

        return produtoRepository.save(produto);
    }

}
