package com.saepul.data;

public class Product {

    private int id;
    private String productName;
    private int quantity;
    private int price;

    Product(int id, String productName, int qty, int price) {
        this.id = id;
        this.productName = productName;
        this.quantity = qty;
        this.price = price;
    }

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String name) {
        this.productName = name;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int qty){
        this.quantity = qty;
    }

    public int getPrice(){
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
