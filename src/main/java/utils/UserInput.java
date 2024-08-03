package utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public interface UserInput {

    static byte getChoiceInput(){

        System.out.print("Type your choice: ");

        try{
            Scanner scanner = new Scanner(System.in);
            return scanner.nextByte();
        }
        catch (InputMismatchException e){
            return -1;
        }
    }

    static double getAmountInput(){

        System.out.print("Type Amount: ");

        try{
            Scanner scanner = new Scanner(System.in);
            return scanner.nextDouble();
        }
        catch (InputMismatchException e){
            return -1;
        }
    }

    static String getStringInput(){

        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    static String getStringInput(String nameOfLabel){

        System.out.print(nameOfLabel);
        return getStringInput();
    }

}
