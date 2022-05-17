class Customer {
  private String firstName;
  private String lastName;
  private String pass;
  private Account account;

  Customer(String f, String l, String p){
    this.firstName = f;
    this.lastName = l;
    this.pass = p;
  }

  public String getFirstName() {
    return this.firstName;
  }
  
  public String getLastName() {
    return this.lastName;
  }

  public String getPass() {
    return this.pass;
  }

  public void setFirstName(String f) {
    this.firstName = f;
  }

  public void setLastName(String l) {
    this.lastName = l;
  }

  public void setPass(String p) {
    this.pass = p;
  }

  public Account getAccount() {
    return this.account;
  }

  public void setAccount(Account acct) {
    this.account = acct;
  }
}