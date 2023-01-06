import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import businessLogicLayer.DictionaryLogic;

public class TestBusinessLayer {
	static DictionaryLogic obj;
	@BeforeAll
	static void initAllTests() {
		obj=new DictionaryLogic();
	}
	 
	@Test
	void validateFileAndTableNameShouldPass() {
		Assertions.assertTrue(obj.validateFileAndTableName("Faeel.csv", "Faeel"));
	}
	
	@Test
	void InValidFilePathShouldFail() {
		String path = "D:\\Mafoul.csv";
		obj.setFilePath("D:\\Faeel.csv");
		Assertions.assertEquals(path,obj.getFilePath());
	}
	
	@Test
	void validTableNameShouldPass() {
		String name = "Mafoul";
		obj.setTableName("Mafoul.csv");
		Assertions.assertEquals(name,obj.getTableName());
	}

	@Test
	void validNormalizedShouldPass() {
		String unNormal = "مُقَفّاة";
		String normal = "مقفاة";
		Assertions.assertEquals(normal,obj.normalize(unNormal));
	}

}
