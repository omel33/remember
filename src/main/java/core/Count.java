package core;

public class Count {
    public static void main(String[] args) {
       double pricePerItem=15.50;
       int quantity=3;
       double taxRate=0.05;

       double subtotal=pricePerItem*quantity;
       double taxAmount=subtotal*taxRate;
       double totalCost=subtotal+taxAmount;

        System.out.println("price for item : "+pricePerItem);
        System.out.println("quantity : "+quantity);
        System.out.println("Sub with out tax rate : "+subtotal);
        System.out.println("tax amount : "+taxAmount);
        System.out.println("total cost : "+totalCost);


    }
}
