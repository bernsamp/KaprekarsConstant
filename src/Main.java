import java.util.*;

public class Main {

    /* More info: https://en.wikipedia.org/wiki/6174_(number)

    6174 is known as Kaprekar's constant[1][2][3] after the Indian mathematician D. R. Kaprekar. This number is renowned for the following rule:

    Take any four-digit number, using at least two different digits (leading zeros are allowed).
    Arrange the digits in descending and then in ascending order to get two four-digit numbers, adding leading zeros if necessary.
    Subtract the smaller number from the bigger number.
    Go back to step 2 and repeat.

     */
    public static int KaprekarsConstant(int number) {

        final int kaprekarsConstant = 6174;

        int difference = 0;

        int count = 0;

        while (difference != kaprekarsConstant) {

            String s1 = String.valueOf(number);

            char[] ch1 = new char[s1.length()];
            for (int i = 0; i < ch1.length; i++) {
                ch1[i] = s1.charAt(i);
            }
            Arrays.sort(ch1);
            String s2 = new String(ch1);

            StringBuilder s3 = new StringBuilder();
            for (int j = s2.length() -1; j >= 0; j--) {
                s3.append(s2.charAt(j));
            }

            int a = Integer.parseInt(s2);
            int b = Integer.parseInt(s3.toString());

            System.out.println("Operand in descending order: " + b);
            System.out.println("Operand in ascending order: " + a);

            if (a > b) {
                difference = a - b;
                System.out.println("Difference is: " + difference + "\n");
            } else if (b > a) {
                difference = b - a;
                System.out.println("Difference is: " + difference + "\n");
            } else {
                System.out.println("Kaprekar's constant can't be reached");
                break;
            }
            count++;
            number = difference;

        }
        return count;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a four-digit number, using at least two different digits (leading zeros are allowed):");

        int userInput = sc.nextInt();

        System.out.print("The number of operations needed to reach the Kaprekar's Constant is: " + KaprekarsConstant(userInput));
    }

}