import java.util.Scanner;

/*
 * Implement class to transform decimal value to hexadecimal equivalent.
 */
class DecToHex {

	// Hexadecimal 'alphabet'
	final char hexVals[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

	/*
	 * Return hexadecimal String representation of given decimal integer.
	 */
	public String toHex(int value) {
		int remainder;
		StringBuilder hexValue = new StringBuilder();
		while (value > 0) {
			remainder = value % 16; // hex is base 16
			hexValue.append(hexVals[remainder]);
			value /= 16;
		}
		return hexValue.reverse().toString();
	}

	public static void main(String[] args) {
		DecToHex Tester = new DecToHex();

		Scanner input = new Scanner(System.in);
		System.out.print("Enter a decimal number : ");
		int decimal = input.nextInt();
		String hexDec = Tester.toHex(decimal);
		System.out.println(decimal + " -> Converting to hex! -> " + hexDec);
	}

}
