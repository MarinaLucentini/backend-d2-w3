package marinalucentini;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import marinalucentini.entities.CreazioneEvento;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");

    public static void main(String[] args) {
        CreazioneEvento.avvioApplicazione(emf);

//        event.save(evento1);
//        event.save(evento2);
//        event.save(evento3);
//
//        try {
//            Evento eventoTrovato = event.findById(302);
//            System.out.println("L'evento cercato è " + eventoTrovato.getTitolo());
//        } catch (eventoException ex) {
//            System.err.println(ex.getMessage());
//        }
//        try {
//            event.findAndRemovedById(303);
//            System.out.println("L'evento è stato cancellato");
//        } catch (eventoException ex) {
//            System.err.println(ex.getMessage());
//        }
        System.out.println("Funziona!");

        emf.close();
    }


}
