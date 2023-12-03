package fr.eni.papeterie.dal;

import java.io.IOException;
import java.util.Properties;

public class Settings {
	private static Properties properties;
	
	static {
		properties = new Properties();
		try {
			properties.load(Settings.class.getResourceAsStream("settings.properties"));
		} catch (IOException e) {
	System.out.println(String.format("j'ai pas trouvé le fichier properties !!! %s", e.getMessage()));
			e.printStackTrace();
		}
	}
	
	public static String getProperty(String key) {
		return properties.getProperty(key);
	}

}
