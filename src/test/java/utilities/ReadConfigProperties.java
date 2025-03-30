package utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Base64;
import java.nio.charset.StandardCharsets;

public class ReadConfigProperties {

	public String ReadPropFile1(String propKey) throws IOException {
		
		String currentDir = System.getProperty("user.dir");
        System.out.println("Current working directory: " + currentDir);
        
		FileReader reader = new FileReader(currentDir + "/src/test/resources/configfiles/config.properties");
		Properties prop = new Properties();
		prop.load(reader);
		String propValue = prop.getProperty(propKey);

		return propValue;

	}
	
	 public static void Base64ExampleEncode(String str) {
	        String originalString = "This is a sample string!";

	        // Encoding to Base64
	        String encodedString = Base64.getEncoder().encodeToString(originalString.getBytes(StandardCharsets.UTF_8));
	        System.out.println("Encoded string: " + encodedString);

	        // Decoding from Base64
	        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
	        String decodedString = new String(decodedBytes, StandardCharsets.UTF_8);
	        System.out.println("Decoded string: " + decodedString);
	    }
	 
		public static String Base64decodeString(String secret) {
			// Decoding from Base64
	        byte[] decodedBytes = Base64.getDecoder().decode(secret);
	        String decodedString = new String(decodedBytes, StandardCharsets.UTF_8);
	        System.out.println("Decoded string: " + decodedString);
	        return decodedString;
		}
}
