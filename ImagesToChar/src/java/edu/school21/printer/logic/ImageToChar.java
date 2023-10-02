package edu.school21.printer.logic;

import javax.imageio.ImageIO;

import com.diogonunes.jcolor.Ansi;
import com.diogonunes.jcolor.Attribute;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.awt.image.BufferedImage;

public class ImageToChar {
    private static final String targetImgType = "BMP";

    private SignatureAnalyzer verificator = new SignatureAnalyzer();

    public ImageToChar() {
        verificator.addSignature(targetImgType, "42 4D");
    }

    public void draw(String path, Attribute whiteCol, Attribute blackCol)
            throws FileNotFoundException, InvalidFileException, IOException, URISyntaxException {
        try (InputStream reader = getClass().getResourceAsStream(path)) {
            if (!verificator.getFileType(reader).equals(targetImgType)) {
                throw new InvalidFileException();
            }
        }
        BufferedImage image = ImageIO.read(getClass().getResource(path));
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                if (Color.fromBits(image.getRGB(x, y)).equals(Color.WHITE)) {
                    System.out.printf(Ansi.colorize(" ", whiteCol));
                } else {
                    System.out.printf(Ansi.colorize(" ", blackCol));
                }
            }
            System.out.println("");
        }
    }
}
