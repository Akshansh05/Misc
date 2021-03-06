import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) {
       // System.out.println("Hello world!");
        
        SingletonNotThreadSafe x = SingletonNotThreadSafe.getInstance();
        
        SingletonNotThreadSafe y = SingletonNotThreadSafe.getInstance();
        
         if(x==y){
             System.out.println("Same");
         }else{
             System.out.println("Different");
         }
    }
}
 ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
    
    class SingletonNotThreadSafe {
        
        private static SingletonNotThreadSafe singletonObj = null;
        
        private SingletonNotThreadSafe(){
            
        }
        
        public static SingletonNotThreadSafe getInstance(){
                //lazy instantiation
            if(singletonObj == null){
                singletonObj = new SingletonNotThreadSafe();
            }
            return singletonObj;
        }
        
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  
    class SingletonThreadSafeButSlow{
       
        private static SingletonThreadSafeButSlow singletonObj = null;
        
        private SingletonThreadSafeButSlow(){
            
        }
        
        //add synchronized 
        public static synchronized SingletonThreadSafeButSlow getInstance(){
                
            if(singletonObj == null){
                singletonObj = new SingletonThreadSafeButSlow();
            }
            return singletonObj;
        }
       
   }
 
 ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////  
 
  class SingletonThreadSafeEagerInstantiation{
       
       //eagerly created the object and using that 
      //since the singletonObj is static, it is given value at class creation and thus is thread safe 
         private static SingletonThreadSafeEagerInstantiation singletonObj = new SingletonThreadSafeEagerInstantiation();;
        
        private SingletonThreadSafeEagerInstantiation(){
            
        }
        
        public static SingletonThreadSafeEagerInstantiation getInstance(){
            return singletonObj;
        }
       
   }
   
   ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
     
       //best
     class SingletonthreadSafeAndFast{
       
       //made volatile to keep it thread safe and read data from main memory and not shared memory
       private static volatile SingletonthreadSafeAndFast singletonObj = null;
       
        private SingletonthreadSafeAndFast(){
            
        }
        
        private static SingletonthreadSafeAndFast getInstance(){
            
            if(singletonObj == null){
                
                //did to keep it same for any thread for the 1st time for the rest time value will directly be returned 
                synchronized(SingletonthreadSafeAndFast.class){
                    
                    // check again as multiple threads
                   // can reach above step
                    if(singletonObj == null){
                        singletonObj = new SingletonthreadSafeAndFast();
                    }
                }
            }
            
            return singletonObj;
        }
       
   }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/* Some facts
1. Singleton property can be broken in 3 below ways 
    a. Reflection property of constructors can be avoided by using enums
    b. Serialization of Singleton instance can be avoided by using below
    protected Object readResolve()
    {
        return instance;
    }
    c. cloning of Singleton instance can be avoided using overriding clone function refer- https://www.geeksforgeeks.org/prevent-singleton-pattern-reflection-serialization-cloning/?ref=lbp
    
    */
