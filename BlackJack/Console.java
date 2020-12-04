package BlackJack;

import java.util.Scanner;

public class Console {
    static Scanner sc=new Scanner(System.in);

    public static int getInt() {
        while (true) {
            try {
                int input = sc.nextInt();
                sc.nextLine();
                return input;
            } catch (Exception e) {
                sc.nextLine();
                System.out.println("Please enter correctly");
            }
        }
    }

    public static String getString(String[] strs) {
        while (true) {
            String input = sc.nextLine().toUpperCase();
            for (String string : strs) {
                if(input.equals(string)){
                    return input;
                }
            }
            System.out.println("Please enter correctly");
        }
    }

    public static String getString() {
        return sc.nextLine();
    }

    public static double getDouble(String str){
        while (true) {
            try {
                System.out.print(str);
                double input = sc.nextDouble();
                sc.nextLine();
                return input;
            } catch (Exception e) {
                sc.nextLine();
                System.out.println("Please enter correctly");
            }
        }
    }

    public static boolean getYorN() {
        while (true) {
            switch (getString().toUpperCase()) {
                case "Y":
                    return true;
                case "N":
                    return false;
                default:
                    System.out.println("Please enter correctly");
            }
        }
    }
}
