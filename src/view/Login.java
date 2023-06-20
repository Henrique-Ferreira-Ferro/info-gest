package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import funcionarios.Administrador;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private Administrador[] usuarios = {
		new Administrador("Sandra", "12345678"),
		new Administrador("Admin", "471920311"),
		new Administrador("Ferro", "46182001")
	};

	private JPanel contentPane;
	private JTextField txtNome;
	private JPasswordField txtSenha;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/imgs/simbolo.png")));
		setTitle("Formulario de Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 390, 524);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("User Login");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setBounds(126, 10, 98, 29);
		contentPane.add(lblNewLabel);

		JLabel lblUsuario = new JLabel("");
		lblUsuario.setIcon(new ImageIcon(Login.class.getResource("/imgs/user_circ.png")));
		lblUsuario.setFont(new Font("Arial", Font.PLAIN, 15));
		lblUsuario.setBounds(53, 187, 48, 48);
		contentPane.add(lblUsuario);

		JLabel lblNewLabel_1_1 = new JLabel("Senha");
		lblNewLabel_1_1.setIcon(new ImageIcon(Login.class.getResource("/imgs/password.png")));
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(53, 245, 48, 48);
		contentPane.add(lblNewLabel_1_1);

		txtNome = new JTextField();
		txtNome.setToolTipText("Nome");
		txtNome.setBounds(111, 203, 168, 19);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(0, 423, 376, 74);
		contentPane.add(panel);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/imgs/user_white_128.png")));
		lblNewLabel_1.setBounds(112, 49, 128, 128);
		contentPane.add(lblNewLabel_1);

		txtSenha = new JPasswordField();
		txtSenha.setToolTipText("Senha");
		txtSenha.setBounds(114, 261, 165, 19);
		contentPane.add(txtSenha);

		JButton btnLogin = new JButton("Logar");
		btnLogin.setForeground(SystemColor.textHighlight);
		btnLogin.setBackground(SystemColor.textHighlight);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = txtNome.getText();
				String senha = String.valueOf(txtSenha.getPassword());

				boolean usuarioEncontrado = false;

				for (Administrador usuario : usuarios) {
					if (nome.equals(usuario.getNome()) && senha.equals(usuario.getSenha())) {
						usuarioEncontrado = true;
						break;
					}
				}

				if (usuarioEncontrado) {
					TelaPrincipal p = new TelaPrincipal(nome);
					dispose();
					p.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Senha ou usuário incorretos");
				}
			}
		});

		btnLogin.setFont(new Font("Arial", Font.BOLD, 15));
		btnLogin.setBounds(194, 307, 85, 21);
		contentPane.add(btnLogin);
	}
}
