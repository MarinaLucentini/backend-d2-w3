package marinalucentini.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import marinalucentini.entities.Evento;
import marinalucentini.exception.eventoException;

public class eventoDao {
    private final EntityManager em;

    public eventoDao(EntityManager em) {
        this.em = em;
    }

    public void save(Evento evento) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(evento);
        transaction.commit();
        System.out.println("L'evento" + evento.getTitolo() + "è stato aggiunto con successo");
    }

    public Evento findById(long id) {
        Evento evento = em.find(Evento.class, id);
        if (evento == null) throw new eventoException(id);
        return evento;
    }

    public void findAndRemovedById(long id) {
        Evento found = this.findById(id);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("L'evento " + found.getTitolo() + "è stato eliminato");
    }
}
