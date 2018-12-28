package pl.edu.wat.wcy.isi.ai;

import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map map = new MapGenerator()
                .putCompositor("Pan")
                .putConcert("Ala ma kota")
                .putDate("11 maja 2031")
                .putPosition("10")
                .putRow("5")
                .putEmail("ala@aa.pl")
                .putPrice("20zł")
                .putDiscount("49% Student")
                .get();

        Map map1 = new MapGenerator()
                .putCompositor("Inny Pan")
                .putConcert("Calineczka")
                .putDate("11 maja 2031")
                .putPosition("10")
                .putRow("5")
                .putEmail("ala@aa.pl")
                .putPrice("30zł")
                .putDiscount("23% Uczeń")
                .get();

        TicketGenerator tg = new TicketGenerator();
        tg.generateTickets(map, map1);

        EmailClient emailClient = new EmailClient("rafalrojek96@gmail.com");
        emailClient.send();
    }
}
