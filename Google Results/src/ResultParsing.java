import java.lang.String;
import java.util.ArrayList;
import java.net.URLDecoder;
import java.io.UnsupportedEncodingException;

public class ResultParsing {
	
	private static final String resultstring = "<h2 class=\"hd\">Search Results</h2>";
	private static final String liststring = "<li class=\"g\">";
	//private static final String headerstring = "<h3 class=\"r\">";
	private static final String linkstring = "<a href=\"";
	private static final String urlstring = "/url?q=http";
	
	private static String touchups (String url) {
		String cleaned = url.substring(url.indexOf("http"), url.indexOf('&'));
		try {
			cleaned = URLDecoder.decode(cleaned, "UTF-8");
		}
		catch (UnsupportedEncodingException e) {
			throw new RuntimeException ("An error occurred while decoding the URL.");
		}
		return cleaned;
	}
	
	public static ArrayList<String> parseHTML (String html) {
		ArrayList<String> results = new ArrayList<>();
		if (html == null) {
			return results;
		}
		int index = html.indexOf(resultstring);
		while ((index = html.indexOf(liststring, index)) != -1) {
			/*if ((index = html.indexOf(headerstring, index)) == -1) {
				break;
			}*/
			if ((index = html.indexOf(linkstring, index)) == -1) {
				break;
			}
			index += linkstring.length();
			int end_index = html.indexOf('\"', index);
			String test = html.substring(index, end_index);
			if (test.indexOf(urlstring) != -1) {
				results.add(touchups(test));
			}
		}
		return results;
	}
}
