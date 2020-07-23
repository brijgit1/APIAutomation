package pkg1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public Properties prop;

	
	public TestBase() throws IOException {
		FileInputStream fis1=new FileInputStream("src/test/resources/file.properties");
		prop=new Properties();
		prop.load(fis1);
		
	}
	
	
	
	
	
	

}
