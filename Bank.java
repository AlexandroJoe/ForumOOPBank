import java.util.ArrayList;

class Bank {
  private ArrayList<Customer> customers = new ArrayList<Customer>();
  private int numberOfCustomers = 0;
  private String bankName;

  Bank(String bName){
    this.bankName = bName;
  }

  public void addCustomer(String f, String l, String p){
    customers.add(new Customer(f,l,p));
    this.numberOfCustomers++;
  }

  public int getNumOfCustomers(){
    return this.numberOfCustomers;
  }

  public Customer getCustomer(int index){
    if(this.numberOfCustomers >= index){
      return customers.get(index);
    }
    else{
      return null;
    }
  }
}