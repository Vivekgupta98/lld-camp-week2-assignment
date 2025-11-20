package Solution.Models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Module {
    private int id;
    private String title;
    private List<Lesson> lessons;
    public Module(int id, String title) {
        this.id = id;
        this.title = title;
        this.lessons = new ArrayList<>();
    }
    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public void addLesson(Lesson lesson) {
        lessons.add(lesson);
    }
    public List<Lesson> getLessons() {
        return lessons;
    }


}
