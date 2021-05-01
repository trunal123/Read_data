import java.util.Scanner;

public class EvenOdd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number :");
        int num = scanner.nextInt();
        findOddEven(num);

    }

    public static void findOddEven(int num) {
        if (num % 2 == 0)

            System.out.println("number is Even");
        else
            System.out.println("number is Odd");

    }
}
