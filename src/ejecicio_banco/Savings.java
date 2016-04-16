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
public class Savings extends Account{
    
    public Date dueDate;
    public double taxPercentage;

    public Savings(Date dueDate, double taxPercentage, int accountNumber, String clientName, double balance) {
        super(accountNumber, clientName, balance);
        this.dueDate = dueDate;
        this.taxPercentage = taxPercentage;
    }
    @Override
    public void consultData(){
        System.out.println("\nFecha de vencimiento: " + this.dueDate.toString() + "\n Porcentaje de interes: " + this.taxPercentage);
    }
    
    public void consignTaxes(double taxesToConsign){
        int appropriateTaxes ;
        int taxesToConsignInt = (int) taxesToConsign;
        appropriateTaxes = (int)(this.balance*this.taxPercentage)/100;
        if(taxesToConsignInt == appropriateTaxes)
                    this.consign(taxesToConsign);
        else
            System.out.println("El dinero a consignar no corresponde con los intereses que hay que consignar, por favor, ingrese el valor adecuado");
    }
    public void retireSavings(Date actualDate)
    {
        if(actualDate.equals(this.dueDate) == true){
            System.out.println("Se ha retirado: " + this.balance);
            this.balance=0;
        }
        else
            System.out.println("Error al retirar el dinero, la fecha no coincide.");
    }
    

    
}
