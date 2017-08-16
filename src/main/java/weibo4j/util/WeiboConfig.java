package weibo4j.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class WeiboConfig {

	public WeiboConfig() {
	}

	private static Properties props = new Properties();

	static {
		InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("sinaconfig.properties");
		if (in != null) {
			try {
				props.load(in);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	public static String getValue(String key) {
		return props.getProperty(key);
	}

	public static void updateProperties(String key, String value) {
		props.setProperty(key, value);
	}

}
