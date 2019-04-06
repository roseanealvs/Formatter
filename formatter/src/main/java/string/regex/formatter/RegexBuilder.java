package string.regex.formatter;

public class RegexBuilder {
	private static StringBuilder regex;
	
	private RegexBuilder() {}
	
	public static RegexBuilder builder() {
		regex = new StringBuilder();
		return new RegexBuilder();
	}
	/**
	 * Add a "." to the regex
	 * @return this RegexBuilder
	 */
	public RegexBuilder matchAnySingleCharacter() {
		regex.append(".");
		return this;
	}
	
	/**
	 * Add {1,number} to the regex
	 * @param number
	 * @return this RegexBuilder
	 */
	public RegexBuilder matchItFromOneToNumberTimes(Integer number) {
		regex.append("{1,").append(number).append("}");
		return this;
	}
	
	/**
	 * Add a "$" to the regex
	 * @return this RegexBuilder
	 */
	public RegexBuilder matchEndOfInput() {
		regex.append("$");
		return this;
	}
	
	/**
	 * Add a "\\s" to the regex
	 * @return this RegexBuilder
	 */
	public RegexBuilder matchWhiteSpace() {
		regex.append("\\s");
		return this;
	}
	
	/**
	 * Add a "|" (pipe) to the regex
	 * @return this RegexBuilder
	 */
	public RegexBuilder addOrCondition() {
		regex.append("|");
		return this;
	}
	
	/**
	 * Add a "*" to the regex
	 * @return this RegexBuilder
	 */
	public RegexBuilder matchZeroOrMoreTimes() {
		regex.append("*");
		return this;
	}
	
	/**
	 * Add a "\\n" to the regex
	 * @return
	 */
	public RegexBuilder matchNewLine() {
		regex.append("\\n");
		return this;
	}
	
	/**
	 * Matches the exactly given expression
	 * @param expression
	 * @return
	 */
	public RegexBuilder matchExpression(String expression) {
		regex.append(expression);
		return this;
	}
	
	/**
	 * Add a "\\uhhhh" to the regex
	 * @return this RegexBuilder
	 */
	public RegexBuilder matchCharacterWithHexadecimalCode(String hhhh) {
		regex.append("\\u").append(hhhh);
		return this;
	}
	
	/**
	 * Enable multiline mode with "(?m)" expression
	 * @return
	 */
	public RegexBuilder enableEmbeddedMultilineMode() {
		regex.append("(?m)");
		return this;
	}
	
	/**
	 * Matches 'word' only if 'word' is NOT followed by 'cannotHaveIt'.
	 * @param word
	 * @param cannotHaveIt
	 * @return
	 */
	public RegexBuilder createNegativeLookahead(String word, String cannotHaveIt) {
		regex.append(word).append("(?!").append(cannotHaveIt).append(")");
		return this;
	}
	
	/**
	 * Matches 'word' only if 'word' is followed by 'haveToHave'.
	 * @param word
	 * @param haveToHaveIt
	 * @return
	 */
	public RegexBuilder createLookahead(String word, String haveToHaveIt) {
		regex.append(word).append("(?=").append(haveToHaveIt).append(")");
		return this;
	}
	
	/**
	 * Return the String (regex) builded
	 * @return a String with all the regular expression builded
	 */
	public String build() {
		return regex.toString();
	}
}
