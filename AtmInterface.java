package java_project1;
import java.io.*;
import java.util.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
public class AtmInterface{
    String name,userID, password, act_no;
    float bal=0f;
    int trans=0;
    String transHis="";
    Scanner sc=new Scanner(System.in);
    DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    LocalDateTime now =LocalDateTime.now();
    public void register(){
        System.out.println("\nEnter username :");
        this.userID=sc.nextLine();
        System.out.println("Enter Password:");
        this.password=sc.nextLine();
        System.out.println("Enter account number:");
        this.act_no=sc.nextLine();
        System.out.println(" Your Registration completed Successfully!!");
        System.out.println("login to your account!!");
    }
    public boolean login(){
        boolean isLogin=false;
        while(!isLogin){
            System.out.println("\nEnter username : ");
            String usr=sc.nextLine();
            if (usr.equals(userID)){
                System.out.println("Enter Password : ");
                String pd=sc.nextLine();
                while(!isLogin){
                    if(pd.equals(password)){
                        System.out.println("Logged-in Successfully!!");
                        isLogin=true;
                    }
                    else{
                        System.out.println("login is invalid!!!");
                        break;
                    }
                }
            }
            else{
                System.out.println("Username not found!!Enter valid username...");
            }
        }
        return isLogin;
    }
    public void deposit(){
        System.out.println("\nEnter amount to deposit : ");
        float damount=sc.nextFloat();
        try{
            if(damount<=100000f){
                bal+=damount;
                trans+=1;
                System.out.println("Amount deposited Rs. "+damount+" at "+dtf.format(now));
                String s="Rs "+damount+" deposited at "+dtf.format(now)+" .\n";
                transHis=transHis.concat(s);
            }
            else{
                System.out.println("Sorry!Can't deposit more than one lakh");
            }
        }
        catch(Exception e){
        }
    }
    public void withdraw(){
        System.out.println("\nEnter amount to withdraw : ");
        float wamount=sc.nextFloat();
        try{
            if (wamount<=bal){
                bal-=wamount;
                trans+=1;
                System.out.println("Amount withdrawn Rs. "+wamount+" at "+dtf.format(now));
                String s="Rs "+wamount+" withdrawn at "+dtf.format(now)+" .\n";
                transHis=transHis.concat(s);
            }
            else{
                System.out.println("Sorry!Can't withdraw.Insufficient amount to withdraw..");
            }
        }
        catch(Exception e){
        }
    }
    public void transfer(){
    	Scanner in=new Scanner(System.in);
        System.out.println("\nEnter the username you want to transfer : ");
        String uname=in.nextLine();
        System.out.println("Enter the amount to transfer:");
        float tamount=sc.nextFloat();
        try{
            if (tamount<=bal){
                bal-=tamount;
                trans+=1;
                System.out.println("Amount transferred Rs. "+tamount+" at "+dtf.format(now));
                String s="Rs "+tamount+" transferred to "+uname+" account at "+dtf.format(now)+" .\n";
                transHis=transHis.concat(s);
            }
            else{
                System.out.println("Sorry!Can't transfer.Insufficient amount to transfer..");
            }
        }   
        catch(Exception e){
        }
    }
    public void transHistory(){
        if(trans==0){
            System.out.println("\nNo Transactions!!");
        }
        else{
            System.out.println("\n"+transHis);
        }
    }
    public void checkBal(){
        System.out.println("\nBalance amount is : "+bal);
    }
    public static void main(String args[]){
        System.out.println("WELCOME TO ATM!!!");
        System.out.println("Select any one option!");
        System.out.println("1.REGISTER\n2.EXIT");
        System.out.println("Enter your option :");
        Scanner sc=new Scanner(System.in);
        int ch;
        ch=sc.nextInt();
        if (ch==1){
            AtmInterface ac=new AtmInterface();
            ac.register();
            while(ch==1){
                System.out.println("\nSelect any one option!");
                System.out.println("1.LOGIN\n2.EXIT");
                System.out.println("Enter your option :");
                int op=sc.nextInt();
                if (op==1){
                    if(ac.login()){
                        boolean isFin=false;
                        while(!isFin){
                            System.out.println("\nSelect any option : ");
                            System.out.println("1.DEPOSIT\n2.WITHDRAW\n3.TRANSFER\n4.TRANSACTION HISTORY\n5.CHECK BALANCE\n6.EXIT");
                            System.out.println("Enter your option :");
                            int c=sc.nextInt();
                            switch(c){
                                case 1 : ac.deposit();
                                         break;
                                case 2 : ac.withdraw();
                                         break;
                                case 3 : ac.transfer();
                                         break;
                                case 4 : ac.transHistory();
                                         break;
                                case 5 : ac.checkBal();
                                         break;
                                case 6 : isFin=true;
                                         break;
                                default: System.out.println("option is Invalid!!!");
                            }
                        }
                    }
                }
                else{
                    System.exit(0);
                }
            }
        }
        else{
            System.exit(0);
        }
    }
}