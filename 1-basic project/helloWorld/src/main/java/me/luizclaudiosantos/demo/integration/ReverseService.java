package me.luizclaudiosantos.demo.integration;

public class ReverseService {

    public void reverse(String message){
         System.out.println( new StringBuilder(message).reverse());
    }
}
