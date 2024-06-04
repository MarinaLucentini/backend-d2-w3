package marinalucentini.entities;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import marinalucentini.dao.eventoDao;

import java.time.LocalDate;
import java.util.Scanner;


public class CreazioneEvento {
    public static void avvioApplicazione(EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        eventoDao event = new eventoDao(em);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Premi 1 per creare un evento, 2 per cercare l'evento, 3 per elminare l'evento");
        int menuRisposta = Integer.parseInt(scanner.nextLine());

        switch (menuRisposta) {
            case 1: {
                System.out.println("Dimmi il nome dell'evento che vuoi creare");
                String title = scanner.nextLine();
                System.out.println("La data dell'evento? ");
                LocalDate date = LocalDate.parse(scanner.nextLine());
                System.out.println("Descivi l'evento");
                String description = scanner.nextLine();
                System.out.println("Digita 1 se l'evento è pubblico, 2 se l'evento è privato");
                int type = Integer.parseInt(scanner.nextLine());
                tipoEvento tipoEvento = marinalucentini.entities.tipoEvento.PUBBLICO;
                if (type == 1) {
                    tipoEvento = marinalucentini.entities.tipoEvento.PUBBLICO;
                } else if (type == 2) {
                    tipoEvento = marinalucentini.entities.tipoEvento.PRIVATO;
                }
                System.out.println("Numero massimo di partecipanti?");
                int maxUsers = Integer.parseInt(scanner.nextLine());
                Evento evento = new Evento(title, date, description, tipoEvento, maxUsers);
                event.save(evento);
                break;
            }
            case 2: {
                System.out.println("Dimmi l'id dell'evento da cercare");
                long id = Long.parseLong(scanner.nextLine());
                event.findById(id);
                break;
            }
            case 3: {
                System.out.println("Dimmi l'id dell'evento da cancellare");
                long id = Long.parseLong(scanner.nextLine());
                event.findAndRemovedById(id);
                break;
            }
            default: {

                break;
            }

        }
        scanner.close();
        em.close();
    }
}
