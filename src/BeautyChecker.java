class BeautyChecker {

    public static boolean isBeautiful(String text) {
        return isPalindrome(text) || isAllSameLetters(text) || isAscendingOrder(text);
    }

    private static boolean isPalindrome(String text) {
        int len = text.length();
        for (int i = 0; i < len / 2; i++) {
            if (text.charAt(i) != text.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isAllSameLetters(String text) {
        char firstChar = text.charAt(0);
        for (int i = 1; i < text.length(); i++) {
            if (text.charAt(i) != firstChar) {
                return false;
            }
        }
        return true;
    }

    private static boolean isAscendingOrder(String text) {
        for (int i = 1; i < text.length(); i++) {
            if (text.charAt(i) < text.charAt(i - 1)) {
                return false;
            }
        }
        return true;
    }
}
