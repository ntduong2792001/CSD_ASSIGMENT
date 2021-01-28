/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.Scanner;

/**
 *
 * @author GHC
 */
public class CheckInput {
    private static Scanner sc = new Scanner(System.in);
    
    public static String enterCode(){
        String code = null;
        while (true) {
            code = sc.nextLine();
            if (code.equals("")) {
                System.out.print("Enter again: ");
            } else {
                return code;
            }
        }
    }
    
    public static String enterName(){
        String name = null;
        while (true) {
            name = sc.nextLine();;
            if (name.equals("")) {
                System.out.print("Enter again: ");
            } else {
                return name;
            }
        }
    }
    
    public static int enterQuantity(){
        int quantity = 0;
        while (true) {
            try {
                quantity = Integer.parseInt(sc.nextLine());
                if (quantity <= 0) {
                    System.out.println("Number of book must be > 0");
                    System.out.print("Enter again: ");
                } else {
                    return quantity;
                }
            } catch (Exception e) {
                System.out.println("Enter digit number > 0");
            }
        }
    }
    
    public static int enterLended(int quantity){
        int lended = 0;
        while (true) {
            try {
                lended = Integer.parseInt(sc.nextLine());
                if (lended < 0 || lended > quantity) {
                    System.out.println("Number of lended book must be >= 0");
                    System.out.print("Enter again: ");
                } else {
                    return lended;
                }
            } catch (Exception e) {
                System.out.println("Enter digit number >= 0");
            }
        }
    }
    
    public static double enterPrice(){
        double price = 0;
        while (true) {
            try {
                price = Double.parseDouble(sc.nextLine());
                if (price <= 0) {
                    System.out.println("Price of book must be > 0");
                    System.out.print("Enter again: ");
                } else {
                    return price;
                }
            } catch (Exception e) {
                System.out.println("Enter digit number > 0");
            }
        }
    }

    public static int enterIndex() {
        int index = -1;
        while (true) {
            try {
                index = Integer.parseInt(sc.nextLine());
                if (index < 0) {
                    System.out.println("Index must be >= 0");
                    System.out.print("Enter again: ");
                } else {
                    return index;
                }
            } catch (Exception e) {
                System.out.println("Enter digit number >= 0");
            }
        }
                
    }

    public static int enterByear() {
        int byear = 0;
        while (true) {
            try {
                byear = Integer.parseInt(sc.nextLine());
                if (byear < 1900 || byear > 2010) {
                    System.out.println("BYear must be in range(1900 - 2010)");
                    System.out.print("Enter again: ");
                } else {
                    return byear;
                }
            } catch (Exception e) {
                System.out.println("Enter digit number >= 0");
            }
        }
    }
}
