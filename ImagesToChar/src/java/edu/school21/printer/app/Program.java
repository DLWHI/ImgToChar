package edu.school21.printer.app;

import com.beust.jcommander.JCommander;

public class Program {


    public static void main(String[] args) {
        App app = new App();
        JCommander.newBuilder()
            .addObject(app)
            .build()
            .parse(args);
        app.exec();
    }
}
