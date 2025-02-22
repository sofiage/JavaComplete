package org.thread;

import lombok.Getter;

import java.util.Random;
@Getter

public enum TicketType {
    FULL,
    FULL_VIP,
    FREE_PASS,
    ONE_DAY,
    ONE_DAY_VIP;

    public static TicketType generateRandomTicketType(){
        TicketType[] ticketTypes = TicketType.values(); //returns an array of all values in the Ticket Type enum
        Random random = new Random();
        return ticketTypes[random.nextInt(ticketTypes.length)];
    }
}
