import java.util.Scanner;  // Needed for the Scanner class

public class Array2
{
  public static void main(String[] args)
  {
    // Create a Scanner object to read input.
    Scanner keyboard = new Scanner(System.in);
    
    // Declaring variables

    int [] list_of_numbers;
    int i = 0, sum = 0, num = 1;
    double average = 0, difference = 0;
    String numbers = "Number", avg = "Average", diff = "Difference";
    list_of_numbers = new int [100];
    
    // Loop to fill the list

    while (i < list_of_numbers.length)
    {
        list_of_numbers[i] = (int)(Math.random()*500) + 1;
        sum = sum + list_of_numbers[i];
        i++;
    }
    i = 0;

    // Calculations

    average = sum / list_of_numbers.length;

    // Output

    System.out.printf("\n%-10s%-10s%-10s\n", numbers, avg, diff);
    while (i < list_of_numbers.length)
    {
        System.out.printf("\n   %3d%11.2f%13.2f", list_of_numbers[i], average, (double)(difference = list_of_numbers[i] - average));
        i++;
    }
    
  }
}
