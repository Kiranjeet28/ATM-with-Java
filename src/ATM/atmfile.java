package ATM;

import java.util.HashMap;
import java.util.Scanner;

public class atmfile {

    public static void main(String[] args) {
        ATMop obj = new ATMop();
        obj.op();
    }
}
class Data{
    float Balance;
}

class ATMop {
    float balance;
    Scanner scanner = new Scanner(System.in);

    HashMap<Integer , Data> map = new HashMap<>();


    public ATMop(){
        System.out.println("Welcome to our ATM");
    }

    public void check_balance(Data obj){
        System.out.println("YOur balance "+ obj.Balance);

    op();
    }
    public void deposit(Data obj){
        System.out.println("Enter your Amount");
        float a = scanner.nextFloat();
        obj.Balance += obj.Balance +a;
        System.out.println("Amount Deposited Successfully");
        op();
    }
    public void withdraw(Data obj){
        System.out.println("Enter your Amount ");
        float w = scanner.nextFloat();
        if(obj.Balance >= w ) {
            obj.Balance = obj.Balance - w;
            System.out.println("Amount Withdraw Successfully");
        }else {
            System.out.println("Low Balance ");
        }
        op();
    }

    public void op(){
        System.out.println("Enter your Pin code ");
        int pincode = scanner.nextInt();
        if (map.containsKey(pincode)){
            Data obj = map.get(pincode);
            menu(obj);
        }else{
            System.out.println("Please create amount first");
            System.out.println("Set your pin Code ");
            int pin = scanner.nextInt();
            Data obj = new Data();
            map.put(pin,obj);
            menu(obj);
        }

    }

    public void menu(Data obj) {
        System.out.println("Please enter valid number ");
        System.out.println("1  Check balance ");
        System.out.println("2 . Deposit money ");
        System.out.println("3 . Withdraw money");
        System.out.println("4. Check another account ");
        System.out.println("0. exit");

        int x = scanner.nextInt();

        if(x== 1 ){
            check_balance(obj);
        }
        else if(x == 2){
            deposit(obj);
        }
        else if (x == 3){
            withdraw(obj);
        }
        else if(x == 4){
            op();
        }
        else if ( x==0 ){
            System.out.println("Exited");
        }
        else{
            System.out.println("YOu Entered the wrong input");
            menu(obj);
        }
    }


}

