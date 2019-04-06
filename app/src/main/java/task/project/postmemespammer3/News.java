package task.project.postmemespammer3;

public class News {

    private String title;
    private int image;

    public News() {
    }

    public News(String title, int image) {
        this.title = title;
        this.image = image;
    }

    public String getTitle() {

        return title;
    }

    public int getImage() {

        return image;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public void setImage(int image) {

        this.image = image;
    }

}
