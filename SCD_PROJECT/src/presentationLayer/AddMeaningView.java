package presentationLayer;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import businessLogicLayer.DictionaryLogic;
import transferObject.MashqoolTransferObjects;

public class AddMeaningView extends JFrame  {
	private DictionaryLogic l=new DictionaryLogic();
	private static ArrayList<MashqoolTransferObjects> update = new ArrayList<MashqoolTransferObjects>();
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_6;
	private static final long serialVersionUID = 1L;
	private JTextField textField_7;
	private JTextField textField_5;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddMeaningView frame = new AddMeaningView();
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
	public AddMeaningView() throws SQLException {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 660);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 106, 442, 507);
		panel.setBackground(Color.ORANGE);
		contentPane.add(panel);
		panel.setLayout(null);
		ArrayList<MashqoolTransferObjects> word = l.getWordList();
		
		JButton btnNewButton = new JButton("ترمیم کریں");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<word.size();i++)
				{
					if(word.get(i).getMashqool().compareTo(textField_10.getText())==0)
					{
					    String st=String.valueOf(word.get(i).getRaqm());
					    textField_7.setText(st);
					    textField.setText(word.get(i).getMashqool());
					    textField_5.setText(word.get(i).getJuzar());
					    textField_8.setText(word.get(i).getGermashqool());
						textField_1.setText(word.get(i).getSinf());
						textField_2.setText(word.get(i).getAsal());
						textField_3.setText(word.get(i).getJins());
						textField_4.setText(word.get(i).getAdad());
						textField_9.setText(word.get(i).getGerasal());
						textField_6.setText(word.get(i).getMeaning());	
					}
				}
			}
		});
		
		btnNewButton.setBounds(167, 242, 85, 21);
		panel.add(btnNewButton);
		
		
		
		
		JLabel lblNewLabel = new JLabel("ڈکشنری                                     ");
		lblNewLabel.setBounds(10, 10, 866, 59);
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setBackground(Color.ORANGE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
		contentPane.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.ORANGE);
		panel_1.setBounds(460, 106, 416, 507);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("رقم");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		lblNewLabel_1.setBounds(265, 65, 47, 30);
		panel_1.add(lblNewLabel_1);
		
		
		textField = new JTextField();
		textField.setBounds(101, 105, 96, 30);
		
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(101, 221, 96, 28);
		panel_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(101, 259, 96, 28);
		panel_1.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(101, 297, 96, 28);
		panel_1.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(101, 335, 96, 28);
		panel_1.add(textField_4);
		
		JLabel lblNewLabel_1_3 = new JLabel("صنف");
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		lblNewLabel_1_3.setBounds(244, 225, 59, 20);
		panel_1.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("اصل");
		lblNewLabel_1_4.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		lblNewLabel_1_4.setBounds(253, 265, 59, 20);
		panel_1.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("جنس");
		lblNewLabel_1_5.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		lblNewLabel_1_5.setBounds(253, 295, 59, 30);
		panel_1.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_5_1 = new JLabel("عدد");
		lblNewLabel_1_5_1.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		lblNewLabel_1_5_1.setBounds(265, 335, 59, 34);
		panel_1.add(lblNewLabel_1_5_1);
		
		JLabel lblNewLabel_1_5_2 = new JLabel("المعنى");
		lblNewLabel_1_5_2.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		lblNewLabel_1_5_2.setBounds(253, 408, 59, 30);
		panel_1.add(lblNewLabel_1_5_2);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(101, 410, 96, 28);
		panel_1.add(textField_6);
		
		JButton btnNewButton_1 = new JButton("محفوظ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MashqoolTransferObjects w=new MashqoolTransferObjects();
				w.setMashqool(textField.getText());
				w.setMeaning(textField_6.getText());
				update.add(w);
				DictionaryLogic l=new DictionaryLogic();
				try {
					l.updateMeaning(update);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
				textField_7.setText("");
				textField_8.setText("");
				textField_9.setText("");
			}
		});
		
		btnNewButton_1.setBounds(167, 465, 85, 21);
		panel_1.add(btnNewButton_1);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(101, 67, 96, 30);
		panel_1.add(textField_7);
		
		JLabel lblNewLabel_1_1 = new JLabel("مشكول");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		lblNewLabel_1_1.setBounds(244, 105, 80, 30);
		panel_1.add(lblNewLabel_1_1);
		JButton btnNewButton_1_1 = new JButton("محفوظ");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MashqoolTransferObjects w=new MashqoolTransferObjects();
				ArrayList<MashqoolTransferObjects> w1=new ArrayList<MashqoolTransferObjects>();
				w.setRaqm(Integer.parseInt(textField_7.getText()));
				w.setMashqool(textField.getText());
				w.setJuzar(textField_5.getText());
				w.setGermashqool(textField_8.getText());
				w.setSinf(textField_1.getText());
				w.setAsal(textField_2.getText());
				w.setJins(textField_3.getText());
				w.setAdad(textField_4.getText());
				w.setGerasal(textField_9.getText());
				w.setMeaning(textField_6.getText());
				w1.add(w);
				DictionaryLogic dictionaryLogicObj=new DictionaryLogic();
				try {
					dictionaryLogicObj.addWord(w1);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
				textField_7.setText("");
				textField_8.setText("");
				textField_9.setText("");
			}
		});
		
		btnNewButton_1_1.setBounds(143, 465, 85, 21);
		panel_1.add(btnNewButton_1_1);
		
		JLabel lblNewLabel_3 = new JLabel("جذر");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		lblNewLabel_3.setBounds(265, 145, 47, 30);
		panel_1.add(lblNewLabel_3);
		
		textField_5 = new JTextField();
		textField_5.setBounds(101, 145, 96, 31);
		panel_1.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("غیرمشكول");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		lblNewLabel_4.setBounds(215, 185, 119, 30);
		panel_1.add(lblNewLabel_4);
		
		textField_8 = new JTextField();
		textField_8.setBounds(101, 185, 96, 26);
		panel_1.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("غیرأصل");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		lblNewLabel_5.setBounds(230, 370, 82, 30);
		panel_1.add(lblNewLabel_5);
		
		textField_9 = new JTextField();
		textField_9.setBounds(101, 372, 96, 28);
		panel_1.add(textField_9);
		textField_9.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("لفظ درج کریں");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 70));
		lblNewLabel_2.setBounds(26, 162, 363, 174);
		panel.add(lblNewLabel_2);
		
		JButton btnNewButton_2 = new JButton("لفظ درج کریں");
		JButton btnNewButton_4 = new JButton("واپس ->");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton_1.setVisible(true);
				btnNewButton_1_1.setVisible(false);
				textField_10.setVisible(true);
				btnNewButton_4.setVisible(false);
				btnNewButton.setVisible(true);
				btnNewButton_2.setVisible(true);
				lblNewLabel_2.setVisible(false);
			}
		});
		btnNewButton_4.setBounds(10, 10, 85, 21);
		panel.add(btnNewButton_4);
		
		
		btnNewButton_1_1.setVisible(false);
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton_1.setVisible(false);
				btnNewButton.setVisible(false);
				btnNewButton_2.setVisible(false);
				btnNewButton_1_1.setVisible(true);
				textField_10.setVisible(false);
				btnNewButton_4.setVisible(true);
				lblNewLabel_2.setVisible(true);
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
				textField_7.setText("");
				textField_8.setText("");
				textField_9.setText("");
			}
		});
		btnNewButton_2.setBounds(167, 300, 100, 21);
		panel.add(btnNewButton_2);
		
		textField_10 = new JTextField();
		textField_10.setBounds(130, 151, 170, 38);
		panel.add(textField_10);
		textField_10.setColumns(10);
		
		
		
		lblNewLabel_2.setVisible(false);
		
		btnNewButton_4.setVisible(false);
		
	}
}