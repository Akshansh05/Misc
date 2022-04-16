import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) {
        
        Singleton x = Singleton.getInstance();
        Singleton y = Singleton.getInstance();
        
        if(x == y){
            System.out.println("Same");
        }else{
            System.out.println("Different");
        }
        
        System.out.println(x.s);
        System.out.println(y.s);

    }
}
class Singleton{
    
    public static Singleton instance =null;
    
    public String s ="";
    
    //forced to create object throuh getinstance by making private 
    private Singleton(){
        s = "Hello World";
    }
    public static Singleton getInstance(){
        
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }
}
