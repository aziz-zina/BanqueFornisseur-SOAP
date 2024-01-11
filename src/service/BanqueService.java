package service;
import java.util.Date;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import classes.compte;

@WebService(serviceName="banqueService")
public class BanqueService {
	private compte compte;
	
	public BanqueService(){
    	 this.compte= new compte(30.5f, new Date(), 2);
    	 System.out.println("Account object created with credit: " + compte.getSolde());
     }
     
    @WebMethod(operationName="conversion")
 	public double conversion(@WebParam double mont)
 	{
    	 System.out.println("Received amount: " + mont);
    	    double result = mont * 3.5;
    	    System.out.println("Result: " + result);
 		    return result;
 	}
 	@WebMethod(operationName="withdraw")
 	public double retirer(@WebParam double mont) {
 	    double currentSolde = this.compte.getSolde();
 	    double newSolde = currentSolde - mont;
 	    System.out.println("Current credit: " + currentSolde);
 	    System.out.println("Money to withdraw: " + mont);
 	    System.out.println("New Solde: " + newSolde);

 	    if (newSolde < 0) {
 	        System.out.println("Insufficient funds. Withdrawal not allowed.");
 	       
 	    } else {
 	        this.compte.setSolde(newSolde); 
 	    }

 	    return newSolde;
 	}
 	@WebMethod
 	public double verser( @WebParam double mont)
 	{   
 		double newSolde=this.compte.getSolde()+mont;
 		this.compte.setSolde(newSolde);

 		return newSolde;
 	}
 	@WebMethod
 	public double getCurrentSolde() {
 		return this.compte.getSolde();
 	}
 
}