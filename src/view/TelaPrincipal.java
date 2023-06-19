package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JInternalFrame;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private JLabel txtData;
	private JLabel txtNome;
	private JInternalFrame jFrameInterno;
	private JInternalFrame jFrameInternoAtual;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal(getClass().getName());
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
	public TelaPrincipal(String usuario) {
		setTitle("Tela Principal");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaPrincipal.class.getResource("/imgs/simbolo.png")));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				
				setarData();
				setarNome(usuario);
				
			}
		});
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 859, 602);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuProd = new JMenu("Produtos");
		menuProd.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(menuProd);
		
		JMenuItem menuCadProd = new JMenuItem("Cadastro de Produtos");
		menuCadProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fecharJFrameInternoAtual();
				CadastroProdutos cd = new CadastroProdutos();
				jFrameInterno.getContentPane().add(cd);
				jFrameInternoAtual = cd;
				cd.setVisible(true);
				
			}
		});
		menuProd.add(menuCadProd);
		
		JMenuItem menuListProd = new JMenuItem("Listagem de Produtos");
		menuListProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fecharJFrameInternoAtual();
				ListagemProdutos lp = new ListagemProdutos();
				jFrameInterno.getContentPane().add(lp);
				jFrameInternoAtual = lp;
				lp.setVisible(true);
				
			}
		});
		menuProd.add(menuListProd);
		
		JMenuItem menuPesqProd = new JMenuItem("Pesquisa de Produtos");
		menuProd.add(menuPesqProd);
		
		JMenu menuRelat = new JMenu("Relatorios");
		menuBar.add(menuRelat);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Estoque Atual");
		menuRelat.add(mntmNewMenuItem_1);
		
		JMenu menuAjuda = new JMenu("Ajuda");
		menuBar.add(menuAjuda);
		
		JMenuItem menuSobre = new JMenuItem("Sobre");
		menuSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sobre s = new Sobre();
				
				s.setVisible(true);
				
				
			}
		});
		menuAjuda.add(menuSobre);
		
		JMenu menuOpcoes = new JMenu("Opções");
		menuBar.add(menuOpcoes);
		
		JMenuItem menuSair = new JMenuItem("Sair");
		menuSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int sair = JOptionPane.showConfirmDialog
				(null,"Tem certeza que deseja sair? ", "Atenção", JOptionPane.YES_NO_OPTION);
				
				if(sair == JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
				
			}
		});
		menuOpcoes.add(menuSair);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(549, 0, 306, 543);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imgs/simbolo.png")));
		lblNewLabel.setBounds(124, 108, 48, 48);
		panel.add(lblNewLabel);
		
		txtData = new JLabel("Data atual");
		txtData.setForeground(SystemColor.text);
		txtData.setFont(new Font("Arial", Font.PLAIN, 17));
		txtData.setBounds(10, 247, 286, 19);
		panel.add(txtData);
		
		txtNome = new JLabel("Nome Usuario");
		txtNome.setForeground(SystemColor.text);
		txtNome.setFont(new Font("Arial", Font.PLAIN, 15));
		txtNome.setBounds(92, 329, 112, 25);
		panel.add(txtNome);
		
		jFrameInterno = new JInternalFrame("");
		jFrameInterno.setVisible(true);
		jFrameInterno.setBorder(null);
		jFrameInterno.setForeground(SystemColor.controlShadow);
		jFrameInterno.setBounds(0, 0, 551, 543);
		contentPane.add(jFrameInterno);
	}
	
	private void setarData() {
		Date data = new Date();
		DateFormat formatado = DateFormat.getDateInstance(DateFormat.FULL);
		txtData.setText(formatado.format(data));
		
	}
	
	private void setarNome(String nomeUsuario) {
		txtNome.setText(nomeUsuario);
	}
	
	private void fecharJFrameInternoAtual() {
		if(jFrameInternoAtual != null) {
			jFrameInternoAtual.dispose();
			jFrameInternoAtual = null;
		}
	}
	
	
}
