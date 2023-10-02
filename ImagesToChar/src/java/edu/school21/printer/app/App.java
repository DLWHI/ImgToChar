package edu.school21.printer.app;

import com.beust.jcommander.Parameter;
import com.diogonunes.jcolor.Attribute;
import com.beust.jcommander.ParameterException;
import com.beust.jcommander.Parameters;

import edu.school21.printer.logic.ColorAttributeConverter;
import edu.school21.printer.logic.ImageToChar;

@Parameters(separators = "=")
public class App {
    private ImageToChar service = new ImageToChar();

    @Parameter(names = {"--white", "-w"}, converter = ColorAttributeConverter.class)
    private Attribute whiteCol;

    @Parameter(names = {"--black", "-b"}, converter = ColorAttributeConverter.class)
    private Attribute blackCol;

    public void exec() {
        try {
            service.draw("/resources/it.bmp", whiteCol, blackCol);
        } catch (ParameterException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Dies of cringe");
            e.printStackTrace();
        }
    }
}
