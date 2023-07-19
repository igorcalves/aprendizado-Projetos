package all.entities;

import all.entities.exceptions.InvalidValueException;
import all.services.validations;

public class Account {
    private Integer number;
    private String holder;
    private Double balance;
    private Double withDrawLimit;

    public Account(Integer number, String holder,Double balance, Double withDrawLimit) throws InvalidValueException {
        if (withDrawLimit < 0 || !validations.isNameValid(holder) || balance <=0) {
            throw new InvalidValueException("The value cannot be null and withDraw and balance cannot be less than 0 and the holder need a valid name");
        }
        this.balance = balance;
        this.number = number;
        this.holder = holder;
        this.withDrawLimit = withDrawLimit;
    }

    public void deposit(Double amount) throws InvalidValueException {
        if (amount > 0) {
            balance += amount;
        } else {
            throw new InvalidValueException("You cannot make a negative deposit");
        }

    }

    public void withDraw(Double amout) throws InvalidValueException {
        if(balance >0 && amout <= balance && amout<= withDrawLimit){
            balance -=amout;
            System.out.println("Withdraw has successfully!\nWithdraw value : " + amout +"\nyour updated balance: " + getBalance());
        }else{
        throw new InvalidValueException("you can't be a withdraw with: Negatives values or \nValues greater than withdraw limit "+withDrawLimit+
        " or\nValues greater than balance Your balance is "+ balance);
        }
    }

    public Integer getNumber() {
        return number;
    }

    public String getHolder() {
        return holder;
    }

    public Double getBalance() {
        return balance;
    }

    public Double getWithDrawLimit() {
        return withDrawLimit;
    }

    @Override
    public String toString(){
        return "Number: " + number
        + "\nHolder: " + holder
        + "\nInitial balance: " + balance
        + "\nWithdraw Limit: " + withDrawLimit ;
    }

}
