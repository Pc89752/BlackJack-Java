package BlackJack;

import java.util.Scanner;

public class Console {
    Scanner sc=new Scanner(System.in);

    public int getInt(String str) {
        while (true) {
            try {
                System.out.print(str);
                int input = sc.nextInt();
                sc.nextLine();
                return input;
            } catch (Exception e) {
                sc.nextLine();
                System.out.println("Please enter correctly");
            }
        }
    }

    public String getString(String[] strs) {
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

    public String getString() {
        return sc.nextLine();
    }

    public double getDouble(String str){
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

    public boolean getYorN() {
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
