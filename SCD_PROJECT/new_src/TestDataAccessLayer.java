import java.sql.SQLException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import dataAccessLayer.DictionaryDatabase;


public class TestDataAccessLayer {
	static DictionaryDatabase obj;
	@BeforeAll
	static void initAllTests() {
		obj=new DictionaryDatabase();
	}
	@Test
	void shouldPassIfDatabaseExists() {
		try {
			Assertions.assertTrue(obj.isDatabaseExists());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
