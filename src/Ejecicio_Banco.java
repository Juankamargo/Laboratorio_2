/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejecicio_banco;
import java.util.*;
import java.text.*;
/**
 *
 * @author usuario
 */
public class Ejecicio_Banco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.util.Scanner read = new java.util.Scanner(System.in);
        HashMap<String, Account> accounts = new HashMap<>();
        while(true)
        {
            System.out.println("Ingrese la accion que quiera realizar: \n1.Crear Cuenta\n2.Consignar\n3.Retirar\n4.Consultar datos de cuenta.\nCuenta de ahorros:\t5.Consignar intereses\t6.Retirar dinero\nCheques:\t7.Expedir cheque"); 
            int option = read.nextInt();
            switch(option)
            {
                case 1:
                    System.out.println("1.Cuenta de ahorros\t2.Cheques");
                    int option1 = read.nextInt();
                    switch(option1)
                    {
                        case 1:
                            SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");

                            System.out.println("Ingrese fecha de vencimiento:\t dd/MM/yyyy ");
                            String dueDateStr = read.next();
                            try {
                            Date dueDate = dateformat.parse(dueDateStr);
                            System.out.println("Inserte porcentaje de interes:\t "); double taxPercentage = read.nextDouble();
                            if(taxPercentage<=100&&taxPercentage>=0)
                            {
                            System.out.println("Inserte numero de cuenta:\t "); int accountNumber = read.nextInt();
                            System.out.println("Inserte nombre del cliente:\t "); String clientName = read.next();
                            System.out.println("Inserte nuevo saldo:\t "); double balance = read.nextDouble();
                            Savings newAccount = new Savings(dueDate,taxPercentage,accountNumber,clientName,balance);
                            accounts.put(clientName,newAccount);
                            }
                            else
                                    System.out.println("El valor debe estar entre 0 y 100");
                            }catch (ParseException |InputMismatchException a) {System.out.println(" Formato incorrecto.");}
                            break;
                        case 2:
                            System.out.println("Inserte comision por uso:\t "); double commissionForUse = read.nextDouble();
                            System.out.println("Inserte comision por emitir cheques sin fondo:\t "); double commissionChecksWithoutFounds = read.nextDouble();
                            System.out.println("Inserte numero de cuenta:\t "); int accountNumber = read.nextInt();
                            System.out.println("Inserte nombre del cliente:\t "); String clientName = read.next();
                            System.out.println("Inserte nuevo saldo:\t "); double balance = read.nextDouble();
                            Check newAccount = new Check(commissionForUse,commissionChecksWithoutFounds,accountNumber,clientName,balance);
                            accounts.put(clientName,newAccount); 
                            break;
                    }
                    break;
                case 2:

                    System.out.println("Ingrese nombre del dueño de la cuenta:  "); String nameToSearch = read.next();
                    Account tmpAccount = accounts.get(nameToSearch);
                    if (tmpAccount != null)
                    {
                        System.out.println("Ingrese dinero a consignar"); double moneyToConsign = read.nextDouble(); tmpAccount.consign(moneyToConsign);
                        System.out.println("Nuevo saldo:    " + tmpAccount.balance);
                    }
                    else
                        System.out.println("El nombre no esta registrado");
                    break;
                case 3:
                    System.out.println("Ingrese nombre del dueño de la cuenta:  "); nameToSearch = read.next();
                    tmpAccount = accounts.get(nameToSearch);
                    if (tmpAccount != null)
                    {
                        System.out.println("Ingrese dinero a retirar"); double moneyToRetire = read.nextDouble(); tmpAccount.retire(moneyToRetire);
                        System.out.println("Nuevo saldo:    " + tmpAccount.balance);
                    }
                    else
                        System.out.println("El nombre no esta registrado");
                    break;
                case 4:
                    System.out.println("Ingrese nombre del dueño de la cuenta:  "); nameToSearch = read.next();
                    tmpAccount = accounts.get(nameToSearch);
                    if (tmpAccount != null)
                    {
                        tmpAccount.consultData();
                    }
                    else
                        System.out.println("El nombre no esta registrado");
                    break;
                case 5:
                    System.out.println("Ingrese nombre del dueño de la cuenta:  "); nameToSearch = read.next();
                    Savings tmpSavings = (Savings) accounts.get(nameToSearch);
                    if (tmpSavings != null)
                    {
                        System.out.println("Ingrese intereses a consignar");
                        double taxesToConsign = read.nextDouble();
                        tmpSavings.consignTaxes(taxesToConsign);
                    }
                    else
                        System.out.println("El nombre no esta registrado");
                    break;
                case 6:
                    System.out.println("Ingrese nombre del dueño de la cuenta:  "); nameToSearch = read.next();
                     tmpSavings = (Savings) accounts.get(nameToSearch);
                    if (tmpSavings != null)
                    {
                        System.out.println("Ingrese fecha actual:\nAño(Solo ultimos dos digitos):\t");int year = read.nextInt(); 
                        System.out.println("Mes:\t "); int month = read.nextInt();
                        System.out.println("Dia:\t "); int day = read.nextInt();
                        Date actualDate = new Date(year,month,day);
                        tmpSavings.retireSavings(actualDate);
                    }
                    else
                        System.out.println("El nombre no esta registrado");
                    break;
                case 7:
                    System.out.println("Ingrese nombre del dueño de la cuenta:  "); nameToSearch = read.next();
                     Check tmpCheck = (Check) accounts.get(nameToSearch);
                    if (tmpCheck != null)
                    {
                        System.out.println("Ingrese el valor del cheque:    ");double money = read.nextDouble();
                        tmpCheck.issueCheck(money);
                        System.out.println("Nuevo saldo:    " + tmpCheck.balance);
                    }
                    else
                        System.out.println("El nombre no esta registrado");
                    break;   
        }

        }

        
    }
}
