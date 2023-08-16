package org.projetEncheres.HAG.config;

import java.io.IOException;
import java.util.Properties;

public class Settings {
	
	private static Properties properties;
	
	// Le bloc static va s'ouvrir une fois au chargement de la classe
		static {
			properties = new Properties();
			try {
				properties.load(Settings.class.getResourceAsStream("settings.properties"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public static String getProperty(String key) {
			return properties.getProperty(key);
		}
}
