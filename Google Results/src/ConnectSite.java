import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class ConnectSite {
	
	public static final String agent = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36";
	
	public static String getRawResults (URL url, String agent) {
        try {
    		URLConnection connection = url.openConnection();
    		connection.setRequestProperty("User-Agent", agent);
    		InputStream stream = connection.getInputStream();
    		ByteArrayOutputStream out = new ByteArrayOutputStream();
    		int ch;
    		while (-1 != (ch = stream.read()))
    			out.write(ch);
    		String html = out.toString();
        	return html;
        }
        catch (IOException e) {
        	e.printStackTrace();
        }
        return null;
	}
}
