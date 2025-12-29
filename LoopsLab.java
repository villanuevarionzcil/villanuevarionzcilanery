import java.util.Scanner;

public class LoopsLab {

    // Activity 1: Multiplication Table Generator (for loop)
    public static void multiplicationTable(Scanner sc) {
        System.out.print("Enter a number for multiplication table: ");
        int num = sc.nextInt();
        System.out.println("Multiplication Table of " + num + ":");
        for (int i = 1; i <= 10; i++) {
            System.out.println(num + " x " + i + " = " + (num * i));
        }
        System.out.println();
    }

    // Activity 2: Sum of Natural Numbers (while loop)
    public static void sumOfNaturalNumbers(Scanner sc) {
        System.out.print("Enter a number to calculate sum of natural numbers: ");
        int n = sc.nextInt();
        int sum = 0;
        int i = 1;
        while (i <= n) {
            sum += i;
            i++;
        }
        System.out.println("Sum = " + sum);
        System.out.println();
    }

    // Activity 3: Factorial Calculator (do-while loop)
    public static void factorialCalculator(Scanner sc) {
        System.out.print("Enter a number to calculate factorial: ");
        int n = sc.nextInt();
        int factorial = 1;
        int i = 1;
        do {
            factorial *= i;
            i++;
        } while (i <= n);
        System.out.println("Factorial = " + factorial);
        System.out.println();
    }

    // Activity 4: Even and Odd Numbers (for loop)
    public static void evenAndOddNumbers(Scanner sc) {
        System.out.print("Enter a number to display even and odd numbers: ");
        int n = sc.nextInt();
        System.out.print("Even numbers: ");
        for (int i = 2; i <= n; i += 2) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.print("Odd numbers: ");
        for (int i = 1; i <= n; i += 2) {
            System.out.print(i + " ");
        }
        System.out.println("\n");
    }

    // Activity 5: Reverse Digits of a Number (while loop)
    public static void reverseDigits(Scanner sc) {
        System.out.print("Enter a number to reverse: ");
        int num = sc.nextInt();
        int reversed = 0;
        int temp = num;
        while (temp != 0) {
            int digit = temp % 10;
            reversed = reversed * 10 + digit;
            temp /= 10;
        }
        System.out.println("Reversed: " + reversed);
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Call all activities
        multiplicationTable(sc);
        sumOfNaturalNumbers(sc);
        factorialCalculator(sc);
        evenAndOddNumbers(sc);
        reverseDigits(sc);

        sc.close();
    }
}
