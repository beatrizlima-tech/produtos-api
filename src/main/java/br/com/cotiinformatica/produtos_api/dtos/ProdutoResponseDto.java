package br.com.cotiinformatica.produtos_api.dtos;

public record ProdutoResponseDto(
       Integer id,
       String nome,
       String descricao,
       Double preco,
       Integer quantidade,
       Double total
) {
}
