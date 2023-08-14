import java.util.Scanner;  // Needed for the Scanner class

public class Array3
{
  public static void main(String[] args)
  {
    // Create a Scanner object to read input.
    Scanner keyboard = new Scanner(System.in);

    // Declaring variables

    int [] dice1, dice2, sum, summa;
    double [] probability;
    dice1 = new int [200];
    dice2 = new int [200];
    summa = new int [200];
    sum = new int [13];
    probability = new double [13];
    
    int i = 0, p = 2;
    String numbers = "Roll Number", dice_1 = "Dice1", dice_2 = "Dice2", summary = "Sum", probab = "Probability", repetition = "Repetitions"; //first line output
    
    // Input

    while (i < dice1.length)
    {
        dice1[i] = (int)(Math.random()*6 + 1);
        dice2[i] = (int)(Math.random()*6 + 1);
        summa[i] = dice1[i] + dice2[i];
        sum[dice1[i] + dice2[i]]++;
        i++;
    }
    i = 0;

    // Fill the probability list

    while (p < sum.length)
    {
        probability[p] = ((double)sum[p]) / 2.0;
        i++;
        p++;
    }
    i = 0;

    // Output

    System.out.printf("\n %-15s%-13s%-13s%-10s\n", numbers, dice_1, dice_2, summary);
    p = 1;
    while (i < dice1.length)
    {
        System.out.printf("\n   %3d%13d%13d%13d", p, dice1[i], dice2[i], summa[i]);
        i++;
        p++;
    }
    
    // Output the table

    System.out.printf("\n\n %-6s%-14s%-10s\n", summary, repetition, probab);
    p = 2;
    i = 0;
    
    while (p < sum.length)
    {
        System.out.printf("\n%3d%11d%14.2f%s", p, sum[p], probability[p],"%");
        i++;
        p++;
    }
    
  }

}