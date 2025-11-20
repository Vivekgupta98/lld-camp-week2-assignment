package Solution.Models;

public class Lesson {
    private int id;
    private String title;
    private String contentUrl;
    private int durationMinutes;

    public Lesson(int id, String title, String contentUrl, int durationMinutes) {
        this.id = id;
        this.title = title;
        this.contentUrl = contentUrl;
        this.durationMinutes = durationMinutes;
    }
}
