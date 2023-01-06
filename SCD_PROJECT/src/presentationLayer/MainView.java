package presentationLayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class MainView extends JFrame {

	private JPanel contentPane;
	private Facade facade=new Facade();
	public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				MainView frame = new MainView();
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
	public MainView() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 724, 497);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_3 = new JButton("Search Data");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				facade.openSearchDataViewFrame();
			}
		});
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setBackground(Color.ORANGE);
		btnNewButton_3.setBounds(385, 267, 148, 29);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_2_1 = new JButton("Add Roots");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				facade.openRootViewFrame();
			}
		});
		btnNewButton_2_1.setForeground(Color.WHITE);
		btnNewButton_2_1.setBackground(Color.ORANGE);
		btnNewButton_2_1.setBounds(385, 166, 148, 29);
		contentPane.add(btnNewButton_2_1);
		
		JButton btnNewButton_2 = new JButton("Add Meanings");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				facade.openMeaningViewFrame();
			}
		});
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(Color.ORANGE);
		btnNewButton_2.setBounds(149, 267, 148, 29);
		contentPane.add(btnNewButton_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setForeground(Color.ORANGE);
		panel_1.setBackground(Color.ORANGE);
		panel_1.setBounds(0, 41, 710, 50);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("Arabic Translator");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(298, 10, 171, 35);
		panel_1.add(lblNewLabel);
		
		JButton btnNewButton_2_2 = new JButton("Import Files");
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				facade.openImportFileFile();
			}
		});
		btnNewButton_2_2.setForeground(Color.WHITE);
		btnNewButton_2_2.setBackground(Color.ORANGE);
		btnNewButton_2_2.setBounds(149, 166, 148, 29);
		contentPane.add(btnNewButton_2_2);
	}
}
