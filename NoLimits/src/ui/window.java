package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Label;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import data.Level;
import logic.GameEngine;
import logic.Load;

import javax.swing.JLabel;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class window extends JFrame {

	private JPanel contentPane;
	private int widht = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
	private int height = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window frame = new window();
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
	public window() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(window.class.getResource("/sources/icons/game.png")));
		setTitle("NoLimits");
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1366, 728);
		initialize();
	}

	/**
	 * Inicializa los paneles de la ventana
	 */
	private void initialize() {
		JPanel PStart = new JPanel();
		PStart.setBackground(SystemColor.controlShadow);
		PStart.setBounds(0, 0, widht, height);
		PStart.setLayout(null);
		PStart.setVisible(true);

		JPanel PLvls = new JPanel();
		PLvls.setBackground(Color.DARK_GRAY);
		PLvls.setBounds(0, 0, widht, height);
		PLvls.setLayout(null);
		PLvls.setVisible(false);

		JPanel PLvl = new JPanel();
		PLvl.setBackground(Color.DARK_GRAY);
		PLvl.setBounds(0, 0, widht, height);
		PLvl.setLayout(null);
		PLvl.setVisible(false);

		getContentPane().add(PStart);
		getContentPane().add(PLvls);
		getContentPane().add(PLvl);

		/**
		 * Botones para cambiar de pestañas
		 */
		// Inicio --> Aventura
		JButton btnGLvls = new JButton("Aventura");
		btnGLvls.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PStart.setVisible(false);
				PLvls.setVisible(true);
			}
		});
		btnGLvls.setBounds(272, 215, 89, 23);
		PStart.add(btnGLvls);

		// Aventura --> Inicio
		JLabel lblBackA = new JLabel();
		lblBackA.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PLvls.setVisible(false);
				PStart.setVisible(true);
			}
		});
		lblBackA.setIcon(new ImageIcon(window.class.getResource("/sources/icons/arrow.png")));
		lblBackA.setBounds(30, 35, 61, 64);
		PLvls.add(lblBackA);
		
		// Aventura -->Nivel
		
		// Nivel --> Aventura
		
		
		/**
		 * Inicializacion de las pestañas
		 */
		initializePStart(PStart);
		initializePLvls(PLvls, PLvl);
		//initializePLvl(PLvl);
	}

	private void initializePStart(JPanel PStart) {
		String lvl = GameEngine.loadLevelPlayer();
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(Load.loadImg("/backgrounds/levels/" + lvl + ".jpg"));
		lblFondo.setBounds(0, -20, widht, height);
		PStart.add(lblFondo);
	}

	private void initializePLvls(JPanel PLvls, JPanel PLvl) {
		
		ArrayList<Level> levels = Load.initLvls();
		
		Load.loadIconsLvls(PLvls, PLvl, levels);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(Load.loadImg("/backgrounds/w_levels.jpg"));
		lblFondo.setBounds(0, -20, widht, height);
		PLvls.add(lblFondo);

	}
		
	public static void initializePlvl(JPanel PLvls, JPanel PLvl, ImageIcon bg, int id) {
		PLvl.removeAll();
		PLvl.repaint();
		
		JLabel lblBackN = new JLabel();
		lblBackN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PLvl.setVisible(false);
				PLvls.setVisible(true);
			}
		});
		lblBackN.setIcon(new ImageIcon(window.class.getResource("/sources/icons/arrow.png")));
		lblBackN.setBounds(30, 35, 61, 64);
		PLvl.add(lblBackN);
		
		JLabel lblEnemie = new JLabel("");
		lblEnemie.setIcon(new ImageIcon(window.class.getResource("/sources/enemies/"+id+".gif")));
		lblEnemie.setBounds(800, 0, 800, 800);
		PLvl.add(lblEnemie);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(bg);
		lblFondo.setBounds(0, -20, 1366, 728);
		PLvl.add(lblFondo);
	}
	
}
