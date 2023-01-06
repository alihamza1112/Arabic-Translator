package presentationLayer;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import businessLogicLayer.DictionaryLogic;
import transferObject.MashqoolTransferObjects;
import transferObject.JazzarTransferObjects;
import javax.swing.JTextField;

public class RootView extends JFrame {

	private JPanel contentPane;
	private DictionaryLogic l=new DictionaryLogic();
	private static ArrayList<MashqoolTransferObjects> update = new ArrayList<MashqoolTransferObjects>();
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RootView frame = new RootView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public RootView() throws SQLException {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(10, 10, 496, 300);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("مشكول");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel_1.setForeground(Color.ORANGE);
		lblNewLabel_1.setBounds(281, 95, 65, 30);
		panel.add(lblNewLabel_1);
		
		ArrayList<MashqoolTransferObjects> word = l.getWordList();
		ArrayList<JazzarTransferObjects> rs = l.getRootList();
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		panel_1.setForeground(Color.LIGHT_GRAY);
		panel_1.setBounds(180, 32, 123, 38);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("جذر");
		lblNewLabel.setBounds(40, 0, 46, 42);
		panel_1.add(lblNewLabel);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 35));
		
		JLabel lblNewLabel_2 = new JLabel("جذر");
		lblNewLabel_2.setForeground(Color.ORANGE);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		lblNewLabel_2.setBounds(291, 161, 45, 21);
		panel.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(163, 95, 96, 29);
		panel.add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(151, 168, 85, 21);
		panel.add(comboBox_1);
		lblNewLabel_2.setVisible(false);
		comboBox_1.setVisible(false);
		JButton btnNewButton_1 = new JButton("جزر تلاش کرے");
		JButton btnNewButton = new JButton("محفوظ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MashqoolTransferObjects transferObj=new MashqoolTransferObjects();
				transferObj.setMashqool(textField.getText());
				transferObj.setJuzar(comboBox_1.getSelectedItem()+"");
				update.add(transferObj);
				DictionaryLogic dictionaryLogicObj=new DictionaryLogic();
				try {
					dictionaryLogicObj.updateRoot(update);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				lblNewLabel_2.setVisible(false);
				comboBox_1.setVisible(false);
				btnNewButton.setVisible(false);
				btnNewButton_1.setVisible(true);
			}
		});
		btnNewButton.setVisible(false);
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setForeground(Color.DARK_GRAY);
		btnNewButton.setBounds(211, 217, 85, 30);
		panel.add(btnNewButton);
		
		
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] str= new String[3];
				int k=0;
				for(int i=0;i<word.size();i++)
				{
					if(textField.getText().compareTo(word.get(i).getMashqool())==0)
					{
						for(int j=0;j<rs.size();j++)
						{
							if(word.get(i).getRaqm()==rs.get(j).getRaqam())
							{
								str[k]=rs.get(j).getJuzzar();
								k++;
							}
						}
				        comboBox_1.setModel( new DefaultComboBoxModel( (String[])str ) );
				        lblNewLabel_2.setVisible(true);
						comboBox_1.setVisible(true);
						btnNewButton_1.setVisible(false);
						btnNewButton.setVisible(true);
					}
				}
			}
		});
		
		btnNewButton_1.setBounds(183, 135, 120, 21);
		panel.add(btnNewButton_1);
		
		
			
	}
}