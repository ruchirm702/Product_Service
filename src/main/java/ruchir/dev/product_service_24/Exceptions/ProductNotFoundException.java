package ruchir.dev.product_service_24.Exceptions;


// Custom exception for when a product is not found
public class ProductNotFoundException extends Exception{

    // Constructor that accepts a message for the exception
    public ProductNotFoundException(String message){
        super(message);
    }
}
