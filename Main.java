import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner inpt = new Scanner(System.in);
    Bank bank = new Bank("bank");

    int option;

    while(true){
      System.out.println("----------------------------------------");
      System.out.println("Welcome to the bank");
      System.out.println("----------------------------------------");
      System.out.println("1. Access your account");
      System.out.println("2. Register an account");
      System.out.println("3. Close application");
      System.out.print("please select a number : ");

      try {
        option = inpt.nextInt();
        if(option == 1){
          System.out.print("please enter your bank number : ");
          int index = inpt.nextInt();
          
          Customer customer = bank.getCustomer(index);
          if(customer == null){
            System.out.println("Account number invalid!");
          }
          else{
            // escape enter
            inpt.nextLine();
            boolean loop = true;
            int count = 1;
            while(true){
              System.out.print("please enter password : ");
              String p = inpt.nextLine();
              if(!p.equals(customer.getPass())){
                System.out.println("Wrong password! attempt(" + count + "/3)");
                count++;
                if(count > 3){
                  break;
                }
              }
              else{
                while(loop){
                  System.out.println("----------------------------------------");
                  System.out.println("Welcome back, " + customer.getFirstName() + ' ' + customer.getLastName());
                  System.out.println("----------------------------------------");
                  System.out.println("1. Withdraw");
                  System.out.println("2. Deposit");
                  System.out.println("3. Change First Name");
                  System.out.println("4. Change Last Name");
                  System.out.println("5. Change Password");
                  System.out.println("6. Logout");
                  System.out.print("please select a number : ");
                  
                  option = inpt.nextInt();
                  
                  // escape enter
                  inpt.nextLine();
                  switch(option){
                    case 1:
                      System.out.println("you currently have $" + customer.getAccount().getBalance() + " in your account");
                      System.out.print("please enter the amount you wish to withdraw : ");
                      int amount = inpt.nextInt();
                      if(customer.getAccount().withdraw(amount)){
                        System.out.println("withdrawal successful, your current balance is $" + customer.getAccount().getBalance());
                      }
                      else{
                        System.out.println("value exceeds your current balance, or is negative!");
                      }
                      break;
                    case 2:
                      System.out.println("you currently have $" + customer.getAccount().getBalance() + " in your account");
                      System.out.print("please enter the amount you wish to deposit : ");
                      amount = inpt.nextInt();
                      if(customer.getAccount().deposit(amount)){
                        System.out.println("deposit successful, your current balance is $" + customer.getAccount().getBalance());
                      }
                      else{
                        System.out.println("value cannot be negative!");
                      }
                      break;
                    case 3:
                      System.out.print("please enter your first name : ");
                      String i = inpt.nextLine();
                      customer.setFirstName(i);
                      System.out.println("First name successfully set!");
                      break;
                    case 4:
                      System.out.print("please enter your last name : ");
                      i = inpt.nextLine();
                      customer.setLastName(i);
                      System.out.println("Last name successfully set!");
                      break;
                    case 5:
                      System.out.print("please enter your new password : ");
                      i = inpt.nextLine();
                      customer.setPass(i);
                      System.out.println("Password successfully set!");
                      break;
                    case 6:
                      loop = false;
                      break;
                    default:
                      System.out.println("please enter a valid number!");
                      break;
                  }
                }
                break;
              }
            }
          }
        }
        else if(option == 2){
          //escape enter
          inpt.nextLine();
          System.out.print("please enter your first name : ");
          String f = inpt.nextLine();
          System.out.print("please enter your last name : ");
          String l = inpt.nextLine();
          System.out.print("please enter password : ");
          String p = inpt.nextLine();
          System.out.print("please enter your initial balance : ");
          Double b = inpt.nextDouble();
  
          int index = bank.getNumOfCustomers();
          bank.addCustomer(f,l,p);
          bank.getCustomer(index).setAccount(new Account(b));
          
          System.out.println("Your account has been registered!");
          System.out.println("your account number is " + index);
        }
        else if(option == 3){
          break;
        }
        else{
          System.out.println("please enter a valid number!");
        }
      }
      catch(Exception e){
        System.out.println("Invalid input type!");
        break;
      }
      
    }
    

  }
}