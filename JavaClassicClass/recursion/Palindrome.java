public class Palindrome {
    static boolean isPalindrome1(String message){
        if(message.length() <= 1) {
            return true;
        }
        if(message.charAt(0) == message.charAt(message.length()-1)) {
            return false;
        }
        return isPalindrome1(message.substring(1, message.length()-1));
    }

    static boolean isPalindrome(String msg) {
        return isPalindrome1(msg.substring(0, msg.length()-1));
    }

    static boolean isPalindrome(String msg, int i1, int i2) {
        if(i1 >= i2) {
            return true;
        }
        if(msg.charAt(i1) != msg.charAt(i2)) {
            return false;
        }
        return isPalindrome(msg, i1+1, i2 -1);
    }

    public static void main(String[] args) {
        String text = "abba";
        System.out.printf("%s is palindrome: %s%n", text, isPalindrome(text));
    }
}
