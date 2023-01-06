package presentationLayer;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import businessLogicLayer.DictionaryLogic;
import transferObject.MashqoolTransferObjects;
import java.awt.SystemColor;

public class SearchRootView extends JFrame {

	private JPanel contentPane;
	private JTextField sf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchRootView frame = new SearchRootView();
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
	public SearchRootView() {
		setResizable(false);
		 DictionaryLogic obj=new DictionaryLogic();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 681, 547);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lb1 = new JLabel("");
		lb1.setForeground(new Color(255, 0, 0));
		lb1.setBounds(66, 162, 97, 14);
		contentPane.add(lb1);
		
		JLabel lb2 = new JLabel("");
		lb2.setForeground(new Color(255, 0, 0));
		lb2.setBounds(222, 162, 97, 14);
		contentPane.add(lb2);
		
		JLabel lb3 = new JLabel("");
		lb3.setForeground(new Color(255, 0, 0));
		lb3.setBounds(516, 162, 97, 14);
		contentPane.add(lb3);
		
		JLabel lb4 = new JLabel("");
		lb4.setForeground(new Color(255, 0, 0));
		lb4.setBounds(65, 278, 98, 14);
		contentPane.add(lb4);
		
		JLabel lb5 = new JLabel("");
		lb5.setForeground(new Color(255, 0, 0));
		lb5.setBounds(222, 278, 97, 14);
		contentPane.add(lb5);
		
		JLabel lb6 = new JLabel("");
		lb6.setForeground(new Color(255, 0, 0));
		lb6.setBounds(369, 278, 86, 14);
		contentPane.add(lb6);
		
		JLabel lb7 = new JLabel("");
		lb7.setForeground(new Color(255, 0, 0));
		lb7.setBounds(516, 278, 97, 14);
		contentPane.add(lb7);
		
		JLabel lb8 = new JLabel("");
		lb8.setForeground(new Color(255, 0, 0));
		lb8.setBounds(221, 394, 98, 14);
		contentPane.add(lb8);
		
		JLabel lblNewLabel_1 = new JLabel("رقم");
		lblNewLabel_1.setBounds(79, 123, 46, 14);
		lblNewLabel_1.setForeground(Color.WHITE);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("مشكول");
		lblNewLabel_1_1.setBounds(214, 123, 66, 14);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("جذر");
		lblNewLabel_1_2.setBounds(372, 123, 66, 14);
		lblNewLabel_1_2.setForeground(Color.WHITE);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("غیرمشكول");
		lblNewLabel_1_3.setBounds(525, 123, 66, 14);
		lblNewLabel_1_3.setForeground(Color.WHITE);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("صنف");
		lblNewLabel_1_4.setBounds(79, 244, 46, 14);
		lblNewLabel_1_4.setForeground(Color.WHITE);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("أصل");
		lblNewLabel_1_5.setBounds(234, 244, 46, 14);
		lblNewLabel_1_5.setForeground(Color.WHITE);
		contentPane.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("جنس");
		lblNewLabel_1_6.setBounds(380, 244, 46, 14);
		lblNewLabel_1_6.setForeground(Color.WHITE);
		contentPane.add(lblNewLabel_1_6);
		
		JLabel lblNewLabel_1_7 = new JLabel("عدد");
		lblNewLabel_1_7.setBounds(525, 244, 46, 14);
		lblNewLabel_1_7.setForeground(Color.WHITE);
		contentPane.add(lblNewLabel_1_7);
		
		JLabel lblNewLabel_1_8 = new JLabel("غیرأصل");
		lblNewLabel_1_8.setBounds(380, 353, 46, 14);
		lblNewLabel_1_8.setForeground(Color.WHITE);
		contentPane.add(lblNewLabel_1_8);
		
		JLabel lblNewLabel_1_9 = new JLabel("المعنى");
		lblNewLabel_1_9.setBounds(234, 353, 46, 14);
		lblNewLabel_1_9.setForeground(Color.WHITE);
		contentPane.add(lblNewLabel_1_9);
		
		JLabel lb9 = new JLabel("");
		lb9.setForeground(new Color(255, 0, 0));
		lb9.setBounds(370, 394, 97, 14);
		contentPane.add(lb9);
		
		JLabel lb10 = new JLabel("");
		lb10.setForeground(new Color(255, 0, 0));
		lb10.setBounds(362, 162, 115, 14);
		contentPane.add(lb10);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 27, 665, 33);
		panel.setBackground(Color.ORANGE);
		contentPane.add(panel);
		
		JLabel lb1_1 = new JLabel("Search by Root");
		panel.add(lb1_1);
		lb1_1.setForeground(Color.WHITE);
		lb1_1.setFont(new Font("Adobe Caslon Pro Bold", Font.BOLD | Font.ITALIC, 18));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(347, 71, 318, 33);
		panel_1.setBackground(SystemColor.inactiveCaption);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		sf = new JTextField();
		sf.setBackground(SystemColor.inactiveCaptionBorder);
		sf.setBounds(0, 0, 160, 33);
		panel_1.add(sf);
		sf.setColumns(10);
		
		JButton btnNewButton = new JButton("Find");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(170, -2, 96, 35);
		panel_1.add(btnNewButton);
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(50, 205, 50));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s=getText();
				ArrayList<MashqoolTransferObjects> list = obj.getDetailsByRoot(s);
				String []col  = new String [list.size()];
				lb1.setText(list.get(0).getRaqm()+"");
				lb2.setText(list.get(0).getMashqool()+"");
				lb3.setText(list.get(0).getGermashqool()+"");
				lb4.setText(list.get(0).getSinf()+"");
				lb5.setText(list.get(0).getAsal()+"");
				lb6.setText(list.get(0).getJins()+"");
				lb7.setText(list.get(0).getAdad()+"");
				lb8.setText(list.get(0).getMeaning()+"");
				lb9.setText(list.get(0).getGerasal()+"");
				lb10.setText(list.get(0).getJuzar()+"");
			}
		});
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 71, 333, 34);
		panel_2.setBackground(SystemColor.inactiveCaption);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Your Root");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(178, 11, 145, 14);
		panel_2.add(lblNewLabel);
		lblNewLabel.setBackground(Color.ORANGE);
		lblNewLabel.setForeground(Color.WHITE);

	}
	public String getText()
	{
		DictionaryLogic dictionaryLogicObj=new DictionaryLogic();
		String word=sf.getText();
		dictionaryLogicObj.getDetailsByWord(word);
		return word;
	}
}