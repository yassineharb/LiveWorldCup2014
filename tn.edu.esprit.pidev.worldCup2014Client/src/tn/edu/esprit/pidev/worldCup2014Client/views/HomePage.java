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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		setBounds(100, 100, 788, 476);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);
		
		JMenuItem mntmAddNewUser = new JMenuItem("Add New User");
		mntmAddNewUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddUserPage ajout;
				ajout= new AddUserPage();
				ajout.setVisible(true);
				
			}
		});
		mnMenu.add(mntmAddNewUser);
		
		JMenuItem mntmRemoveUser = new JMenuItem("Remove User");
		mntmRemoveUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteUserPage supp;
				supp=new  DeleteUserPage();
				supp.setVisible(true);
				
			}
		});
		mnMenu.add(mntmRemoveUser);
		
		JMenuItem mntmViewsAllUser = new JMenuItem("Views all User");
		
		mntmViewsAllUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GetAllUserPage liste;
				liste= new GetAllUserPage();
				liste.setVisible(true);
				
			}
		});
		
		mnMenu.add(mntmViewsAllUser);
		
		
	JMenuItem mntmViewsAllUser_1 = new JMenuItem("Views all User by type");
		
		mntmViewsAllUser_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GetUserByType listep;
				listep= new GetUserByType();
				listep.setVisible(true);
				
			}
		});
		
		mnMenu.add(mntmViewsAllUser_1);
		
		JMenuItem mntmUpdateUserProfile = new JMenuItem("Update User Profile");
		mntmUpdateUserProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateUserPage modifier;
				modifier= new UpdateUserPage();
				modifier.setVisible(true);
				
			}
		});
		
		
		mnMenu.add(mntmUpdateUserProfile);
		
		JMenu mnAbout = new JMenu("About");
		menuBar.add(mnAbout);
		
		JMenuItem mntmAboutLiveUp = new JMenuItem("About live Up World Cup");
		mnAbout.add(mntmAboutLiveUp);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("");
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
