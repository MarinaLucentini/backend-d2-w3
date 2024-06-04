package marinalucentini.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "evento")

public class Evento {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "title")
    private String titolo;
    @Column(name = "date")
    private LocalDate dataevento;
    @Column(name = "description")
    private String descrizione;
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private tipoEvento tipoEvento;
    @Column(name = "maxusers")
    private int numeroMassimoPartecipanti;

    public Evento() {

    }

    public Evento(String titolo, LocalDate dataevento, String descrizione, marinalucentini.entities.tipoEvento tipoEvento, int numeroMassimoPartecipanti) {
        this.titolo = titolo;
        this.dataevento = dataevento;
        this.descrizione = descrizione;
        this.tipoEvento = tipoEvento;
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getDataevento() {
        return dataevento;
    }

    public void setDataevento(LocalDate dataevento) {
        this.dataevento = dataevento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public marinalucentini.entities.tipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(marinalucentini.entities.tipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public int getNumeroMassimoPartecipanti() {
        return numeroMassimoPartecipanti;
    }

    public void setNumeroMassimoPartecipanti(int numeroMassimoPartecipanti) {
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }

    @Override
    public String toString() {
        return "evento{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", dataevento=" + dataevento +
                ", descrizione='" + descrizione + '\'' +
                ", tipoEvento=" + tipoEvento +
                ", numeroMassimoPartecipanti=" + numeroMassimoPartecipanti +
                '}';
    }
}
