package dataAccessLayer;
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.github.msarhan.lucene.ArabicRootExtractorStemmer;

import businessLogicLayer.DictionaryLogic;
import transferObject.MashqoolTransferObjects;
import transferObject.JazzarTransferObjects;

public class DictionaryDatabase {
	static Connection connectionForDatabase=MySQLConnection.getConnection("");
	static Connection connectionForTables;
	ArrayList<MashqoolTransferObjects> updatedList=new ArrayList<MashqoolTransferObjects>();
	ArrayList<MashqoolTransferObjects> searchedList=new ArrayList<>();
	static String dataBaseName = "iteration1";
	static String tableName;	
	
	public boolean isDatabaseExists() throws SQLException {
		
		ResultSet rs = connectionForDatabase.getMetaData().getCatalogs();
		while(rs.next()){
			String catalogs = rs.getString(1);
			if(dataBaseName.equals(catalogs)){
				return true;
			}
		}
		return false;
	}
	
	public void deleteDatabase() throws SQLException {
		Statement statement = connectionForDatabase.createStatement();
		String databaseQuery = "Drop DATABASE "+dataBaseName;
		statement.executeUpdate(databaseQuery);
		System.out.println("Database deleted");
		
	}
	
	public static void createTable(String tableName, String dataBaseName) throws SQLException {
		connectionForTables = MySQLConnection.getConnection(dataBaseName);
		Statement statement = connectionForTables.createStatement();
		String databaseQuery = "CREATE TABLE "+tableName+" (رقم int, مشكول varchar(255) CHARACTER SET utf8,جذر varchar(255) CHARACTER SET utf8, غیرمشكول varchar(255) CHARACTER SET utf8, صنف varchar(255), أصل varchar(255), جنس varchar(255), عدد varchar(255) CHARACTER SET utf8, غیرأصل varchar(255) CHARACTER SET utf8, المعنى varchar(255) CHARACTER SET utf8  )";
		statement.executeUpdate(databaseQuery);
		System.out.println("table created");
	}
	
	public void createAsal(String asalTable, String dataBaseName) throws SQLException
	{
		connectionForTables = MySQLConnection.getConnection(dataBaseName);
		Statement statement = connectionForTables.createStatement();
		String databaseQuery = "CREATE Table "+asalTable+" (رقم int,أصل varchar(255))";
		statement.executeUpdate(databaseQuery);
		System.out.println("Asal Created");
	}
	
	public void createRoot(String rootTable, String dataBaseName) throws SQLException
	{
		connectionForTables = MySQLConnection.getConnection(dataBaseName);
		Statement statement = connectionForTables.createStatement();
		String databaseQuery = "CREATE Table "+rootTable+" (رقم int,جذر varchar(255))";
		statement.executeUpdate(databaseQuery);
		System.out.println("Root Table Created");
	}
	
