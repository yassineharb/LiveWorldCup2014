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
import javax.swing.JButton;
import javax.swing.JTable;

import tn.edu.esprit.pidev.worldCup2014.domain.RequestJournaliste;
import tn.edu.esprit.pidev.worldCup2014.domain.UserWorldCup;
import tn.edu.esprit.pidev.worldCup2014.services.interfaces.RequestServiceRemote;
import tn.edu.esprit.pidev.worldCup2014.services.interfaces.UserCrudServicesRemote;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;

public class AgrreRequestPage extends JFrame {

	
	DefaultTableModel dft;
	private JPanel contentPane;
	private JTable table;
	private JButton btnAccepteRequest;
	private JButton btnAcceptRequest;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgrreRequestPage frame = new AgrreRequestPage();
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
	public AgrreRequestPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 666, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("GetAllRequest");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				empilTab();
			}
			 public void empilTab() {
					
					
				 
					Context context;
					try {
						context = new InitialContext();
						RequestServiceRemote proxy = 
								 (RequestServiceRemote) context.lookup("ejb:/tn.edu.esprit.pidev.worldCup2014/RequestService!tn.edu.esprit.pidev.worldCup2014.services.interfaces.RequestServiceRemote");
						
						
					List<RequestJournaliste> requestJournalistes=proxy.findAllRequest();
					 Object[][] donnees=new Object[requestJournalistes.size()][6];
					 int i=requestJournalistes.size();
					 System.out.println(i);
					 int j=0;
						 for (RequestJournaliste e : requestJournalistes){
							 if (j<= i ){
								 System.out.println(j);
								 
						 donnees[j][0]=e.getUserWorldCup().getCin();
						 donnees[j][1]=e.getUserWorldCup().getName();
						 donnees[j][2]=e.getUserWorldCup().getSname();
						 donnees[j][3]=e.getUserWorldCup().getLogin();
						 donnees[j][4]=e.getUserWorldCup().getEmail();
						 donnees[j][5]=e.getMotivation();
						 j++;
							 }
						 }
						 String [] titres={"Cin","First Name","Last Name","login","email","motivation"};
						 dft=new DefaultTableModel(donnees, titres);
					        table.setModel(dft);
						 
					 }
					
						
					 catch (NamingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				 
				 
				 
				 
				 
				 
			       
			     
			    }
			

			
		});
		
		
		
		table = new JTable();
		
		btnAccepteRequest = new JButton("Select  request");
		btnAccepteRequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int n =table.getSelectedRow();
				
				
				int cin = (Integer) table.getValueAt(n, 0);
				String nom =(String) table.getValueAt(n, 1);
				textField.setText(nom);
				textField_1.setText(cin+"");
				
			
				
			}
		});
		
		btnAcceptRequest = new JButton("Accept request");
		btnAcceptRequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Context context = new InitialContext();
					 UserCrudServicesRemote proxy = 
							 (UserCrudServicesRemote) context.lookup("ejb:/tn.edu.esprit.pidev.worldCup2014/UserCrudServices!tn.edu.esprit.pidev.worldCup2014.services.interfaces.UserCrudServicesRemote");
					
					
					 UserWorldCup userWorldCupFound=proxy.FindUserByCin(Integer.parseInt(textField_1.getText())) ;
					userWorldCupFound.setTypeUser(2);
					
					proxy.updateUser(userWorldCupFound);
					
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
				
				
			}
		});
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(30)
					.addComponent(btnAccepteRequest)
					.addPreferredGap(ComponentPlacement.RELATED, 374, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(24))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(96)
					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 148, Short.MAX_VALUE)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(78)
					.addComponent(btnAcceptRequest)
					.addGap(57))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(41)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 528, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(71, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnAccepteRequest))
					.addGap(35)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAcceptRequest)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(59))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
