package nl.kb.jp2;

public class JPEG2000Image {

    public static final int HEADER_FAIL = 0;
    public static final int HEADER_SUCCESS = 1;
    private int status;
    private int width;
    private int height;
    private int tilesX;
    private int tilesY;
    private int tileW;
    private int tileH;
    private int maxReduction;
    private int numCompositions;
    private String filename;

    public JPEG2000Image(String filename, final int[] arySpex) {
        this.filename = filename;
        status = arySpex[0];
        width = arySpex[1];
        height = arySpex[2];
        tilesX = arySpex[3];
        tilesY = arySpex[4];
        tileW = arySpex[5];
        tileH = arySpex[6];
        maxReduction = arySpex[7];
        numCompositions = arySpex[8];
    }

    public boolean headerLoaded() {
        return status == HEADER_SUCCESS;
    }

    public int getTilesX() {
        return tilesX;
    }

    public int getTilesY() {
        return tilesY;
    }

    public int getNumCompositions() {
        return numCompositions;
    }

    public int getMaxReduction() {
        return maxReduction - 1;
    }

    private int reduce(int num, int reduction) {
        for(int i = 0; i < reduction; ++i) {
            num = (int) Math.ceil(((double) num) / 2.0d);
        }
        return num;
    }

    public int getWidth(int reduction) {
        return reduce(width, reduction);
    }

    public int getHeight(int reduction) {
        return reduce(height, reduction);
    }

    public int getTileW(int reduction) {
        return reduce(tileW, reduction);
    }

    public int getTileH(int reduction) {
        return reduce(tileH, reduction);
    }


    public String getFilename() {
        return filename;
    }

    @Override
    public String toString() {
        return "JPEG2000Image{" +
                "status=" + (status == HEADER_FAIL ? "HEADER_FAIL" : "HEADER_SUCCESS") +
                ", width=" + width +
                ", height=" + height +
                ", tilesX=" + tilesX +
                ", tilesY=" + tilesY +
                ", tileW=" + tileW +
                ", tileH=" + tileH +
                ", maxReduction=" + maxReduction +
                ", numCompositions=" + maxReduction +
                '}';
    }
}