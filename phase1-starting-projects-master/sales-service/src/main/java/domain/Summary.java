/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author sarataha
 */
public class Summary {
    
    private int numberOfSales;
    private double totalPayment;
    private String group;



public Summary(int numberOfSales, double totalPayment, String group ) {
this.group = group;
this.numberOfSales = numberOfSales;
this.totalPayment = totalPayment;
}

    public Summary() {
    }
 public String getGroup() {
        return group;
    }
    
    public void setGroup(String group) {
        this.group = group;
    }
    
    public int getnumberOfSales() {
        return numberOfSales;
    }
    
    public void setnumberOfSales(int numberOfSales) {
        this.numberOfSales = numberOfSales;
    }

    public double gettotalPayment() {
        return totalPayment;
    }
    
    public void settotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }
  @Override
    public String toString(){
        	return  totalPayment + numberOfSales + group;
    }

    

}