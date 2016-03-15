package string.compression;

import java.util.Scanner;

/**
 * Class to compress strings, by calculating repetitive letters and convert them to indices
 */
public class StringCompressor {

    /**
     * Creates a compressed String by calculating consecutive letters
     * @param input initial String
     * @return compressed String if it is smaller, than the input.
     */
    public static String compress(String input) {

        // Usually words don't have many the same consecutive letters,
        // that's why we chack if it makes sense to compress the word
        int maxLength = maxLength(input);
        if (input.length() <= maxLength) {
            return input;
        }

        int index = 1;

        // at this point we know the exact length of the compressed word
        StringBuilder stringBuilder = new StringBuilder(maxLength);

        for (int i = 0, n = input.length(); i < n - 1; i++) {

            if (input.charAt(i) == input.charAt(i + 1)) {
                index++;
            } else {
                stringBuilder.append(input.charAt(i));
                stringBuilder.append(index);
                index = 1;
            }
        }

        // To catch the last letter
        stringBuilder.append(input.charAt(input.length() - 1));
        stringBuilder.append(index);

        return stringBuilder.toString();

    }

    /**
     * Precalculate possible max length of the input when compressed
     * @param input to compress
     * @return length of the compressed word
     */
    public static int maxLength(String input) {
        if (input.length() == 1) {
            return 2;
        }

        int maxLength = 2;

        for (int i = 0, n = input.length(); i < n - 1; i++) {
            if (input.charAt(i) != input.charAt(i + 1)) {
                maxLength += 2;
            }
        }

        return maxLength;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.next();

        System.out.println("input: " + a + ", compressed: " + compress(a));
    }



}
