import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) {
       // System.out.println("Hello world!");
        
        Sample s = new Sample(3,4);
        //copy constructor called 
        Sample s2 = new Sample(s);
        
         System.out.println(s2.getLength());
         System.out.println(s2.getBreadth());
    }
}

class Sample{
    
    private int length;
    private int  breadth;
    
    public Sample(int x, int y){
        this.length = x ;
        this.breadth = y;
    }
    
    //copy constructor
    public Sample (Sample s){
        this.length = s.length ;
        this.breadth = s.breadth;
    }
    
    public int  getLength(){
        return this.length;
    }
    
    public int  getBreadth(){
        return this.breadth;
    }
}
