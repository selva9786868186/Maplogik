package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
public class PropUtils {
	Properties prop;
	public PropUtils(String filePath) {
		prop = new Properties();
		String propertypath = System.getProperty("user.dir") + filePath;
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(propertypath);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public String getValue(String key) {

		return prop.getProperty(key);
	}
	public int getValues2(String key) {
		return Integer.parseInt(prop.getProperty(key));

	}
}




