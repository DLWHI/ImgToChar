package edu.school21.printer.logic;

import com.beust.jcommander.IStringConverter;
import com.beust.jcommander.ParameterException;
import com.diogonunes.jcolor.Attribute;

public class ColorAttributeConverter implements IStringConverter<Attribute> {
    @Override
    public Attribute convert(String value) {
        if (value.equals("WHITE")) {
            return Attribute.WHITE_BACK();
        } else if (value.equals("BLACK")) {
            return Attribute.BLACK_BACK();
        } else if (value.equals("YELLOW")) {
            return Attribute.YELLOW_BACK();
        } else if (value.equals("MAGENTA")) {
            return Attribute.MAGENTA_BACK();
        } else if (value.equals("BLUE")) {
            return Attribute.BLUE_BACK();
        } else if (value.equals("GREEN")) {
            return Attribute.GREEN_BACK();
        } else if (value.equals("CYAN")) {
            return Attribute.CYAN_BACK();
        } else if (value.equals("RED")) {
            return Attribute.RED_BACK();
        }
        throw new ParameterException("Unknown parameter value");
    }
}
