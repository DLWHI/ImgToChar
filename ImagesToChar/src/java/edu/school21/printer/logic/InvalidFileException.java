package edu.school21.printer.logic;

public class InvalidFileException extends RuntimeException {
    public InvalidFileException() {
        super("Provided invalid file to draw");
    }
}
