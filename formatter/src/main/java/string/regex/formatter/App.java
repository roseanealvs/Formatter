package string.regex.formatter;

public class App {
	private static final String DEFAULT_INPUT_TEXT = "In the beginning God created the heavens and the earth. Now the earth was formless and empty, darkness was over the surface of the deep, and the Spirit of God was hovering over the waters.\n" +
            "\n" +
            "And God said, \"Let there be light,\" and there was light. God saw that the light was good, and he separated the light from the darkness. God called the light \"day,\" and the darkness he called \"night.\" And there was evening, and there was morning - the first day.";
    private static final int DEFAULT_LIMIT = 40;
    private static final Boolean DEFAULT_JUSTIFY = true;

    public static void main(String[] args) {
        String text = DEFAULT_INPUT_TEXT;
        Integer limit = DEFAULT_LIMIT;
        Boolean justify = DEFAULT_JUSTIFY;
        
        Formatter formatter;
        
        if (justify) {
        	formatter = new JustifiedText(limit);
        } else {
        	formatter = new SimpleText(limit);
        }

        System.out.println("Output: ");
        System.out.println(formatter.format(text));
        
    }
}
