import java.io.*;
import java.util.Scanner;

//Custom exception for empty input
class EmptyException extends Exception{
    public EmptyException(String s){
        super(s);
    }
}

//custom exception for checking name
class NameException extends Exception{
    public NameException(String name){
        super(name);
    }
} 

//custom exception for checking card number
class CardException extends Exception{
    public CardException(String card){
        super(card);
    }
}

//custom exception for checking pin number
class PinException extends Exception{
    public PinException(String pin){
        super(pin);
    }
}

public class PaymentGateway{

    public static String nameInput(){
        Scanner in = new Scanner(System.in);
        String name;
        System.out.println("Enter your name: ");
        name = in.nextLine();
        return name;

    }

    public static String cardInput(){
        Scanner in = new Scanner(System.in);
        String card;
        System.out.println("Enter your card number: ");
        card = in.nextLine();
        return card;
    }

    public static String pinInput(){
        Scanner in = new Scanner(System.in);
        String pin;
        System.out.println("Enter your pin number: ");
        pin = in.nextLine();
        return pin;
    }

    public static double balanceInput(){
        Scanner in = new Scanner(System.in);
        double balance;
        System.out.println("Enter your balance: ");
        balance = in.nextDouble();
        return balance;
    }

    public static double amountInput(){
        Scanner in = new Scanner(System.in);
        double amount;
        System.out.println("Enter your amount to withdraw/pay online: ");
        amount = in.nextDouble();
        return amount;
    }    

    public static void main(String args[]){

        //Welcome message and rules for entering information
        System.out.print("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n");
        System.out.print("$$$$$$$$ Welcome to PaymentGateway! $$$$$$$$\n");
        System.out.print("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n");

        System.out.print("***Please follow the instruction***\n");
        System.out.print("1.You can't keep any field empty, every field needs information to process further.\n");
        System.out.print("2.Your name should not contain any number or character.\n");
        System.out.print("3.Your credit card number must be 13 digits and only numbers are acceptable.\n");
        System.out.print("4.Pin must be 4 digits and only numbers are acceptable.\n");

        String name;
        String card;
        String pin;

        //checking if the name is valid
        while(true){
        try{
            name = nameInput();
            try{
                if(name.length()==0){
                    throw new EmptyException("Field can't be empty!");
                }
            }
            catch(EmptyException e){
                System.out.println(e.getMessage());
                continue;
            }
            
             
            char[] chars = name.toCharArray();
            for(int i=0; i<chars.length; i++){
                if(Character.isDigit(chars[i])){
                    throw new NameException("Invalid Name");
                }        
            }
            break; 
        }
        catch(NameException e){
            System.out.println(e.getMessage());
        }
        }
        System.out.println("Your name matches our records!");
        
        
        //checking if the card number is valid
        while(true){
            try{
                card = cardInput();
                try{
                    if(card.length()==0){
                        throw new EmptyException("Field can't be empty!");
                    }
                }
                catch(EmptyException e){
                    System.out.println(e.getMessage());
                    continue;
                }

                try{
                    Double.parseDouble(card);
                }
                catch(NumberFormatException e){
                    System.out.println("Numbers only! Try again\n");
                    continue;
                }
                if(card.length()!=13){
                    throw new CardException("Invalid Card number");
                }
            }
            catch(CardException e){
                System.out.println(e.getMessage());
                continue;
            }
            System.out.println("Card number matched!");  
            break;
        }

        //checking if the pin number is valid
        while(true){
            try{
                pin = pinInput();
                try{
                    if(pin.length()==0){
                        throw new EmptyException("Field can't be empty!");
                    }
                }
                catch(EmptyException e){
                    System.out.println(e.getMessage());
                    continue;
                }

                try{
                    Double.parseDouble(pin);
                }
                catch(NumberFormatException e){
                    System.out.println("Numbers only! Try again\n");
                    continue;
                }
                if(pin.length()!=4){
                    throw new PinException("Invalid pin!");
                }
            }
            catch(PinException e){
                System.out.println(e.getMessage());
                continue;
            }
            System.out.println("Pin number matched");  
            break;
        }

        //Transaction
        double balance = balanceInput();
        double amount = amountInput();

        if (balance >= amount){
            System.out.println("Your money has been successfully withdrawn/paid.");
        } 
        else{
            System.out.println("You don't have the money to complete this transaction");
        }

        System.out.println("***Information***");
        System.out.println("Card holder: " +name);
        System.out.println("Card No: " +card);

        //New balance
        if(balance > amount){
            balance = balance - amount;
            System.out.println("Your current balance is: " +balance +" tk");
        }
        else{
            System.out.println("Your current balance is " +balance+ "tk");
        }

        
    }
}
