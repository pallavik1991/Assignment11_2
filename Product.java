package com.example.akaash.assignment11_2;

/**
 * Created by AKAASH on 22-11-2017.
 */

public class Product
{
    String pname;

    Product(){}
    Product(String pname)
    {
        this.pname=pname;
    }
    public void setPname(String pname)
    {
        this.pname=pname;
    }
    public String getPname()
    {
        return this.pname;
    }
}
