package tn.edu.esprit.pidev.worldCup2014Client.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class HomePage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage();
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
	public HomePage() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(HomePage.class.getResource("/tn/edu/esprit/pidev/worldCup2014Client/ressources/Icon.124609.png")));
		setTitle("Home Page  WorldCup2014");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 762, 476);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);
		
		JMenuItem mntmAddNewUser = new JMenuItem("Add New User");
		mnMenu.add(mntmAddNewUser);
		
		JMenuItem mntmRemoveUser = new JMenuItem("Remove User");
		mnMenu.add(mntmRemoveUser);
		
		JMenuItem mntmViewsAllUser = new JMenuItem("Views all User");
		mnMenu.add(mntmViewsAllUser);
		
		JMenuItem mntmViewsUserBytype = new JMenuItem("Views User ByType");
		mnMenu.add(mntmViewsUserBytype);
		
		JMenuItem mntmViewsUserBy = new JMenuItem("Views User by Id");
		mnMenu.add(mntmViewsUserBy);
		
		JMenuItem mntmUpdateUserProfile = new JMenuItem("Update User Profile");
		mnMenu.add(mntmUpdateUserProfile);
		
		JMenu mnAbout = new JMenu("About");
		menuBar.add(mnAbout);
		
		JMenuItem mntmAboutLiveUp = new JMenuItem("About live Up World Cup");
		mnAbout.add(mntmAboutLiveUp);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(HomePage.class.getResource("/tn/edu/esprit/pidev/worldCup2014Client/ressources/img51756b4d82141.jpg")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel)
					.addContainerGap(608, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel)
					.addContainerGap(354, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
