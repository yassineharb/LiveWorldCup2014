package tn.edu.esprit.pidev.worldCup2014Client.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import java.awt.Toolkit;
import javax.swing.JButton;

import tn.edu.esprit.pidev.worldCup2014.domain.UserWorldCup;
import tn.edu.esprit.pidev.worldCup2014.services.interfaces.UserCrudServicesRemote;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

public class GetAllUserPage extends JFrame {

	DefaultTableModel dft;
	private JPanel contentPane;
	private JTable table;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GetAllUserPage frame = new GetAllUserPage();
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
	public GetAllUserPage() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(GetAllUserPage.class.getResource("/tn/edu/esprit/pidev/worldCup2014Client/ressources/Icon.124609.png")));
		setTitle("GetAll User Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 702, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		table =new JTable();
		
		JButton btnGetall = new JButton("Getall");
		btnGetall.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				
			
				empilTab();
				
				
			}
			
			 public void empilTab() {
					
					
				 
					Context context;
					try {
						context = new InitialContext();
						UserCrudServicesRemote proxy = 
								 (UserCrudServicesRemote) context.lookup("ejb:/tn.edu.esprit.pidev.worldCup2014/UserCrudServices!tn.edu.esprit.pidev.worldCup2014.services.interfaces.UserCrudServicesRemote");
						
						
					List<UserWorldCup> userWorldCups =proxy.FindAllUser();
					 Object[][] donnees=new Object[userWorldCups.size()][6];
					 int i=userWorldCups.size();
					 System.out.println(i);
					 int j=0;
						 for (UserWorldCup e :userWorldCups){
							 if (j<= i ){
								 System.out.println(j);
								 
						 donnees[j][0]=e.getCin();
						 donnees[j][1]=e.getName();
						 donnees[j][2]=e.getSname();
						 donnees[j][3]=e.getLogin();
						 donnees[j][4]=e.getEmail();
						 donnees[j][5]=e.getCountry();
						 j++;
							 }
						 }
						 String [] titres={"Cin","First Name","Last Name","login","email","country"};
						 dft=new DefaultTableModel(donnees, titres);
					        table.setModel(dft);
						 
					 }
					
						
					 catch (NamingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				 
				 
				 
				 
				 
				 
			       
			     
			    }
			
			
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(35, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(table, GroupLayout.PREFERRED_SIZE, 604, GroupLayout.PREFERRED_SIZE)
							.addGap(37))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(btnGetall)
							.addGap(19))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(25)
					.addComponent(btnGetall)
					.addGap(39)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(55, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
