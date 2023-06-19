package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPanel;

public class CadastroProdutos extends JInternalFrame {
	private JTextField txtNomeProd;
	private JTextField txtNomePreco;
	private JTextField txtProdutoQuantidade;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JButton btnSalvar;
	
	private ArrayList<String> nomes;
	private ArrayList<Double> precos;
	private ArrayList<Integer>quantidade;
	private JPanel panel;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroProdutos frame = new CadastroProdutos();
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
	public CadastroProdutos() {
		
		nomes = new ArrayList<String>();
		precos = new ArrayList<Double>();
		quantidade = new ArrayList<Integer>();
		
		
		
		setClosable(true);
		setRootPaneCheckingEnabled(false);
		setBorder(null);
		setBounds(100, 100, 510, 475);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome do Produto");
		lblNewLabel.setBounds(23, 123, 124, 13);
		getContentPane().add(lblNewLabel);
		
		txtNomeProd = new JTextField();
		txtNomeProd.setBounds(157, 123, 162, 19);
		getContentPane().add(txtNomeProd);
		txtNomeProd.setColumns(10);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setBounds(42, 190, 88, 13);
		getContentPane().add(lblQuantidade);
		
		JLabel lblPreo = new JLabel("Preço");
		lblPreo.setBounds(59, 155, 41, 13);
		getContentPane().add(lblPreo);
		
		txtNomePreco = new JTextField();
		txtNomePreco.setColumns(10);
		txtNomePreco.setBounds(157, 152, 162, 19);
		getContentPane().add(txtNomePreco);
		
		txtProdutoQuantidade = new JTextField();
		txtProdutoQuantidade.setColumns(10);
		txtProdutoQuantidade.setBounds(157, 187, 77, 19);
		getContentPane().add(txtProdutoQuantidade);
		
		btnSalvar = new JButton("Guardar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				guardarItens();
				limparCampos();
			}
		});
		btnSalvar.setForeground(SystemColor.textHighlight);
		btnSalvar.setBackground(SystemColor.text);
		btnSalvar.setFont(new Font("Arial", Font.BOLD, 10));
		btnSalvar.setBounds(157, 224, 113, 21);
		getContentPane().add(btnSalvar);
		
		lblNewLabel_1 = new JLabel("Cadastro");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1.setBounds(157, 58, 88, 21);
		getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(CadastroProdutos.class.getResource("/imgs/book.png")));
		lblNewLabel_2.setBounds(42, 45, 48, 48);
		getContentPane().add(lblNewLabel_2);
		
		panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(0, 0, 575, 35);
		getContentPane().add(panel);

	}
	
	public void guardarItens() {
		
		String nome = txtNomeProd.getText();
		String precoTxt = txtNomePreco.getText();
		String quantidadeTxt = txtProdutoQuantidade.getText();
		
		
		double preco = 0.0;
		
		Integer quantidades = 0;
		try {
			if(precoTxt.length() <= 6) {
				preco = Double.parseDouble(precoTxt);
				
				
			}else {
				JOptionPane.showMessageDialog(null, "Preço exorbitante detectado. Favor insira um valor menor!");
				return; // Volta o controle para o metodo que chamou esse e os valores não são armazenados
				
			}
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Você precisa digitar numeros !!!");
			return;
		}
		
		
		try {
			if(quantidadeTxt.length() <= 4) {
				quantidades = Integer.parseInt(quantidadeTxt);
			}else {
				JOptionPane.showMessageDialog(null, "Você está colocando uma quantidade muito grande! Contate o administrador para checar se está correto");
				return;
			}
			
			
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,"Você precisa digitar numeros inteiros");
			return;
		}
		
		nomes.add(nome);
		precos.add(preco);
		quantidade.add(quantidades);
		
		
		
		
		for(String nom: nomes) {
			System.out.println(nom);
		}
		
		
	}
	
	public void limparCampos() {
		txtNomeProd.setText("");
		txtNomePreco.setText("");
		txtProdutoQuantidade.setText("");
	}
	
	
	
	
	
	
}
