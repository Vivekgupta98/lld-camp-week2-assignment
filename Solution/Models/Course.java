package Solution.Models;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private int id;
    private String title;
    private String description;
    private List<Module> modules;

    public Course(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.modules = new ArrayList<>();
    }
    public void addModule(Module module) {
        modules.add(module);
    }
    public List<Module> getModules() {
        return modules;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

}
