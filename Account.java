class Account {
  private double balance;

  Account(double initBalance){
    this.balance = initBalance;
  }

  public double getBalance(){
    return this.balance;
  }

  public boolean deposit(double amt){
    if(amt <= 0){
      return false;
    }
    else{
      this.balance += amt;
      return true;
    }
  }

  public boolean withdraw(double amt){
    double value = this.balance - amt;
    if(value < 0 || amt < 0){
      return false;
    }
    else{
      this.balance -= amt;
      return true;
    }
  }
}