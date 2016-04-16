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
public class Check extends Account{
    
    public double commissionForUse;
    public double commissionChecksWithoutFounds;

    public Check(double commissionForUse, double commissionChecksWithoutFounds, int accountNumber, String clientName, double balance) {
        super(accountNumber, clientName, balance);
        this.commissionForUse = commissionForUse;
        this.commissionChecksWithoutFounds = commissionChecksWithoutFounds;
    }
    
        @Override
    public void consultData(){
        System.out.println("\nComision por uso: " + this.commissionForUse + "\n Comision por emision de cheques sin saldo " + this.commissionChecksWithoutFounds);
    }
    public void issueCheck(double money)
    {
        if(money>this.balance)
        {
            System.out.println("No hay suficientes fondos, se descontara la comision apropiada");
            this.balance-=this.commissionChecksWithoutFounds;
        }
        else
        {
            System.out.println("El cheque fue emitido.");
            this.balance-=money;
        }
    }
}
