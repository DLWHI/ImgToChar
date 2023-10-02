package edu.school21.printer.logic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class SignatureAnalyzer {
    private SortedSet<FileSignature> types;

    public SignatureAnalyzer() {
        types = new TreeSet<FileSignature>();
    }

    public SignatureAnalyzer(String sigFile)
            throws FileNotFoundException, InputMismatchException {
        types = new TreeSet<FileSignature>();
        try (Scanner mapParser = new Scanner(new FileInputStream(sigFile))) {
            mapParser.useDelimiter(", |\n");
            while (mapParser.hasNext()) {
                types.add(new FileSignature(
                        mapParser.next(),
                        parseBytes(mapParser.next())));
            }
        }
    }

    public SignatureAnalyzer addSignature(String name, String signatureStr) {
        types.add(new FileSignature(
                name,
                parseBytes(signatureStr)));  
        return this;
    }

    private LinkedList<Byte> parseBytes(String byteStr) {
        LinkedList<Byte> bytes = new LinkedList<Byte>();
        try (Scanner stream = new Scanner(byteStr)) {
            while(stream.hasNextInt(16)) {
                bytes.add((byte)stream.nextInt(16));
            }
        }
        return bytes;
    }

    public String getFileType(String path) 
            throws FileNotFoundException, IOException {
        try (FileInputStream targetFile = new FileInputStream(path)) {
            byte[] firstBytes = new byte[types.first().getLength()];
            targetFile.read(firstBytes);
            for (FileSignature signature : types) {
                if (signature.matches(firstBytes)) {
                    return signature.getTypeName();
                }
            }
        }
        return "";
    }

    public String getFileType(InputStream stream) 
            throws IOException {
        byte[] firstBytes = new byte[types.first().getLength()];
        stream.read(firstBytes);
        for (FileSignature signature : types) {
            if (signature.matches(firstBytes)) {
                return signature.getTypeName();
            }
        }
        return "";
    }
}