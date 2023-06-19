package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import java.awt.Font;

public class Sobre extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sobre frame = new Sobre();
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
	public Sobre() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Sobre.class.getResource("/imgs/interrogação.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 570, 464);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(0, 352, 556, 75);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Sobre.class.getResource("/imgs/simbolo.png")));
		lblNewLabel_1.setBounds(477, 10, 48, 48);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Sobre.class.getResource("/imgs/certificado.png")));
		lblNewLabel.setBounds(31, 47, 48, 48);
		contentPane.add(lblNewLabel);
		
		JTextArea txtrProgramaDesenvolvidoComo = new JTextArea();
		txtrProgramaDesenvolvidoComo.setForeground(SystemColor.windowText);
		txtrProgramaDesenvolvidoComo.setBackground(SystemColor.control);
		txtrProgramaDesenvolvidoComo.setFont(new Font("Arial", Font.BOLD, 13));
		txtrProgramaDesenvolvidoComo.setEnabled(false);
		txtrProgramaDesenvolvidoComo.setText("Programa desenvolvido como forma de obtenção\r\nde nota na disciplina de Línguagem de Programação 1. \r\nComo delegado, foram utilizados os seguintes \r\nconceitos: Vetores, métodos, matrizes, Strings, \r\nentre outros.  Tudo respeitando um dos pilares \r\nda orientação a objetos, o encapsulamento.\r\n\r\nO Código estará disponivel no github e pode ser \r\nbaixado e modificado por qualquer pessoa da \r\nmaneira que desejar. ");
		txtrProgramaDesenvolvidoComo.setBounds(89, 47, 354, 186);
		contentPane.add(txtrProgramaDesenvolvidoComo);
		
		JTextArea txtrProgramaDeEstoque = new JTextArea();
		txtrProgramaDeEstoque.setText("Programa de estoque de Livros");
		txtrProgramaDeEstoque.setForeground(SystemColor.windowText);
		txtrProgramaDeEstoque.setFont(new Font("Arial", Font.BOLD, 13));
		txtrProgramaDeEstoque.setEnabled(false);
		txtrProgramaDeEstoque.setBackground(SystemColor.control);
		txtrProgramaDeEstoque.setBounds(89, 245, 354, 28);
		contentPane.add(txtrProgramaDeEstoque);
	}
}
