package de.iav.taxdeclaration;

public class TaxTooHighException extends RuntimeException {

    TaxTooHighException(String s){
        super(s);
    }

    TaxTooHighException(){
        super();
    }

}
