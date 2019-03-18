import java.util.ArrayList;

/**
 * Stores an ArrayList of predetermined strings in an ArrayList and saves all
 * palindromes in another
 */
class CodingChallenge {

    /**
     * Returns boolean value; Checking if String parameter is a palindrome
     */
    public static boolean isPalindore(String text) {
        String reverse = ""; // initialize local variables - empty string
        int len = text.length();
        // /System.out.println(len);

        for (int i = len - 1; i >= 0; i--) {
            reverse = reverse + text.charAt(i);

        }
        // If the reveresed string's value matches that of the parameter
        if (text.equals(reverse))
            return true;
        else
            return false;
    }

    /**
     * Returns String parameters as an ArrayList
     */
    public static ArrayList<String> toArrayList(String... strings) {
        ArrayList<String> stringarray = new ArrayList<String>();
        for (String item : strings) {
            stringarray.add(item);
        }
        return stringarray;
    }

    public static void main(String args[]) {
        String string1 = "karan";
        String string2 = "madam";
        String string3 = "tom";
        String string4 = "civic";
        String string5 = "radar";
        String string6 = "sexes";
        String string7 = "jimmy";
        String string8 = "kayak";
        String string9 = "john";
        String string10 = "refer";
        String string11 = "billy";
        String string12 = "did";

        // Store predetermined strings in an ArrayList
        ArrayList<String> stringArray = toArrayList(string1, string2, string3, string4, string5, string6, string7,
                string8, string9, string10, string11, string12);
        // System.out.println(stringarray);

        // Save all palindromes in another ArrayList
        ArrayList<String> palindromeArray = new ArrayList<String>();
        for (String item : stringArray) {
            //System.out.println(item);
            if (isPalindore(item) == true) {
                palindromeArray.add(item);
            }
        }

        System.out.println("Our ArrayList of predefined Strings is: " + stringArray);
        System.out.println("Our ArrayList of palindromes from the above is: " + palindromeArray);

    }
}