/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author Paulo Ricardo
 */
public class ItemVenda {
    private int numeroItem;
    private int codigoProduto;
    private int quantidadeVendida;
    private double precoUnitario;
    private double totalItem;

    public ItemVenda(Produto produto, int quantidadeVendida) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getNumeroItem() {
        return numeroItem;
    }

    public int getCodigoProduto() {
        return codigoProduto;
    }

    public int getQuantidadeVendida() {
        return quantidadeVendida;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public double getTotalItem() {
        return totalItem;
    }

    public void setNumeroItem(int numeroItem) {
        this.numeroItem = numeroItem;
    }

    public void setCodigoProduto(int codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public void setQuantidadeVendida(int quantidadeVendida) {
        this.quantidadeVendida = quantidadeVendida;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public void setTotalItem(double totalItem) {
        this.totalItem = totalItem;
    }
    
    
    
    
}