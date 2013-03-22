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

public class TelaTeste {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaTeste window = new TelaTeste();
					window.frame.setVisible(true);
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
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblSadmpkoaskmdpsa = new JLabel("sadmpkoaskmdpsa");
		lblSadmpkoaskmdpsa.setBounds(0, 0, 434, 14);
		lblSadmpkoaskmdpsa.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblSadmpkoaskmdpsa);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 23, 414, 169);
		tabbedPane.setToolTipText("");
		tabbedPane.setBackground(UIManager.getColor("Button.background"));
		frame.getContentPane().add(tabbedPane);
		
		JLabel lblIpDoServidor = new JLabel("IP do Servidor");
		tabbedPane.addTab("New tab", null, lblIpDoServidor, null);
		tabbedPane.setBackgroundAt(0, UIManager.getColor("Button.darkShadow"));
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("aaaa", null, tabbedPane_1, null);
		
		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("New tab", null, tabbedPane_2, null);
	}
}
