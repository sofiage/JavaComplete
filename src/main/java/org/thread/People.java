package org.thread;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor

public class People {
    private TicketType ticketType;

    @Override
    public String toString() {
        return "People{" +
                "ticketType=" + ticketType +
                '}';
    }

}
