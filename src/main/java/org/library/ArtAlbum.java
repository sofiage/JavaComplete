package org.library;

public class ArtAlbum extends Book{
    private String paperQuality;

    public ArtAlbum(String name, int numberOfPages, String paperQuality) {
        super(name, numberOfPages);
        this.paperQuality = paperQuality;
    }

    public String getPaperQuality() {
        return paperQuality;
    }

    public void setPaperQuality(String paperQuality) {
        this.paperQuality = paperQuality;
    }

    @Override
    public String toString() {
        return "ArtAlbum {" +
                " name='" + name + '\'' +
                ", numberOfPages=" + numberOfPages +
                ", paperQuality='" + paperQuality + '\'' +
                '}';
    }
}
