/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import entidades.Produto;
import java.util.ArrayList;
import java.util.List;

public class ProdutoController {
    private List<Produto> produtos;

    public ProdutoController() {
        produtos = new ArrayList<>();
    }

    
    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    
    public void atualizarProduto(Produto produto) {
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getCodigo() == produto.getCodigo()) {
                produtos.set(i, produto);
                break;
            }
        }
    }

    
    public void excluirProduto(int codigo) {
        produtos.removeIf(produto -> produto.getCodigo() == codigo);
    }

    
    public List<Produto> listarProdutos() {
        return produtos;
    }
}