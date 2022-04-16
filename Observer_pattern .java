import java.util.*;
import java.lang.*;
import java.io.*;

interface Subject{
    public void registerObserver(Observer observer);
    public void unregisterObserver(Observer observer);
    public void notifyObservers();
}


class CricketData implements Subject{
    int runs;
    double overs;
    int wickets;
    List<Observer> observerList = new ArrayList<Observer>();
    
    @Override
    public void registerObserver(Observer o){
        observerList.add(o);
    }
    
     @Override
    public void unregisterObserver(Observer o){
        observerList.remove(o);
    }
    
     @Override
    public void notifyObservers(){
        
       for(Observer o : observerList){
           o.update(runs,overs,wickets);
       }
    }
    
    private int getLatestRuns(){
        return 90;
    }
    
    private int getLatestWickets(){
       return 2;
    }
    private double getLatestOvers(){
        return 10.2;
    }
    public void dataChanged(){
        
        runs = getLatestRuns();
        overs = getLatestOvers();
        wickets = getLatestWickets();
        notifyObservers();
    }
}
    interface Observer{
        public void update(int runs ,double overs ,int wickets);
    }
    
    class AverageScoreDisplay implements Observer{
        private double runRate;
        private int predictedScore;
        
        @Override
        public void update (int runs, double overs ,int wickets){
            this.runRate = (double) runs/overs;
            this.predictedScore = (int)(this.runRate *50);
            display();
        }
        public void display(){
            System.out.println("Run rate is:"+ runRate);
            System.out.println("Predicted Score is:"+ predictedScore);
            System.out.println();
        }
    }
    
     class CurrentScoreDisplay implements Observer{
        private double overs;
        private int runs;
        private int wickets;
        
         @Override
        public void update (int runs, double overs ,int wickets){
            this.overs = overs;
            this.runs = runs;
            this.wickets = wickets; 
            display();
        }
        public void display(){
            System.out.println("Current Over is :"+ overs);
            System.out.println("Current Runs is:"+ runs);
            System.out.println("Current Wickets is:"+ wickets);
            System.out.println();
        }
    }
    
    // The main method must be in a class named "Main".
    class Main {
        public static void main(String[] args) {
          AverageScoreDisplay averageScoreDisplay = new AverageScoreDisplay();
       
         CurrentScoreDisplay currentScoreDisplay = new CurrentScoreDisplay();
       
         CricketData cricketData = new CricketData();
         
          cricketData.registerObserver(averageScoreDisplay);
          cricketData.registerObserver(currentScoreDisplay);
          cricketData.dataChanged();
          
          cricketData.unregisterObserver(currentScoreDisplay);
          cricketData.dataChanged();
       
    }

}
