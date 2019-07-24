import java.net.URL;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class GoogleSearch {
	
	private static final String searchstring = "http://www.google.com/search?q=";
	private static final String startstring = "&start=";
	private static final String agent = "Mozilla/21.0 (Windows; U; Windows 7; en-US)";
	private static final int query_size = 10;
	private String query = null;
	private int last_pos = 0;
	
	public GoogleSearch () {
		
	}
	
	public GoogleSearch (String query) {
		this.query = query;
	}
	
	private ArrayList<String> parseQuery (String query) {
		StringTokenizer st = new StringTokenizer (query, " ");
		ArrayList<String> parsed = new ArrayList<>();
		while (st.hasMoreTokens()) {
			parsed.add(st.nextToken());
		}
		return parsed;
	}
	
	private URL encodeGoogleQuery (ArrayList<String> queries, int start) {
		try {
			StringBuilder address = new StringBuilder();
            address.append(searchstring);
            for (int i = 0; i < queries.size(); i++) {
                address.append(queries.get(i));
                if (i + 1 < queries.size())
                	address.append("+");
            }
            address.append(startstring + String.valueOf(start));
            return new URL(address.toString());
		}
		catch (IOException e) {
        	throw new RuntimeException ("An error occurred while encoding the query.");
        }
    }
	
	private ArrayList<String> getGoogleResults (int number, int start) {
		if (query == null) {
			return null;
		}
		ArrayList<String> results = new ArrayList<>();
		for (int i = 0; i*query_size < number; i ++) {
			results.addAll(ResultParsing.parseHTML(ConnectSite.getRawResults(encodeGoogleQuery(parseQuery(query), start+i*query_size), agent)));
			last_pos = (i+1)*query_size;
		}
		return results;
	}
	
	public void newQuery (String query) {
		this.query = query;
		last_pos = 0;
	}
	
	public ArrayList<String> getGoogleResults (int number) {
		return getGoogleResults(number, 0);
	}
	
	public ArrayList<String> getNextGoogleResults (int number) {
		return getGoogleResults(number, last_pos);
	}
	
	public static void main(String[] args){
		GoogleSearch gr = new GoogleSearch("joanne lee");
		ArrayList<String> temp = gr.getGoogleResults(10);
		for (int i = 0; i < temp.size(); i ++) {
			System.out.println(temp.get(i));
		}
	}
}