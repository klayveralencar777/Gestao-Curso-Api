package alencar.klayver.api_curso.exceptions;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String message){
        super(message);
    }
}
