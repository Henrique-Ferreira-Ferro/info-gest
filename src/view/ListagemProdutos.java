package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListagemProdutos extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListagemProdutos frame = new ListagemProdutos();
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
	public ListagemProdutos() {
		setResizable(true);
		setClosable(true);
		setBounds(100, 100, 395, 475);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Listagem dos livros");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel.setBounds(105, 64, 139, 17);
		getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(0, 0, 480, 35);
		getContentPane().add(panel);
		
		JButton btnVerLivros = new JButton("Ver os livros");
		btnVerLivros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Ao clicar nesse botão será gerado JLabels que iram assumir o nome dos titulos dos livros
				
				
			}
		});
		btnVerLivros.setFont(new Font("Arial", Font.BOLD, 12));
		btnVerLivros.setBounds(115, 100, 110, 21);
		getContentPane().add(btnVerLivros);
		
		
		
		
	}
}
