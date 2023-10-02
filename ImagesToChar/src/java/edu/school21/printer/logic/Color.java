package edu.school21.printer.logic;

public class Color {
    public static final Color WHITE = new Color(255, 255, 255);
    public static final Color BLACK = new Color(0, 0, 0);
    public static final Color RED = new Color(255, 0, 0);
    public static final Color GREEN = new Color(0, 255, 0);
    public static final Color BLUE = new Color(0, 0, 255);
    public static final Color CYAN = new Color(0, 255, 255);
    public static final Color MAGENTA = new Color(255, 0, 255);
    public static final Color YELLOW = new Color(255, 255, 0);


    private static final int RMASK = 0x00ff0000;
    private static final int GMASK = 0x0000ff00;
    private static final int BMASK = 0x000000ff;
    private static final int OFFSET = 8;

    public int r;
    public int g;
    public int b;
    
    public Color(int rgb) {
        r = (rgb & RMASK) >> 2*OFFSET;
        g = (rgb & GMASK) >> OFFSET;
        b = rgb & BMASK;
    }

    public Color(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public static Color fromBits(int rgb) {
        return new Color(rgb);
    }

    public boolean equals(Color other) {
        return r == other.r && g == other.g && b == other.b;
    }
}
