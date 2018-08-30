package page.teste.scroller;

import java.util.ArrayList;

/**
 * Created by Dreamz on 30-08-2018.
 */

public class Course {
    String title;
    ArrayList<String> chapters;

    public Course(String title, ArrayList<String> chapters) {
        this.title = title;
        this.chapters = chapters;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<String> getChapters() {
        return chapters;
    }

    public void setChapters(ArrayList<String> chapters) {
        this.chapters = chapters;
    }
}
