package string.regex.formatter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JustifiedText extends Formatter {
	
	private static final String REGEX_COUNT_VALID_WHITESPACES = RegexBuilder.builder()
			.createNegativeLookahead(WHITESPACE_HEXADECIMAL, "$")
			.build();
	
	private static Pattern patternNumerOfWhiteSpaces = Pattern.compile(REGEX_COUNT_VALID_WHITESPACES, Pattern.MULTILINE);
	
	public JustifiedText(int limit) {
		super(limit);
	}

	public String format(String text) {
    	Pattern pattern = Pattern.compile(regexGetLimitCharacters, Pattern.DOTALL);
    	Matcher matcher = pattern.matcher(text);
    	StringBuilder result = new StringBuilder();
    	String group;
    	boolean lineBreak;
    	
    	while (matcher.find()) {	
    		group = matcher.group();
    		lineBreak = group.contains("\n");
    		result.append(justifyLine(group.replaceAll(REGEX_ELIMINATE_SPACES_AT_THE_END, "")))
    			  .append(lineBreak ? "" : "\n");
    	}
    	return result.toString();
    }
    
    private String justifyLine(String textLine) {		
		StringBuilder result = new StringBuilder();
		int existingSpaces = getNumberOfWhiteSpaces(textLine);
		
		if (existingSpaces <= 0) {
			return textLine;
		}
		
    	int spaceNeeded = limit - textLine.replace("\n", "").length();
    	int div = spaceNeeded / existingSpaces;
    	int mod = spaceNeeded % existingSpaces;
    	
    	String[] words = textLine.split(WHITESPACE_HEXADECIMAL);
    	int wordsCount = words.length;
    	
    	if (spaceNeeded > 0) {
    		for (int i = 0; i < wordsCount - 1; i++) {
    			result.append(leftPad(words[i], words[i].length() + div + 1 + (mod-- > 0 ? 1 : 0)));
        	}
    		result.append(words[wordsCount - 1]);
    	} 
    	return result.toString();
    }

    private String leftPad(String word, int length) {
    	return String.format("%-"+ length +"s", word);
    }
    
    private int getNumberOfWhiteSpaces(String text) {
		Matcher matcher = patternNumerOfWhiteSpaces.matcher(text);
    	int spaces = 0;
		while (matcher.find()) {
			spaces++;
		}
		return spaces;
    }
}
