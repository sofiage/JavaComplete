package org.thread;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class FestivalAttendeeThread extends Thread{
    private Gate gate;
    private People person;

    @Override
    public void run(){
        try{
            int sleepTime = (int) (Math.random() * 5000);
            Thread.sleep(sleepTime);
        }catch(InterruptedException e){
            System.out.println("Thread is interrupted");
            e.printStackTrace();
        }
        gate.processPerson(person);


    }
}
