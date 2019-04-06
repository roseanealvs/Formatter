package string.regex.formatter;

import java.util.regex.Pattern;

public abstract class Formatter {
	protected static final String WHITESPACE_HEXADECIMAL = "\\u0020";
	protected static final String REGEX_ELIMINATE_SPACES_AT_THE_END = RegexBuilder.builder().enableEmbeddedMultilineMode()
											.createLookahead(WHITESPACE_HEXADECIMAL, "$")
											.build();
	protected int limit;
	
	protected static String regexGetLimitCharacters;
	protected static Pattern patternLimitCharacters;
	
	public Formatter(Integer limit) {
		this.limit = limit;
		regexGetLimitCharacters = getLimitCharacterRegex();
		patternLimitCharacters = Pattern.compile(regexGetLimitCharacters, Pattern.DOTALL);
	}

    private String getLimitCharacterRegex() {
		return RegexBuilder.builder()
    			.matchAnySingleCharacter()
    			.matchItFromOneToNumberTimes(limit)
    			.matchNewLine()
    			.addOrCondition()
    			.matchAnySingleCharacter()
    			.matchItFromOneToNumberTimes(limit)
    			.matchEndOfInput()
    			.addOrCondition()
    			.matchAnySingleCharacter()
    			.matchItFromOneToNumberTimes(limit)
    			.matchWhiteSpace()
    			.build();
	}
	
    public abstract String format(String text);
    
}
