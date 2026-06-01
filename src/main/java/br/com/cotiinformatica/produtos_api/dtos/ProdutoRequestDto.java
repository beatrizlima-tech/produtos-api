package br.com.cotiinformatica.produtos_api.dtos;

public record ProdutoRequestDto(
        String nome,
        String descricao,
        Double preco,
        Integer quantidade
) {
}
