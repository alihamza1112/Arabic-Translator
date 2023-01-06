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

public class SearchDataView extends JFrame {

	private JPanel contentPane;
	private JTextField sf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchDataView frame = new SearchDataView();
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
	public SearchDataView() {
		setResizable(false);
		 DictionaryLogic obj=new DictionaryLogic();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 681, 547);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("اپنا لفظ درج کریں");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(524, 66, 89, 14);
		contentPane.add(lblNewLabel);
		
		sf = new JTextField();
		sf.setBounds(359, 63, 141, 20);
		contentPane.add(sf);
		sf.setColumns(10);
		
		JButton btnNewButton = new JButton("تلاش کریں");
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.setBounds(248, 62, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lb1 = new JLabel("");
		lb1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lb1.setForeground(Color.WHITE);
		lb1.setBounds(66, 162, 105, 36);
		contentPane.add(lb1);
		
		JLabel lb2 = new JLabel("");
		lb2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lb2.setForeground(Color.WHITE);
		lb2.setBounds(222, 162, 97, 36);
		contentPane.add(lb2);
		
		JLabel lb3 = new JLabel("");
		lb3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lb3.setForeground(Color.WHITE);
		lb3.setBounds(516, 162, 97, 36);
		contentPane.add(lb3);
		
		JLabel lb4 = new JLabel("");
		lb4.setForeground(Color.WHITE);
		lb4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lb4.setBounds(65, 278, 98, 36);
		contentPane.add(lb4);
		
		JLabel lb5 = new JLabel("");
		lb5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lb5.setForeground(Color.WHITE);
		lb5.setBounds(222, 278, 97, 36);
		contentPane.add(lb5);
		
		JLabel lb6 = new JLabel("");
		lb6.setForeground(Color.WHITE);
		lb6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lb6.setBounds(369, 278, 86, 36);
		contentPane.add(lb6);
		
		JLabel lb7 = new JLabel("");
		lb7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lb7.setBackground(new Color(240, 240, 240));
		lb7.setForeground(Color.WHITE);
		lb7.setBounds(516, 278, 97, 29);
		contentPane.add(lb7);
		
		JLabel lb8 = new JLabel("");
		lb8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lb8.setForeground(Color.WHITE);
		lb8.setBounds(221, 394, 98, 36);
		contentPane.add(lb8);
		
		JLabel lblNewLabel_1 = new JLabel("رقم");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setForeground(Color.ORANGE);
		lblNewLabel_1.setBounds(79, 102, 46, 50);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("مشكول");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setForeground(Color.ORANGE);
		lblNewLabel_1_1.setBounds(214, 117, 66, 20);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("جذر");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setForeground(Color.ORANGE);
		lblNewLabel_1_2.setBounds(372, 117, 66, 20);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("غیرمشكول");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_3.setForeground(Color.ORANGE);
		lblNewLabel_1_3.setBounds(524, 110, 66, 35);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("صنف");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_4.setForeground(Color.ORANGE);
		lblNewLabel_1_4.setBounds(79, 244, 46, 14);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("أصل");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_5.setForeground(Color.ORANGE);
		lblNewLabel_1_5.setBounds(234, 238, 46, 23);
		contentPane.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("جنس");
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_6.setForeground(Color.ORANGE);
		lblNewLabel_1_6.setBounds(380, 235, 46, 23);
		contentPane.add(lblNewLabel_1_6);
		
		JLabel lblNewLabel_1_7 = new JLabel("عدد");
		lblNewLabel_1_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_7.setForeground(Color.ORANGE);
		lblNewLabel_1_7.setBounds(505, 244, 66, 14);
		contentPane.add(lblNewLabel_1_7);
		
		JLabel lb1_1 = new JLabel("تلاش کا صفحہ");
		lb1_1.setForeground(Color.WHITE);
		lb1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lb1_1.setBounds(271, 11, 115, 29);
		contentPane.add(lb1_1);
		
		JLabel lblNewLabel_1_8 = new JLabel("غیرأصل");
		lblNewLabel_1_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_8.setForeground(Color.ORANGE);
		lblNewLabel_1_8.setBounds(380, 353, 46, 20);
		contentPane.add(lblNewLabel_1_8);
		
		JLabel lblNewLabel_1_9 = new JLabel("المعنى");
		lblNewLabel_1_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_9.setForeground(Color.ORANGE);
		lblNewLabel_1_9.setBounds(222, 348, 46, 31);
		contentPane.add(lblNewLabel_1_9);
		
		JLabel lb9 = new JLabel("");
		lb9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lb9.setForeground(Color.WHITE);
		lb9.setBounds(370, 394, 97, 36);
		contentPane.add(lb9);
		
		JLabel lb10 = new JLabel("");
		lb10.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lb10.setBounds(362, 162, 115, 36);
		contentPane.add(lb10);
		
		JButton rootbtn = new JButton("جذر کا صفحہ");
		rootbtn.setForeground(Color.BLACK);
		rootbtn.setBackground(Color.ORANGE);
		rootbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchRootView viewobj=new SearchRootView();
				
				viewobj.show();
				
			}
		});
		rootbtn.setBounds(97, 62, 115, 23);
		contentPane.add(rootbtn);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setForeground(Color.ORANGE);
		panel_1.setBackground(Color.ORANGE);
		panel_1.setBounds(-12, 0, 710, 50);
		contentPane.add(panel_1);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s=getText();
				ArrayList<MashqoolTransferObjects> list = obj.getDetailsByWord(s);
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

	}
	public String getText()
	{
		DictionaryLogic dictionaryLogicObj=new DictionaryLogic();
		String word=sf.getText();
		dictionaryLogicObj.getDetailsByWord(word);
		return word;
	}
}