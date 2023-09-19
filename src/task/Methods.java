package task;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Methods {
    private static final String CURRENCY = "UAH";
    static double discount1;
    static double discount2;
    static double discount3;


    public static void main(String[] args) {
//загальна сума до сплати
        double calcResult = calcIncome();

        //дисконт
        discount1 = 0.05;
        discount2 = 0.1;
        discount3 = 0.15;

        information(calcResult);
    }

    private static double calcIncome() {
        double totalCoust = 0;

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of your goods:");
        int i = sc.nextInt();
        double[] price = new double[i];
        Scanner scPr = new Scanner(System.in);
        for (double pr : price) {
            System.out.println("Enter price of your purchase: ");
            pr = scPr.nextDouble();
            totalCoust += pr;
        }
        return totalCoust;
    }


    private static void information(double calcResValue) {

        System.out.println("Total coust: " + calcResValue + " " + CURRENCY);

        double discRes1 = roundCost(total(calcResValue, discount1));
        double discRes2 = roundCost(total(calcResValue, discount2));
        double discRes3 = roundCost(total(calcResValue, discount3));

        if (calcResValue <= 5000) {
            System.out.println("Your discount is: " + discount1 +
                    "\nYou have to pay: " + discRes1 + " " + CURRENCY);
        } else if (calcResValue > 5000 & calcResValue <= 10000) {
            System.out.println("Your discount is: " + discount2 +
                    "\nYou have to pay: " + discRes2 + " " + CURRENCY);
        } else {
            System.out.println("Your discount is: " + discount3 +
                    "\nYou have to pay: " + discRes3 + " " + CURRENCY);
        }
    }

    private static double total(double calculatedValue, double discValue) {
        return calculatedValue * discValue;
    }

    public static double roundCost(double value) {
        return new BigDecimal(value).setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
    }
}
