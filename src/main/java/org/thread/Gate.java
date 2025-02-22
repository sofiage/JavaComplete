package org.thread;


import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
@Getter
@Setter


public class Gate {
    private String gateId;
    private GateStatus gateStatus;
    private ConcurrentLinkedQueue<People> attendeeQueue;

    public Gate(String gateId, GateStatus gateStatus, ConcurrentLinkedQueue<People> attendeeQueue) {
        this.gateId = gateId;
        this.gateStatus = gateStatus;
        this.attendeeQueue = attendeeQueue;
    }

    public synchronized void processPerson(People person) {
        if (attendeeQueue.size()<1000){
            attendeeQueue.offer(person);
            System.out.println("Processing the person ticket: " + person.getTicketType());
            updateGateStatus();
        } else {
            System.out.println("Queue is full");
        }
    }

        private void updateGateStatus(){
        if (attendeeQueue.isEmpty()) {
            gateStatus = GateStatus.EMPTY;
        } else if (attendeeQueue.size() > 100) {
            gateStatus = GateStatus.FULL;
        } else {
            gateStatus = GateStatus.NOT_EMPTY;
        }
    }

    public int getAttendeeCount(){
        return attendeeQueue.size();
    }

    @Override
    public String toString() {
        return "Gate{" +
                "gateId='" + gateId + '\'' +
                ", gateStatus=" + gateStatus +
                ", people=" + attendeeQueue +
                '}';
    }
}

