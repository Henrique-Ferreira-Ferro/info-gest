package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Canvas;

public class CadastrarClientes extends JInternalFrame {
    private JTextField txtNome;
    private JTextField txtCidade;
    private JTextField txtTelefone;
    private JTextField txtCPF;
    private JButton btnCadastrar;
    private JButton btnExibirClientes;
    
    private ArrayList<String> nomes;
    private ArrayList<String> cidades;
    private ArrayList<Long> telefones;
    private ArrayList<Long> cpfs;

    public ArrayList<String> getNomes() {
        return nomes;
    }

    public ArrayList<String> getCidades() {
        return cidades;
    }

    public ArrayList<Long> getTelefones() {
        return telefones;
    }

    public ArrayList<Long> getCpfs() {
        return cpfs;
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CadastrarClientes frame = new CadastrarClientes();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public CadastrarClientes() {
        nomes = new ArrayList<String>();
        cidades = new ArrayList<String>();
        telefones = new ArrayList<Long>();
        cpfs = new ArrayList<Long>();
        
        setClosable(true);
        setBorder(null);
        setBounds(100, 100, 539, 481);
        getContentPane().setLayout(null);
        
        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(29, 94, 55, 16);
        getContentPane().add(lblNome);
        
        txtNome = new JTextField();
        txtNome.setBounds(94, 91, 200, 22);
        getContentPane().add(txtNome);
        txtNome.setColumns(10);
        
        JLabel lblCidade = new JLabel("Cidade:");
        lblCidade.setBounds(29, 134, 55, 16);
        getContentPane().add(lblCidade);
        
        txtCidade = new JTextField();
        txtCidade.setBounds(94, 131, 200, 22);
        getContentPane().add(txtCidade);
        txtCidade.setColumns(10);
        
        JLabel lblTelefone = new JLabel("Telefone:");
        lblTelefone.setBounds(29, 174, 65, 16);
        getContentPane().add(lblTelefone);
        
        txtTelefone = new JTextField();
        txtTelefone.setBounds(94, 171, 150, 22);
        getContentPane().add(txtTelefone);
        txtTelefone.setColumns(10);
        
        JLabel lblCpf = new JLabel("CPF:");
        lblCpf.setBounds(29, 214, 30, 16);
        getContentPane().add(lblCpf);
        
        txtCPF = new JTextField();
        txtCPF.setBounds(94, 211, 150, 22);
        getContentPane().add(txtCPF);
        txtCPF.setColumns(10);
        
        btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBounds(124, 254, 110, 25);
        btnCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cadastrarCliente();
                limparCampos();
            }
        });
        btnCadastrar.setForeground(Color.BLUE);
        btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
        getContentPane().add(btnCadastrar);
        
        btnExibirClientes = new JButton("Exibir Clientes");
        btnExibirClientes.setForeground(Color.BLUE);
        btnExibirClientes.setBounds(249, 254, 140, 25);
        btnExibirClientes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exibirClientesCadastrados();
            }
        });
        btnExibirClientes.setFont(new Font("Tahoma", Font.PLAIN, 14));
        getContentPane().add(btnExibirClientes);
        
        JPanel panel = new JPanel();
        panel.setBackground(SystemColor.textHighlight);
        panel.setForeground(SystemColor.textHighlight);
        panel.setBounds(0, 0, 552, 36);
        getContentPane().add(panel);
        
        JLabel lblNewLabel = new JLabel("Cadastro de Clientes");
        lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
        lblNewLabel.setBounds(94, 68, 180, 13);
        getContentPane().add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(CadastrarClientes.class.getResource("/imgs/customer.png")));
        lblNewLabel_1.setBounds(29, 48, 40, 36);
        getContentPane().add(lblNewLabel_1);
    }
    
    private void cadastrarCliente() {
        String nome = txtNome.getText();
        String cidade = txtCidade.getText();
        long telefone;
        long cpf;
        
        try {
            telefone = Long.parseLong(txtTelefone.getText());
            cpf = Long.parseLong(txtCPF.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Telefone e CPF devem ser números válidos!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (nome.isEmpty() || cidade.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (String.valueOf(telefone).length() != 9 || String.valueOf(cpf).length() != 11) {
            JOptionPane.showMessageDialog(null, "Digite a quantidade esperada de dígitos para o telefone (9) e CPF (11)!", "Informação", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        nomes.add(nome);
        cidades.add(cidade);
        telefones.add(telefone);
        cpfs.add(cpf);
        
        JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }
        
   
    private void exibirClientesCadastrados() {
        StringBuilder clientes = new StringBuilder();
        for (int i = 0; i < nomes.size(); i++) {
            clientes.append("Nome: ").append(nomes.get(i)).append("\n");
            clientes.append("Cidade: ").append(cidades.get(i)).append("\n");
            clientes.append("Telefone: ").append(telefones.get(i)).append("\n");
            clientes.append("CPF: ").append(cpfs.get(i)).append("\n");
            clientes.append("---------------------------\n");
        }
        
        if (clientes.length() > 0) {
            JOptionPane.showMessageDialog(null, clientes.toString(), "Clientes Cadastrados", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum cliente cadastrado.", "Clientes Cadastrados", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void limparCampos() {
        txtNome.setText("");
        txtCidade.setText("");
        txtTelefone.setText("");
        txtCPF.setText("");
        txtNome.requestFocus();
    }
}
