package marinalucentini.exception;

public class eventoException extends RuntimeException {
    public eventoException(Long id) {

        super("L'evento con id " + id + " non è stato trovato");
    }
}
