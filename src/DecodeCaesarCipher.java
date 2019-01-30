public class DecodeCaesarCipher {
    public static void main(String[] args) {

        String cipherText = "H svun aptl hnv pu h nhshef mhy, mhy hdhf....";
        System.out.println(mostCommonLetter(cipherText));

        char[] mostPresent = {'e', 't', 'h'};
        int difference = 0;
        cipherText = cipherText.toLowerCase();

        System.out.println(" ----------------------------- ");
        System.out.println("Most common letter in the text is : " + mostCommonLetter(cipherText));
        System.out.println(" ----------------------------- ");
        for (int i = 0; i < mostPresent.length; i++) {
            difference = (-1) * ((int) ((char) (mostCommonLetter(cipherText))) - (int) mostPresent[i]);
            System.out.println(shiftLetters(cipherText, difference));
            //System.out.print(difference);
        }

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
                // System.out.print(result + " ");
            }
        }
        return result;
    }
}
