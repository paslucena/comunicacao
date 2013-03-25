package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JSplitPane;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.UIManager;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.table.TableColumn;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;

public class TelaTeste {

	private JFrame frmDerptunes;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaTeste window = new TelaTeste();
					window.frmDerptunes.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaTeste() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDerptunes = new JFrame();
		frmDerptunes.setTitle("derpTunes");
		frmDerptunes.setBounds(100, 100, 450, 300);
		frmDerptunes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDerptunes.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 434, 262);
		frmDerptunes.getContentPane().add(tabbedPane);
		
		JPanel Musica = new JPanel();
		tabbedPane.addTab("M\u00FAsica", null, Musica, null);
		Musica.setLayout(null);
		
		JPanel Downloads = new JPanel();
		tabbedPane.addTab("Downloads", null, Downloads, null);
		Downloads.setLayout(null);
		
		JPanel Busca = new JPanel();
		tabbedPane.addTab("Busca", null, Busca, null);
		Busca.setLayout(null);
		
		JLabel lblProcurarMsica = new JLabel("Procurar m\u00FAsica");
		lblProcurarMsica.setBounds(10, 11, 113, 14);
		Busca.add(lblProcurarMsica);
		
		textField_2 = new JTextField();
		textField_2.setBounds(120, 8, 299, 20);
		Busca.add(textField_2);
		textField_2.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Resultados da busca", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 36, 409, 187);
		Busca.add(panel);
		
		JPanel Configuracoes = new JPanel();
		tabbedPane.addTab("Configura\u00E7\u00F5es", null, Configuracoes, null);
		Configuracoes.setLayout(null);
		
		JPanel Conexao = new JPanel();
		Conexao.setBorder(new TitledBorder(null, "Conex\u00E3o com o servidor", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		Conexao.setBounds(10, 11, 409, 81);
		Configuracoes.add(Conexao);
		Conexao.setLayout(null);
		
		JLabel lblIpDoServidor = new JLabel("IP do Servidor");
		lblIpDoServidor.setBounds(24, 23, 95, 14);
		Conexao.add(lblIpDoServidor);
		
		textField = new JTextField();
		textField.setBounds(115, 20, 170, 20);
		Conexao.add(textField);
		textField.setColumns(10);
		
		JLabel lblPorcentagemDePacotes = new JLabel("Porcentagem de pacotes perdidos");
		lblPorcentagemDePacotes.setBounds(24, 48, 217, 14);
		Conexao.add(lblPorcentagemDePacotes);
		
		textField_1 = new JTextField();
		textField_1.setBounds(234, 45, 64, 20);
		Conexao.add(textField_1);
		textField_1.setColumns(10);
	}
}
