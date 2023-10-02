package edu.school21.printer.logic;

import java.util.LinkedList;

public class FileSignature implements Comparable<FileSignature> {
    private byte[] bytes;
    private String type;

    public FileSignature(String name, LinkedList<Byte> signature) {
        type = name;
        bytes = new byte[signature.size()];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = signature.get(i);
        }
    }

    public int compareTo(FileSignature other) {
        if (other.bytes.length - bytes.length != 0) {
            return other.bytes.length - bytes.length;
        } else {
            return 1;
        }
    }

    public String getTypeName() {
        return type;
    }

    public int getLength() {
        return bytes.length;
    }

    public boolean matches(byte[] other) {
        int cap = (other.length < bytes.length) ? other.length : bytes.length;
        for (int i = 0; i < cap; i++) {
            if (other[i] != bytes[i]) {
                return false;
            }
        }
        return true;
    }
}
