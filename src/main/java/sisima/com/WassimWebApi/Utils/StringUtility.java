package sisima.com.WassimWebApi.Utils;

public class StringUtility {

	
	
	public final static String requestBody_formateString(String str) {
		
		String res = str.replaceAll("\n", "");
		res = res.replaceAll("\t", "");
		res = res.replaceAll("\\{", "");
		res = res.replaceAll("\\}", "");
		res = res.replaceAll("\"", "");
		
		return res;
	}
	
	
	
	public final static String requestBody_GetStringValue(String str) {
		
		String formattedString = StringUtility.requestBody_formateString(str);
		String[] res = new String[2];
		res = formattedString.split(":");
		
		return res[1];
	}
	
	
	public final static Long requestBody_GetLongValue(String str) {
		
		String formattedString = StringUtility.requestBody_formateString(str);
		
		String[] res = new String[2];
		res = formattedString.split(":");
		
		String value = res[1].replaceAll(" ", "");
		System.err.println("value : ".concat(value));
		System.err.println("value 2 : ".concat(String.valueOf((Long.parseLong(value)))));
		return Long.parseLong(value);
	}
}
