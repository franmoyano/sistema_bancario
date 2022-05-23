package utn.cursojava.sistemabancario.exceptions;

public class MenorACeroException extends Exception {

    public MenorACeroException() {
        super("¡¡El numero ingresado debe ser mayor a cero!!");
    }

}
