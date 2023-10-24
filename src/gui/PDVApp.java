package gui;

import entidades.ItemVenda;
import entidades.Produto;
import entidades.Venda;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PDVApp {
    private List<Produto> produtos = new ArrayList<>();
    private List<Venda> vendas = new ArrayList<>();

    private DefaultListModel<Produto> produtoListModel;
    private JList<Produto> produtoList;

    public PDVApp() {
        JFrame mainFrame = new JFrame("Ponto de Venda - PDV");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(600, 400);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JLabel titleLabel = new JLabel("Ponto de Venda");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);

        produtoListModel = new DefaultListModel<>();
        produtoList = new JList<>(produtoListModel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        JButton cadastrarProdutoButton = new JButton("Cadastro de Produtos");
        JButton registrarVendaButton = new JButton("Registrar Vendas");

        cadastrarProdutoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirJanelaCadastroProduto();
            }
        });

        registrarVendaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirJanelaRegistrarVenda();
            }
        });

        buttonPanel.add(cadastrarProdutoButton);
        buttonPanel.add(registrarVendaButton);

        mainPanel.add(titleLabel, BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(produtoList), BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        mainFrame.add(mainPanel);
        mainFrame.setVisible(true);
    }

    private void abrirJanelaCadastroProduto() {
        JFrame cadastroProdutoFrame = new JFrame("Cadastro de Produto");
        cadastroProdutoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel cadastroPanel = new JPanel(new GridLayout(7, 2));

        JLabel codigoLabel = new JLabel("Código:");
        JTextField codigoField = new JTextField(10);

        JLabel nomeLabel = new JLabel("Nome:");
        JTextField nomeField = new JTextField(20);

        JLabel unidadeLabel = new JLabel("Unidade:");
        JTextField unidadeField = new JTextField(10);

        JLabel precoLabel = new JLabel("Preço:");
        JTextField precoField = new JTextField(10);

        JLabel quantidadeLabel = new JLabel("Quantidade em Estoque:");
        JTextField quantidadeField = new JTextField(10);

        JButton salvarButton = new JButton("Salvar");

        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int codigo = Integer.parseInt(codigoField.getText());
                    String nome = nomeField.getText();
                    String unidade = unidadeField.getText();
                    double preco = Double.parseDouble(precoField.getText());
                    int quantidade = Integer.parseInt(quantidadeField.getText());

                    Produto novoProduto = new Produto(codigo, nome, unidade, preco, quantidade);
                    produtos.add(novoProduto);
                    atualizarListaDeProdutos();
                    cadastroProdutoFrame.dispose();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(cadastroProdutoFrame, "Dados de produto inválidos.");
                }
            }
        });

        cadastroPanel.add(codigoLabel);
        cadastroPanel.add(codigoField);
        cadastroPanel.add(nomeLabel);
        cadastroPanel.add(nomeField);
        cadastroPanel.add(unidadeLabel);
        cadastroPanel.add(unidadeField);
        cadastroPanel.add(precoLabel);
        cadastroPanel.add(precoField);
        cadastroPanel.add(quantidadeLabel);
        cadastroPanel.add(quantidadeField);
        cadastroPanel.add(new JLabel());
        cadastroPanel.add(salvarButton);

        cadastroProdutoFrame.add(cadastroPanel);
        cadastroProdutoFrame.pack();
        cadastroProdutoFrame.setVisible(true);
    }

    private void abrirJanelaRegistrarVenda() {
        JFrame registrarVendaFrame = new JFrame("Registrar Venda");
        registrarVendaFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel vendaPanel = new JPanel(new GridLayout(6, 2));

        JLabel dataLabel = new JLabel("Data:");
        JTextField dataField = new JTextField(10);
        dataField.setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));

        JLabel horaLabel = new JLabel("Hora:");
        JTextField horaField = new JTextField(10);
        horaField.setText(new SimpleDateFormat("HH:mm:ss").format(new Date()));

        JLabel codigoProdutoLabel = new JLabel("Código do Produto:");
        JTextField codigoProdutoField = new JTextField(10);

        JLabel quantidadeVendidaLabel = new JLabel("Quantidade Vendida:");
        JTextField quantidadeVendidaField = new JTextField(10);

        JLabel formaPagamentoLabel = new JLabel("Forma de Pagamento:");
        JComboBox<String> formaPagamentoComboBox = new JComboBox<>(new String[]{"Dinheiro", "Cartão de Crédito"});

        JButton adicionarItemButton = new JButton("Adicionar Item");

        adicionarItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int codigoProduto = Integer.parseInt(codigoProdutoField.getText());
                    int quantidadeVendida = Integer.parseInt(quantidadeVendidaField.getText());
                    String formaPagamento = formaPagamentoComboBox.getSelectedItem().toString();

                    Produto produto = buscarProdutoPorCodigo(codigoProduto);
                    if (produto != null) {
                        ItemVenda item = new ItemVenda(produto, quantidadeVendida);
                        Venda venda = new Venda(dataField.getText(), horaField.getText(), formaPagamento);
                        venda.adicionarItem(item);
                        vendas.add(venda);
                        atualizarListaDeProdutos();
                    } else {
                        JOptionPane.showMessageDialog(registrarVendaFrame, "Produto não encontrado.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(registrarVendaFrame, "Dados de venda inválidos.");
                }
            }
        });

        vendaPanel.add(dataLabel);
        vendaPanel.add(dataField);
        vendaPanel.add(horaLabel);
        vendaPanel.add(horaField);
        vendaPanel.add(codigoProdutoLabel);
        vendaPanel.add(codigoProdutoField);
        vendaPanel.add(quantidadeVendidaLabel);
        vendaPanel.add(quantidadeVendidaField);
        vendaPanel.add(formaPagamentoLabel);
        vendaPanel.add(formaPagamentoComboBox);
        vendaPanel.add(new JLabel());
        vendaPanel.add(adicionarItemButton);

        registrarVendaFrame.add(vendaPanel);
        registrarVendaFrame.pack();
        registrarVendaFrame.setVisible(true);
    }

    private Produto buscarProdutoPorCodigo(int codigo) {
        for (Produto produto : produtos) {
            if (produto.getCodigo() == codigo) {
                return produto;
            }
        }
        return null;
    }

    private void atualizarListaDeProdutos() {
        produtoListModel.clear();
        for (Produto produto : produtos) {
            produtoListModel.addElement(produto);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new PDVApp();
        });
    }
}