	public void createDatabase() throws SQLException
	{
		Statement statement = connectionForDatabase.createStatement();
		String databaseQuery = "CREATE DATABASE " + dataBaseName;
		statement.executeUpdate(databaseQuery);
		System.out.println("Database Created.");
		createTable("Dictionary", dataBaseName);
		createAsal("Asal", dataBaseName);
		createRoot("Juzzar", dataBaseName);
	}
	public static void dataConnection(DictionaryLogic bl) 
	{
		connectionForTables = MySQLConnection.getConnection(dataBaseName);
        int batchSize = 20;
    	tableName=bl.getTableName();
    	String path=bl.getFilePath();
    	String fileName=bl.getFileName();
    	try
        {
    		String query = "insert into "+tableName+"(رقم, مشكول, جذر, غیرمشكول, صنف, أصل, جنس, عدد, غیرأصل) values(?, ?, ?, ?, ?, ?, ?, ?,?)";
        	String query2 = "insert into asal (رقم ,أصل) values(?,?)";
        	String query3 = "insert into juzzar (رقم ,جذر) values(?,?)";
        	PreparedStatement statement = connectionForTables.prepareStatement(query);
        	PreparedStatement statement2 = connectionForTables.prepareStatement(query2);
        	PreparedStatement statement3 = connectionForTables.prepareStatement(query3);
        	BufferedReader lineReader = new BufferedReader(new FileReader(path));
        	String lineText = null;
        	int count = 0;
        	lineReader.readLine();
        	ArabicRootExtractorStemmer stemmerRoot=new ArabicRootExtractorStemmer();
    		Set<String> set=new HashSet<String>();
            while ((lineText = lineReader.readLine())!=null)
            {
                String [] data = lineText.split(",");
                String rakam = data[0];
                String mashkool = data[1];
                String jazzar=String.join(",",stemmerRoot.stem(data[1]));
                String gairMashkool = bl.normalize(data[1]);
                String sinf = data[2];
                String asal = data[3];
                String jins = data[4];
                String adad = data[5];
                String gairAsal = bl.normalize(data[3]);
                statement.setInt(1,parseInt(rakam));
                statement.setString(2,mashkool);
                statement.setString(3, null);
                statement.setString(4,gairMashkool);
                statement.setString(5,sinf);
                statement.setString(6,asal);
                statement.setString(7,jins);
                statement.setString(8,adad);
                statement.setString(9,gairAsal);
                statement.addBatch();
                statement2.setString(1,rakam);
                statement2.setString(2, asal);
                statement2.addBatch();
                String [] res = jazzar.split(",", 0);
                for(int i=0;i<res.length;i++) {
                	statement3.setString(1, rakam);
                	statement3.setString(2, res[i]);
                	statement3.addBatch();
                	statement3.executeBatch();
                }
                if(count % batchSize == 0)
                {
                	count = 0;
                    statement.executeBatch();
                    statement2.executeBatch();
                }
                count++;
            }
            lineReader.close();
            statement.executeBatch();
            statement2.executeBatch();
            connectionForTables.commit();
            System.out.println("Data has been inserted successfully!");       	
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        } 	
	}
 

	
	public ArrayList<MashqoolTransferObjects> getAllDetails() throws SQLException 
	{		
		connectionForTables = MySQLConnection.getConnection(dataBaseName);
			Statement stat=connectionForTables.createStatement();
			String query="SELECT * FROM "+tableName;
			ResultSet rs=stat.executeQuery(query);
			while(rs.next())
			{
				MashqoolTransferObjects s= new MashqoolTransferObjects();
				s.setRaqm(rs.getInt(1));
				s.setMashqool(rs.getString(2));
				s.setJuzar(rs.getString(3));
				s.setGermashqool(rs.getString(4));
				s.setSinf(rs.getString(5));
				s.setAsal(rs.getString(6));
				s.setJins(rs.getString(7));
				s.setAdad(rs.getString(8));
				s.setGerasal(rs.getString(9));
				s.setMeaning(rs.getString(10));
				updatedList.add(s);
			}
		return updatedList;
	}
	 public ArrayList<JazzarTransferObjects> getAllRoot() throws SQLException
	 {
		connectionForTables = MySQLConnection.getConnection(dataBaseName);
		 ArrayList<JazzarTransferObjects> r=new ArrayList<JazzarTransferObjects>();
		 Statement stat=connectionForTables.createStatement();
			String query="SELECT * FROM juzzar";
			ResultSet rs=stat.executeQuery(query);
			while(rs.next())
			{
				JazzarTransferObjects s= new JazzarTransferObjects();
				s.setRaqam(rs.getInt(1));
				s.setJuzzar(rs.getString(2));
				r.add(s);
			}
		return r;
	 }
    public void addMeaningIntoDatabase(ArrayList<MashqoolTransferObjects> w) throws SQLException
    {	 
		connectionForTables = MySQLConnection.getConnection(dataBaseName);
    	connectionForTables.setAutoCommit(true);
			Statement stat=connectionForTables.createStatement();
			for(int i=0;i<w.size();i++)
			{
				System.out.print(w.get(i).getMeaning().toString());
				System.out.println("tablename in update: "+ tableName);
				String query="update "+tableName+" set المعنى='"+w.get(i).getMeaning()+"'where مشكول='"+w.get(i).getMashqool()+"'";
			stat.executeUpdate(query);
			}
			connectionForTables.setAutoCommit(false);
    }
    public void updateRootIntoDatabase(ArrayList<MashqoolTransferObjects> w) throws SQLException
    {	 
		connectionForTables = MySQLConnection.getConnection(dataBaseName);
    	connectionForTables.setAutoCommit(true);
			Statement stat=connectionForTables.createStatement();
				for(int i=0;i<w.size();i++)
				{
					System.out.print(w.get(i).getMeaning().toString());
					String query="update "+tableName+" set جذر='"+w.get(i).getJuzar()+"'where مشكول='"+w.get(i).getMashqool()+"'";
				stat.executeUpdate(query);
				}
				connectionForTables.setAutoCommit(false);
    }
    public void addWordIntoDB(ArrayList<MashqoolTransferObjects> w) throws SQLException
    {
		connectionForTables = MySQLConnection.getConnection(dataBaseName);
    	connectionForTables.setAutoCommit(true);
    		Statement stat=connectionForTables.createStatement();
			for(int i=0;i<w.size();i++)
			{
			String query1="insert into "+tableName+" values('"+w.get(i).getRaqm()+"','"+w.get(i).getMashqool()+"','"+w.get(i).getJuzar()+"','"+w.get(i).getGermashqool()+"','"+w.get(i).getSinf()+"','"+w.get(i).getAsal()+"','"+w.get(i).getJins()+"','"+w.get(i).getAdad()+"','"+w.get(i).getGerasal()+"','"+w.get(i).getMeaning()+"')"; 
			stat.executeUpdate(query1);
			}
			connectionForTables.setAutoCommit(false);
    }
    public ArrayList<MashqoolTransferObjects> getWordsList(String s1)
	{
		connectionForTables = MySQLConnection.getConnection(dataBaseName);
		try{  
			DictionaryLogic objbl=new DictionaryLogic();
			Statement stat=connectionForTables.createStatement();
			String q="select * from "+tableName+" where مشكول like '%" + s1 + "%'";
			ResultSet rs=(ResultSet) stat.executeQuery(q);  

			while(rs.next())  
			{
				MashqoolTransferObjects obj1=new MashqoolTransferObjects(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10));
				searchedList.add(obj1);
			}
			}catch(Exception e){ System.out.println(e);}
		return searchedList;  
	}
    public ArrayList<MashqoolTransferObjects> getRootList(String s1)
	{
		connectionForTables = MySQLConnection.getConnection(dataBaseName);
		try{  
			String t="juzzar";
			String tableName2="dictionary";
			Statement stat=connectionForTables.createStatement();
			String q1="select رقم from "+t+" where جذر like '%" + s1 + "%'";
			ResultSet rs0=(ResultSet) stat.executeQuery(q1);
			rs0.next();
			int qvalue=rs0.getInt(1);
			String q="select * from "+tableName2+" where رقم like '%" + qvalue + "%'";
			ResultSet rs=(ResultSet) stat.executeQuery(q);  
			while(rs.next())  
			{
				MashqoolTransferObjects obj1=new MashqoolTransferObjects(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10));
				searchedList.add(obj1);
			}
			}catch(Exception e){ System.out.println(e);}
		return searchedList;  
	}
}