package br.com.cotiinformatica.produtos_api.controllers;

import br.com.cotiinformatica.produtos_api.dtos.ProdutoRequestDto;
import br.com.cotiinformatica.produtos_api.dtos.ProdutoResponseDto;
import br.com.cotiinformatica.produtos_api.entities.Produto;
import br.com.cotiinformatica.produtos_api.repositories.ProdutoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/produtos")
public class ProdutoController {

    @PostMapping("criar")
    public ResponseEntity<String> criar(@RequestBody ProdutoRequestDto dto) {
        try {

            //Capturar os dados do produto
            var produto = new Produto();

            produto.setNome(dto.nome());
            produto.setDescricao(dto.descricao());
            produto.setPreco(dto.preco());
            produto.setQuantidade(dto.quantidade());

            //Salvando o produto no banco de dados
            var repository = new ProdutoRepository();
            repository.inserir(produto);

            return ResponseEntity.status(201).body("Produto cadastrado com sucesso.");
        }
        catch(Exception e) {
            return ResponseEntity.status(500).body("Erro: " + e.getMessage());
        }
    }

    @PutMapping("alterar/{id}")
    public ResponseEntity<String> alterar(@PathVariable Integer id, @RequestBody ProdutoRequestDto dto) {
        try {

            //Caturar os dados do produto
            var produto = new Produto();
            produto.setId(id);
            produto.setNome(dto.nome());
            produto.setDescricao(dto.descricao());
            produto.setPreco(dto.preco());
            produto.setQuantidade(dto.quantidade());

            var repository = new ProdutoRepository();

            //Atualizar o produto no banco de dados e verificar a resposta
            if(repository.atualizar(produto)) {
                return ResponseEntity.status(200).body("Produto atualizado com sucesso.");
            }
            else {
                return ResponseEntity.status(404).body("Produto não encontrado para edição.");
            }
        }
        catch(Exception e) {
            return ResponseEntity.status(500).body("Erro: " + e.getMessage());
        }
    }

    @DeleteMapping("excluir/{id}")
    public ResponseEntity<String> excluir(@PathVariable Integer id) {
        try {
            var repository = new ProdutoRepository();

            //Excluir o produto no banco de dados e verificar a resposta
            if(repository.excluir(id)) {
                return ResponseEntity.status(200).body("Produto excluído com sucesso.");
            }
            else {
                return ResponseEntity.status(404).body("Produto não encontrado para exclusão.");
            }
        }
        catch(Exception e) {
            return ResponseEntity.status(500).body("Erro: " + e.getMessage());
        }
    }

    @GetMapping("listar")
    public ResponseEntity<?> listar(String nome) {
        try {
            //Instanciando o repositório
            var repository = new ProdutoRepository();
            //Executando e capturando a lista de produtos no banco
            var lista = repository.obterPorNome(nome);

            //Copiando os registros obtidos do banco para uma lista de ProdutoResponseDto
            var response = lista.stream()
                    .map(item -> new ProdutoResponseDto(
                            item.getId(),
                            item.getNome(),
                            item.getDescricao(),
                            item.getPreco(),
                            item.getQuantidade(),
                            item.getPreco() * item.getQuantidade()
                    )).toList();

            return ResponseEntity.status(200).body(response);
        }
        catch(Exception e) {
            return ResponseEntity.status(500).body("Erro: " + e.getMessage());
        }
    }

    @GetMapping("obter/{id}")
    public ResponseEntity<?> obter(@PathVariable Integer id) {
        try {
            //Instanciando o repositório
            var repository = new ProdutoRepository();
            //Executando e capturando um produto através do ID
            var produto = repository.obterPorId(id);

            if(produto == null) {
                return ResponseEntity.status(404).body("Produto não encontrado.");
            }

            var response = new ProdutoResponseDto(
                    produto.getId(),
                    produto.getNome(),
                    produto.getDescricao(),
                    produto.getPreco(),
                    produto.getQuantidade(),
                    produto.getPreco() * produto.getQuantidade()
            );
            return ResponseEntity.status(200).body(response);
        }
        catch(Exception e) {
            return ResponseEntity.status(500).body("Erro: " + e.getMessage());
        }
    }
}
