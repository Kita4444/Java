import java.util.Scanner;

public class java1 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Welcome back");
        int y = myPow(2, 3);
        System.out.println(y);

        System.out.println(isEven(7));
        System.out.println(isPrime(17));
    }

    private static int myPow(int base, int exponent) 
    {
        int answer = 1; 
        for (int i = 1; i <= exponent; i++) {
            answer *= base;
        }
        return answer;
    }

    private static boolean isEven(int x) 
    {
        return x % 2 == 0;
    }

    private static boolean isPrime(int x) 
    {
        if (x <= 1) {
            return false;
        }
        
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                return false;
            }
        }

        return true;
    }
}
