package businessLogicLayer;
import java.sql.SQLException;
import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.ArrayList;

import dataAccessLayer.DictionaryDatabase;
import transferObject.MashqoolTransferObjects;
import transferObject.JazzarTransferObjects;
public class DictionaryLogic {
	String tableName;
	String fileName="";
	String filePath;
	boolean asalValid[]= {false,false,false};
	
	private static DictionaryDatabase dictionaryDb;

	public DictionaryLogic()
	{
		dictionaryDb=new DictionaryDatabase();
	}
	
	public void setTableName(String str) {
		tableName="Dictionary";
	}
	public String getTableName() {
		return tableName;
	}
	public void setFileName(String str) {
		fileName=str;
	}
	public String getFileName() {
		return fileName;
	}
	public boolean validateFileAndTableName(String file, String table) {
		for(int i=0;i<table.length();i++) {
			if(table.charAt(i)!=file.charAt(i)) {
				return false;
			}
		}
		return true;
	}
	public void setFilePath(String str) {
		filePath=str;
		String str2="";
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)=='\\'){
				str2=str2+filePath.charAt(i);
			}
			str2=str2+filePath.charAt(i);
		}
		filePath=str2;
	}
	public String getFilePath() {
		return filePath;
	}
	public void connectionOfPresentationWithDB(DictionaryLogic bl, boolean firstTimeConnection) throws SQLException {
		if(dictionaryDb.isDatabaseExists() && firstTimeConnection) {
			dictionaryDb.deleteDatabase();
			dictionaryDb.createDatabase();
		}
		if(!dictionaryDb.isDatabaseExists()) {
			dictionaryDb.createDatabase();
		}
		dictionaryDb.dataConnection(bl);
	}
	public String normalize(String word){

        return Normalizer.normalize(word, Form.NFKD).replaceAll("\\p{M}", "");
    }
	public int getColumnCount(String fileName) {
		if(fileName.equals("Faeel.csv")) {
			return 1;
		}
		else if(fileName.equals("Mafoul.csv")) {
			return 2;
		}
		else if(fileName.equals("Masdar.csv")) {
			return 3;
		}
		return 1;
	}

	
	public ArrayList<MashqoolTransferObjects> getWordList() throws SQLException  {
		ArrayList<MashqoolTransferObjects> word = dictionaryDb.getAllDetails();
		return word;
	}
	public ArrayList<JazzarTransferObjects> getRootList() throws SQLException  {
		ArrayList<JazzarTransferObjects> root = dictionaryDb.getAllRoot();
		return root;
	}
	public void updateMeaning(ArrayList<MashqoolTransferObjects> w) throws SQLException
	{
		dictionaryDb.addMeaningIntoDatabase(w);
	}
	public void updateRoot(ArrayList<MashqoolTransferObjects> w) throws SQLException
	{
		dictionaryDb.updateRootIntoDatabase(w);
	}
	public void addWord(ArrayList<MashqoolTransferObjects> w) throws SQLException
	{
		dictionaryDb.addWordIntoDB(w);
	}
	
	public ArrayList<MashqoolTransferObjects> getDetailsByWord(String s) 
	{
		ArrayList<MashqoolTransferObjects> list = dictionaryDb.getWordsList(s);
		return list;
	}
	public ArrayList<MashqoolTransferObjects> getDetailsByRoot(String s) 
	{
		ArrayList<MashqoolTransferObjects> list = dictionaryDb.getRootList(s);
		return list;
	}
}