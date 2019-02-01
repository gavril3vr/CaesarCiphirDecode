import java.util.Scanner;

public class DecodeCaesarCipher {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the encoded message : ");
        String cipherText = input.nextLine();
        System.out.println("Decoding... ");

        char[] mostPresent = {'e', 't', 'h'};
        char[] alphabet = {'a', 'b', 'c', 'd', 'f', 'g', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p'     // - e,t,h
                , 'q', 'r', 's', 'u', 'v', 'w', 'x', 'y', 'z'};
        int difference = 0;

        cipherText = cipherText.toLowerCase();
        System.out.println(" ----------------------------- ");
        System.out.println("Most common letter in the text is : " + mostCommonLetter(cipherText));
        System.out.println(" ----------------------------- ");
        for (int i = 0; i < mostPresent.length; i++) {
            difference = (-1) * ((int) ((char) (mostCommonLetter(cipherText))) - (int) mostPresent[i]);
            System.out.println(shiftLetters(cipherText, difference));
        }

        System.out.println();
        System.out.print("Do you to continue Y/N: ");
        String answer = input.nextLine();
        System.out.println();

        switch (answer) {
            case "Y":
            case "y":
                System.out.println(" ----------------------------- ");
                System.out.println("The other 23 versions of the text ");
                System.out.println(" ----------------------------- ");
                for (int i = 0; i < alphabet.length; i++) {
                    difference = (-1) * ((int) ((char) (mostCommonLetter(cipherText))) - (int) alphabet[i]);
                    System.out.print(i + 1 + ". ");
                    System.out.println(shiftLetters(cipherText, difference));

                }
                break;
            case "N":
            case "n":
                System.out.println("Have a nice day !");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice !");
                break;
        }
        System.out.println();
        System.out.println("My brain is only a receiver, in the Universe there is a core from which we obtain " +
                "knowledge, strength and inspiration.");
    }

    public static String shiftLetters(String text, int diff) {

        text = text.trim().toLowerCase();
        String encodedText = "";
        char[] arrLetters = text.toCharArray();

        for (int i = 0; i < text.length(); i++) {
            //a = 97 <=> z = 122    space = 32     dot[.] = 46  ASCII
            if (arrLetters[i] >= 'a' && arrLetters[i] <= 'z') {
                arrLetters[i] = (char) (arrLetters[i] - diff);
                if (arrLetters[i] < 'a') {
                    arrLetters[i] = (char) (arrLetters[i] + 'z' - 'a' + 1);
                } else if (arrLetters[i] > 'z') {
                    arrLetters[i] = (char) (arrLetters[i] + 'a' - 'z' - 1);
                }
            }
            encodedText += arrLetters[i];
        }
        return encodedText;
    }

    public static char mostCommonLetter(String text) {
        text = text.trim().toLowerCase();
        char[] arrLetters = text.toCharArray();
        char result = 0;
        int value = 0;

        int[] arrayOne = new int[128];
        int maxOccurring = 0;

        for (int i = 0; i < arrLetters.length; i++) {
            if (arrLetters[i] != ' ') {      // ignoring space
                value = (int) arrLetters[i];
                arrayOne[value]++;
                if (arrayOne[value] > maxOccurring) {
                    maxOccurring = arrayOne[value];
                }
            }
        }
        for (int k = 0; k < arrayOne.length; k++) {
            if (maxOccurring == arrayOne[k]) {
                result = (char) k;
            }
        }
        return result;
    }
}
