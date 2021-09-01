package boardgame;

public class BoardException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    //This is a ExceptionHandler. It just repasses the captured message to the super class RuntimeException. Nothing so special at all
    public BoardException(String msg){
        super(msg);
    }

}
