package hash_0813;

public class Hash {
    
    static int hash(String message) {
        int value = 0;

        for (int i = 0; i < message.length(); i++) {
            value += message.charAt(i) * (i + 1) * (i + 1);
        }
        return value % 256;
    }

    public static void main(String[] args) {
        String[] messages = {
            "Hello",
            "World", 
            "nhn",
            "academy"
        };
        
        for(String message: messages) {
            System.out.printf("%s : %d\n", message, hash(message));
        }
    }
}
