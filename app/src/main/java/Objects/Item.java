package Objects;

/**
 * Created by minhtien on 1/12/16.
 */
public class Item {
    private String title;
    private String pubDate;
    private String image;
    private String link;

    public Item(String title, String pubDate, int image, String link) {
        this.title = title;
        this.pubDate = pubDate;
        this.link = link;
    }
    public Item(){

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
