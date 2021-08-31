package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.SystemColor;

public class main {

	private JFrame frmNolimits;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main window = new main();
					window.frmNolimits.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNolimits = new JFrame();
		frmNolimits.setBackground(SystemColor.textInactiveText);
		frmNolimits.setTitle("NoLimits");
		frmNolimits.setAlwaysOnTop(true);
		frmNolimits.setBounds(100, 100, 581, 486);
		frmNolimits.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNolimits.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(48, 38, 46, 14);
		frmNolimits.getContentPane().add(lblNewLabel);
		
		
	}
}
