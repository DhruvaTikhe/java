import java.io.*;
import java.util.*;

// User-defined Exceptions
class AmountMinimumException extends Exception
{
    AmountMinimumException(String msg){
        super(msg); //call Exception class's constructor
    }
}

class BadCustIdException extends Exception
{
    BadCustIdException(String msg){
        super(msg);
    }
}

class BalanceTooLowException extends Exception
{
    BalanceTooLowException(String msg){
        super(msg);
    }
}

class AmountTooLowException extends Exception
{
    AmountTooLowException(String msg){
        super(msg);
    }
}

class BankingSystem
{
    int cid;
    String cname;
    double amount;

    static Scanner sc = new Scanner(System.in);

    void createAccount()
    {
        try
        {
            System.out.print("Enter Customer ID: ");
            cid = sc.nextInt();

            if (cid < 1 || cid > 20)
                throw new BadCustIdException("Range of Cust ID is 1 to 20 only");

            System.out.print("Enter Customer Name: ");
            cname = sc.next();

            System.out.print("Enter Amount: ");
            amount = sc.nextDouble();

            if (amount <= 0)
                throw new AmountTooLowException("Amount cannot be 0 or negative");

            if (amount < 1000)
                throw new AmountMinimumException("Minimum balance is Rs.1000.");

            FileWriter fw = new FileWriter("bank.txt", true);   //creates new file if doesnt exsits
            fw.write(cid + " " + cname + " " + amount + "\n");
            fw.close();

            System.out.println("Customer Account has been created");
            // System.out.println("Customer Account has been created"+cid); //debug: why cid showing blank?
        }
        catch (Exception e)
        {
            System.out.println("Exception occured: " + e.getMessage()); //pickup the first one which happens
        }
    }

    void withdraw()
    {
        try
        {
            System.out.print("Enter Amount to Withdrwa: ");
            double withdraw_amount = sc.nextDouble();

            if (withdraw_amount <= 0)
                throw new AmountTooLowException("Amount must be positive.");    //use same one as created before

            if (withdraw_amount > amount)
                throw new BalanceTooLowException("Withdrawal exceeds balance.");  

            amount = amount - withdraw_amount;

            System.out.println("Withdrawal Done");
            System.out.println("Your Remaining Balance is now: "+amount);
        }
        catch (Exception e)
        {
            System.out.println("Error: " + e.getMessage());
        }
        // finally{
        //     System.out.println("Withdraw function ran");
        // }
    }

    void displayRecords()
    {
        try
        {
            String filename = "bank.txt";
            // String filename = "bank11111.txt"; //check if file not found works
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr); //takes filereader object. check google

            String line;
            System.out.println("\n=== Customer Records ===");

            while ((line = br.readLine()) != null)  //non empty rows
                System.out.println(line);
            
            br.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Specified file not found");
        }
        catch (IOException e)
        {
            System.out.println("Cannot read file");
        }
    }

    public static void main(String[] args)
    {
        BankingSystem bankingsys = new BankingSystem();
        int ch;
        do
        {
            System.out.println("\n==--BANKING SYSTEM USING JAVA--==");
            System.out.println("1. Create Account");
            System.out.println("2. Withdraw");
            System.out.println("3. Display Records");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            ch = sc.nextInt();
            switch (ch)
            {
                case 1:
                    bankingsys.createAccount();
                    break;
                case 2:
                    bankingsys.withdraw();
                    break;
                case 3:
                    bankingsys.displayRecords();
                    break;
                case 4:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Wrong choice");
            }
        }
        while (ch != 4);
    }
}