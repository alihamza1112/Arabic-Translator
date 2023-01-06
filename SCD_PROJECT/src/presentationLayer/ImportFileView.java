package presentationLayer;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.github.msarhan.lucene.ArabicRootExtractorStemmer;

import businessLogicLayer.DictionaryLogic;
public class ImportFileView extends JFrame {

	private JPanel contentPane;
	static File file2;
	private DictionaryLogic dictionaryLogicObj=new DictionaryLogic();
	private JTable table;
	private DefaultTableModel model;
	private boolean firstTimeConnection=true;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ImportFileView frame = new ImportFileView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @return 
	 */
	public ImportFileView() {
		setResizable(false);
		String[] Lables= {"رقم", "مشكول", "جذر", "غیرمشكول", "صنف", "أصل", "جنس", "عدد", "غیرأصل"};
		model=new DefaultTableModel(Lables,0);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 724, 497);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
				
				JPanel panel_1 = new JPanel();
				panel_1.setBackground(Color.ORANGE);
				panel_1.setForeground(Color.ORANGE);
				panel_1.setBounds(0, 25, 710, 50);
				contentPane.add(panel_1);
				panel_1.setLayout(null);
				
				JLabel lblNewLabel = new JLabel("Import Files");
				lblNewLabel.setForeground(Color.WHITE);
				lblNewLabel.setBackground(Color.WHITE);
				lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
				lblNewLabel.setBounds(298, 10, 171, 35);
				panel_1.add(lblNewLabel);
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(168, 121, 506, 313);
				contentPane.add(scrollPane);
				
				
				table = new JTable();
				scrollPane.setViewportView(table);
				table.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
					}
				));
				
				
				JButton btnNewButton = new JButton("Browse File");
				btnNewButton.setBounds(23, 345, 111, 29);
				contentPane.add(btnNewButton);
				btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JFileChooser Chooser = new JFileChooser();
						int response=Chooser.showOpenDialog(null);
						if(response==JFileChooser.APPROVE_OPTION) 
						{
							File file =new File (Chooser.getSelectedFile().getAbsolutePath());
							dictionaryLogicObj.setFileName(file.getName());
							dictionaryLogicObj.setFilePath(file.getPath());
							dictionaryLogicObj.setTableName(file.getName());
							file=null;
						}
					}
				});
				btnNewButton.setBackground(Color.ORANGE);
				btnNewButton.setForeground(Color.WHITE);
				
						JButton btnNewButton_1 = new JButton("Upload File");
						btnNewButton_1.setBounds(23, 389, 111, 29);
						contentPane.add(btnNewButton_1);
						btnNewButton_1.setForeground(Color.WHITE);
						btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
						btnNewButton_1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								DictionaryLogic con=new DictionaryLogic();
								try {
									con.connectionOfPresentationWithDB(dictionaryLogicObj, firstTimeConnection);
									firstTimeConnection=false;
								} catch (SQLException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								}
								try {
									String line;
									String splitBy=",";
									BufferedReader br = new BufferedReader(new FileReader(dictionaryLogicObj.getFilePath()));
									System.out.println(dictionaryLogicObj.getFilePath());
									ArabicRootExtractorStemmer stemmerRoot=new ArabicRootExtractorStemmer();
						    		Set<String> set=new HashSet<String>();
									while((line=br.readLine())!=null) {
										String[] arrayList=line.split(splitBy	);	
										Object[] obj=new Object[9];
										obj[0]=arrayList[0];
										obj[1]=arrayList[1];
										obj[2]=null;
										obj[3]=dictionaryLogicObj.normalize(arrayList[1]);
										obj[4]=arrayList[2];
										obj[5]=arrayList[3];
										obj[6]=arrayList[4];
										obj[7]=arrayList[5];
										obj[8]=dictionaryLogicObj.normalize(arrayList[3]);
										model.addRow(obj);
									}
									table.setModel(model);
								}catch (IOException e1) {
							        e1.printStackTrace();
							    }
								
							}
						});
						btnNewButton_1.setBackground(Color.ORANGE);
	}
}

