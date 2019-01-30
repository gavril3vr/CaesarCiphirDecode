public class DecodeCaesarCipher {
    public static void main(String[] args) {

        String cipherText = "H svun aptl hnv pu h nhshef mhy, mhy hdhf....";
        System.out.println(mostCommonLetter(cipherText));

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
