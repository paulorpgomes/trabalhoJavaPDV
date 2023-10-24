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

    
    public void registrarVenda(Venda venda) {
        vendas.add(venda);
    }

    
    public List<Venda> listarVendas() {
        return vendas;
    }
}