package marinalucentini;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import marinalucentini.dao.eventoDao;
import marinalucentini.entities.Evento;
import marinalucentini.entities.tipoEvento;
import marinalucentini.exception.eventoException;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        eventoDao event = new eventoDao(em);
        Evento evento1 = new Evento("Canzoni e parole fuori dal coro", LocalDate.of(2020, 06, 15), "Musica", tipoEvento.PUBBLICO, 150);
        Evento evento2 = new Evento("Le pagine della nostra vita", LocalDate.of(2024, 06, 15), "Teatro", tipoEvento.PRIVATO, 250);
        Evento evento3 = new Evento("Prova della provaa", LocalDate.of(2024, 07, 25), "Teatro", tipoEvento.PUBBLICO, 250);

        event.save(evento1);
        event.save(evento2);
        event.save(evento3);

        try {
            Evento eventoTrovato = event.findById(302);
            System.out.println("L'evento cercato è " + eventoTrovato.getTitolo());
        } catch (eventoException ex) {
            System.err.println(ex.getMessage());
        }
        try {
            event.findAndRemovedById(303);
            System.out.println("L'evento è stato cancellato");
        } catch (eventoException ex) {
            System.err.println(ex.getMessage());
        }
        System.out.println("Funziona!");

    }

}
