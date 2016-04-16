/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejecicio_banco;
import java.util.*;

/**
 *
 * @author usuario
 */
public class Account {
    public int accountNumber;
    public String clientName;
    public double balance;   
    
    public Account(int accountNumber, String clientName, double balance) {
    this.accountNumber = accountNumber;
    this.clientName = clientName;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }       
           
    public void consultData(){
        System.out.println("Nombre del cliente: " + this.clientName + "\nNumero de cuenta: " + this.accountNumber + "\nSaldo" + this.balance);
    }
    public void consign(double moneyToConsign){
        this.balance += moneyToConsign;
    }
    public void retire(double moneyToRetire){
        this.balance-= moneyToRetire;
    }
    
    
}
