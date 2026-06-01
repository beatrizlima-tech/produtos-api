package br.com.cotiinformatica.produtos_api.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/produtos")
public class ProdutoController {

    @PostMapping("criar")
    public String criar(){
        return "Produto criado com sucesso"; //TODO
    }

    @PutMapping("alterar")
    public String alterar(){
        return "Produto alterado com sucesso"; //TODO
    }

    @DeleteMapping("excluir")
    public String excluir(){
        return "Produto excluado com sucesso"; //TODO
    }

    @GetMapping("listar")
    public String listar(){
        return "Listagem de produtos obtida com sucesso"; //TODO
    }
}
