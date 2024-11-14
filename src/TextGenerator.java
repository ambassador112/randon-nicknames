import java.util.Random;

class TextGenerator {
    private static final String LETTERS = "abc";
    private static final int TEXT_COUNT = 100_000;

    public static String generateText(int length) {
        Random random = new Random();
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < length; i++) {
            text.append(LETTERS.charAt(random.nextInt(LETTERS.length())));
        }
        return text.toString();
    }

    public static String[] generateTexts() {
        Random random = new Random();
        String[] texts = new String[TEXT_COUNT];
        for (int i = 0; i < TEXT_COUNT; i++) {
            texts[i] = generateText(3 + random.nextInt(3));
        }
        return texts;
    }
}
