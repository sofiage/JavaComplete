package org.thread;

import java.util.concurrent.ConcurrentLinkedQueue;

public class FestivalMain {
    public static void main(String[] args) {

        ConcurrentLinkedQueue<People> attendeeQueue = new ConcurrentLinkedQueue<>();
        Gate gate = new Gate("Gate 1", GateStatus.NOT_EMPTY, attendeeQueue);


        for(int i = 0; i <= 50; i++){
            TicketType randowmTicketType = TicketType.generateRandomTicketType();
            People person = new People(randowmTicketType);
            gate.processPerson(person);
            System.out.println(person.getClass().getSimpleName() + " with ticket type " + person.getTicketType() + " was added");


            synchronized (gate){
                gate.notify();
            }
            FestivalAttendeeThread attendeeThread = new FestivalAttendeeThread(gate, person);
            attendeeThread.start();
            System.out.println(attendeeThread.getClass().getSimpleName());
        }

        FestivalStatisticsThread statisticsThread = new FestivalStatisticsThread(gate, true);
        statisticsThread.start();
        System.out.println(statisticsThread.getClass().getSimpleName());
        gate.getAttendeeCount();
        System.out.println(gate);


    }
}
