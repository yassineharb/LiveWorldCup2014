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
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;

import tn.edu.esprit.pidev.worldCup2014.domain.UserWorldCup;
import tn.edu.esprit.pidev.worldCup2014.services.interfaces.UserCrudServicesRemote;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

public class GetUserByType extends JFrame {
	DefaultTableModel dft;
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GetUserByType frame = new GetUserByType();
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
	public GetUserByType() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 704, 459);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		table = new JTable();
		
		JButton btnFind = new JButton("Find");
		btnFind.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				empilTab();
				
				
			}
			
			 public void empilTab() {
					
					
				 
					Context context;
					try {
						context = new InitialContext();
						UserCrudServicesRemote proxy = 
								 (UserCrudServicesRemote) context.lookup("ejb:/tn.edu.esprit.pidev.worldCup2014/UserCrudServices!tn.edu.esprit.pidev.worldCup2014.services.interfaces.UserCrudServicesRemote");
						
						int t= Integer.parseInt(textField.getText());
						System.out.println("this t" +t);
					List<UserWorldCup> userWorldCupss =proxy.FindAllUserByType(t);
					 Object[][] donnees=new Object[userWorldCupss.size()][6];
					 int i=userWorldCupss.size();
					 System.out.println(i);
					 int j=0;
						 for (UserWorldCup e :userWorldCupss){
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
		
		JLabel lblChoisirType = new JLabel("Choisir Type");
		
		textField = new JTextField();
		textField.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(49)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 592, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(37, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(119)
					.addComponent(lblChoisirType)
					.addGap(66)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 144, Short.MAX_VALUE)
					.addComponent(btnFind)
					.addGap(151))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnFind)
						.addComponent(lblChoisirType)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(95, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
