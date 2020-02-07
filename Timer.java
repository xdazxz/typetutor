import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 


public class Timer implements Runnable {
  
  private  int x = 90;//ENTER NUMBER OF SECONDS YOU WANT HERE 
  private  int minutes = x/60;
  private  int seconds = x-(minutes*60);
  private  boolean run = true;
  private TypingViewTemplate view;
  private  int startSeconds =0; 
  private  int startMinutes=0;
  private int secondsPassed=0;
  public Timer(TypingViewTemplate pc)
  {
    this.view = pc;
  }
  public Timer()
  {
    
  }
    
   
  public  void runTimerDecreasing() throws InterruptedException
  {
    
    while(run==true) {
      if (seconds<10)
      {
        ////System.out.println(minutes+":0"+ seconds);
        
        this.view.updateTimer();
        
      }
      else
      {
        ////System.out.println(minutes+":"+ seconds);
        this.view.updateTimer();
        
      }
      
      
      Thread.sleep(1000);
      secondsPassed++;
      seconds=seconds-1;
      if (seconds==0)
      {
        
        ////System.out.println(minutes+":00");
        this.view.updateTimer();
        Thread.sleep(1000);
        secondsPassed++;
        
        minutes = minutes-1;
        if (seconds== 0 &&minutes== -1)
        {
          break;
          
          
          
        }
        seconds = 59;
        
      }
      
    }
  }
  
  public   void stopTimerDecreasing()
  {
    run=false;
    if (seconds<10)
    {
      ////System.out.println(minutes+":0"+ seconds);
      this.view.updateTimer();
      
      
    }
    else
    {
      ////System.out.println(minutes+":"+ seconds);
      this.view.updateTimer();
      
    }
    
    
    
    
  }
  
  public   void resetTimerDecreasing()
  {
    stopTimerDecreasing();
    minutes = x/60;
    seconds = x-(minutes*60);
    if (seconds<10)
    {
      ////System.out.println("0"+minutes+":0"+seconds);
      this.view.updateTimer();
    }
    else 
    {
      ////System.out.println("0"+minutes+":"+seconds);
      this.view.updateTimer();
    }
    
    
    
  }
  
  
  
  
  
  public   void runTimerIncreasing() throws InterruptedException
  {
    while(startMinutes<minutes)
    {
      if (startMinutes==minutes && startSeconds==seconds)
      {
        break;
        
      }
      
      else if (startSeconds<10)
      {
        ////System.out.println("0"+startMinutes+":0"+startSeconds);
        
        
      }
      else
      {
        ////System.out.println("0"+startMinutes+":"+startSeconds);
        
        
      }
      Thread.sleep(1000);
      secondsPassed++;
      startSeconds = startSeconds+1;
      
      
      
      if (startSeconds==60)
      {
        startMinutes =startMinutes+1;
        ////System.out.println("0"+startMinutes+":00");
        startSeconds =0;
        Thread.sleep(1000);
        secondsPassed++;
        
      }
    }
    
    
  }
  
  public   void stopTimerIncreasing()
  {
    startMinutes = minutes;
    
    
  }
  
  public   void resetTimerIncreasing()
  {
    stopTimerIncreasing();
    startSeconds = 0;
    startMinutes =0;
    ////System.out.println("00:00");
    
  }
  
 public void run()
 {
   try
   {
    runTimerDecreasing();
   }
   catch(Exception ex)
   {
     
   }
  }
  public   String getCurrentTime()
  {
    
    if (seconds<10)
      {
        return (minutes+":0"+ seconds);
        
      
        
      }
      else
      {
        return(minutes+":"+ seconds);
    
        
      }
  }
  public int getSecondsPassed()
  {
    return secondsPassed;
  }
}