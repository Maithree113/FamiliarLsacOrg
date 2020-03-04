package common;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/** This is used to read and written environment properties **/

public class EnvironmentProperties {
	
		 String result = "";
		 InputStream inputStream;
	 
		public String getPropValues(String propValue) throws IOException {
	       
			FileReader reader = null;
			try 
			{
				Properties prop = new Properties();
				String propFileName = "EnvironmentDetails.properties";
	            reader=new FileReader(System.getProperty("user.dir")+"/src/test/java/resources/"+propFileName);
	            if (reader != null) 
	             {
					prop.load(reader);
	             }
				// get the property value
			    result = prop.getProperty(propValue);
			    
			} catch (Exception e) {
				System.out.println("Exception: " + e);		
			}
			finally
			{
				reader.close();
			}
			return result;
		}
	}

