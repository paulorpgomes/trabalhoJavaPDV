/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import entidades.Venda;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paulo Ricardo
 */
public class VendaController {
    private List<Venda> vendas;

    public VendaController() {
        vendas = new ArrayList<>();
    }

    // Registrar uma nova venda
    public void registrarVenda(Venda venda) {
        vendas.add(venda);
    }

    // Listar todas as vendas
    public List<Venda> listarVendas() {
        return vendas;
    }
}