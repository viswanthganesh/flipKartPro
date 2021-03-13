package Generic_lib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class PropertyFileUtils 
{
	public String  getPropertykeyValue(String propath,String key) throws Throwable
	{
		FileInputStream fil = new FileInputStream(propath);
		
		Properties pro = new Properties();
		pro.load(fil);
		String proValue = pro.getProperty(key, "incorrect key");
		return proValue;
	}

}
