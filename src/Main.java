import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private static final AtomicInteger countLength3 = new AtomicInteger(0);
    private static final AtomicInteger countLength4 = new AtomicInteger(0);
    private static final AtomicInteger countLength5 = new AtomicInteger(0);

    public static void main(String[] args) {
        String[] texts = TextGenerator.generateTexts();

        Thread thread3 = new Thread(() -> {
            for (String text : texts) {
                if (text.length() == 3 && BeautyChecker.isBeautiful(text)) {
                    countLength3.incrementAndGet();
                }
            }
        });

        Thread thread4 = new Thread(() -> {
            for (String text : texts) {
                if (text.length() == 4 && BeautyChecker.isBeautiful(text)) {
                    countLength4.incrementAndGet();
                }
            }
        });

        Thread thread5 = new Thread(() -> {
            for (String text : texts) {
                if (text.length() == 5 && BeautyChecker.isBeautiful(text)) {
                    countLength5.incrementAndGet();
                }
            }
        });

        thread3.start();
        thread4.start();
        thread5.start();

        try {
            thread3.join();
            thread4.join();
            thread5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Красивых слов с длиной 3: " + countLength3.get() + " шт");
        System.out.println("Красивых слов с длиной 4: " + countLength4.get() + " шт");
        System.out.println("Красивых слов с длиной 5: " + countLength5.get() + " шт");
    }
}
