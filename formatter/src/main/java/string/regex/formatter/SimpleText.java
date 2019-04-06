package string.regex.formatter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleText extends Formatter {
	
	public SimpleText(int limit) {
		super(limit);
	}

	@Override
	public String format(String text) {
    	Pattern pattern = Pattern.compile(regexGetLimitCharacters, Pattern.DOTALL);
    	Matcher matcher = pattern.matcher(text);
    	StringBuilder result = new StringBuilder();
    	String group;
    	boolean lineBreak;
    	
    	while (matcher.find()) {	
    		group = matcher.group();
    		lineBreak = group.contains("\n");
    		result.append(group.replaceAll(REGEX_ELIMINATE_SPACES_AT_THE_END, ""))
    			  .append(lineBreak ? "" : "\n");
    	}
    	return result.toString();
    }
}
