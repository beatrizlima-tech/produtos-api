package br.com.cotiinformatica.produtos_api.controllers;

import br.com.cotiinformatica.produtos_api.dtos.ProdutoRequestDto;
import br.com.cotiinformatica.produtos_api.dtos.ProdutoResponseDto;
import br.com.cotiinformatica.produtos_api.entities.Produto;
import br.com.cotiinformatica.produtos_api.repositories.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/produtos")
public class ProdutoController {

    @PostMapping("criar")
    public String criar(@RequestBody ProdutoRequestDto dto){
        try{

            //Capturar os dados do produto
            var produto = new Produto();

            produto.setNome(dto.nome());
            produto.setDescricao(dto.descricao());
            produto.setPreco(dto.preco());
            produto.setQuantidade(dto.quantidade());

            // Salvando o produto no banco de dados
            var repository = new ProdutoRepository();
            repository.inserir(produto);

            return "Produto cadastrado com sucesso";
        }
        catch(Exception e){
            return "Erro: "+e.getMessage();
        }
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
    public List<ProdutoResponseDto> listar(String nome){

        try {
            //Instanciando o repositório
            var repository = new ProdutoRepository();
            //Executando e retornando a lista de produtos no banco
            var lista = repository.obterPorNome(nome);

            //Copiando os registros obtidos do banco para uma lista de ProdutoResponseDto
            return lista.stream()
                    .map(item -> new ProdutoResponseDto(
                            item.getId(),
                            item.getNome(),
                            item.getDescricao(),
                            item.getPreco(),
                            item.getQuantidade(),
                            item.getPreco()* item.getQuantidade()
                            )).toList();
        }
        catch (Exception e){
            e.printStackTrace(); //Imprimindo o log do erro no terminal do servidos
            return null;
        }
    }
}
