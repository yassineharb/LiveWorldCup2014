package tn.edu.esprit.pidev.worldCup2014Client.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import tn.edu.esprit.pidev.worldCup2014.domain.RequestJournaliste;
import tn.edu.esprit.pidev.worldCup2014.domain.UserWorldCup;
import tn.edu.esprit.pidev.worldCup2014.services.interfaces.RequestServiceRemote;
import tn.edu.esprit.pidev.worldCup2014.services.interfaces.UserCrudServicesRemote;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RequestPage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RequestPage frame = new RequestPage();
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
	public RequestPage() {
		setTitle("request freelancer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 475, 337);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblCin = new JLabel("Cin");
		
		JLabel lblMotivation = new JLabel("Motivation");
		
		JButton btnDemande = new JButton("Demande");
		btnDemande.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Context context = new InitialContext();
					RequestServiceRemote  proxy = 
						(RequestServiceRemote) context.lookup("ejb:/tn.edu.esprit.pidev.worldCup2014/RequestService!tn.edu.esprit.pidev.worldCup2014.services.interfaces.RequestServiceRemote");
					
				RequestJournaliste requestJournaliste =new RequestJournaliste();
				requestJournaliste.setMotivation(textField_1.getText());
				requestJournaliste.setUserWorldCup(finduser(Integer.parseInt(textField.getText())));
				proxy.addRequest(requestJournaliste);
				
					
					
					
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(26)
							.addComponent(lblMotivation)
							.addGap(78)
							.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(35)
							.addComponent(lblCin)
							.addGap(75)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
							.addComponent(btnDemande)))
					.addGap(72))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(48)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblCin)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnDemande)
							.addGap(18)))
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMotivation)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	public UserWorldCup finduser (int cin){
		Context context;
		UserWorldCup userWorldCupFound =new UserWorldCup();
		try {
			context = new InitialContext();
			UserCrudServicesRemote proxy = (UserCrudServicesRemote) context.lookup("ejb:/tn.edu.esprit.pidev.worldCup2014/UserCrudServices!tn.edu.esprit.pidev.worldCup2014.services.interfaces.UserCrudServicesRemote");
			
			userWorldCupFound=proxy.FindUserByCin(cin);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return userWorldCupFound;
	}
	
}
