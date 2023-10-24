/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Paulo Ricardo
 */
public class Venda {
    private Date data;
    private String hora;
    private double valorTotal;
    private String formaDePagamento;
    private List<ItemVenda> itens;

    public Venda(String text, String text0, String formaPagamento) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Date getData() {
        return data;
    }

    public String getHora() {
        return hora;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public String getFormaDePagamento() {
        return formaDePagamento;
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void setFormaDePagamento(String formaDePagamento) {
        this.formaDePagamento = formaDePagamento;
    }

    public void setItens(List<ItemVenda> itens) {
        this.itens = itens;
    }

    public void adicionarItem(ItemVenda item) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}