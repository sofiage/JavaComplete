package org.thread;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.ConcurrentLinkedQueue;

@AllArgsConstructor
@Getter
@Setter

public class FestivalStatisticsThread extends Thread {
    private final Gate festivalGate;
    private boolean running = true;


    public void run() {
        while (running) {
            try {
                int sleepTime = 1+ (int) (Math.random() * 3000);
                Thread.sleep(sleepTime);

                synchronized (festivalGate) {

                    if (!festivalGate.getAttendeeQueue().isEmpty()) {
                        generateStatistics();
                    }
                }
                if(festivalGate.getAttendeeCount() > 100){
                    running = false;
                }
            } catch (InterruptedException e) {
                System.out.println("Thread is interrupted");
                e.printStackTrace();
            }

        }
    }

    public void stopThread(){
        running = false;
    }
    public void generateStatistics() {
        synchronized (festivalGate) {

            ConcurrentLinkedQueue<People> attendeeQueue = festivalGate.getAttendeeQueue();

            int totalAttendees = 0;
            int fullTicketType = 0;
            int fullVipTicketType = 0;
            int freePassTicketType = 0;
            int oneDayTicketType = 0;
            int oneDayVipTicketType = 0;

            for (People person : attendeeQueue) {
                totalAttendees++;


                TicketType ticketType = person.getTicketType();
                switch (ticketType) {
                    case FULL:
                        fullTicketType++;
                        break;
                    case FULL_VIP:
                        fullVipTicketType++;
                        break;
                    case FREE_PASS:
                        freePassTicketType++;
                        break;
                    case ONE_DAY:
                        oneDayTicketType++;
                        break;
                    case ONE_DAY_VIP:
                        oneDayVipTicketType++;
                        break;
                }
            }

            System.out.println("Gate: " + festivalGate.getGateId());
            System.out.println("Gate status: " + festivalGate.getGateStatus());
            System.out.println("Total Attendees: " + totalAttendees);
            System.out.println("Full ticket types: " + fullTicketType);
            System.out.println("Full VIP ticket types: " + fullVipTicketType);
            System.out.println("Free pass ticket types: " + freePassTicketType);
            System.out.println("One day ticket types: " + oneDayTicketType);
            System.out.println("One day VIP ticket type " + oneDayVipTicketType);


        }
    }
}



