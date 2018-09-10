package page.teste.scroller.details.model;

/**
 * Created by Dreamz on 09-09-2018.
 */

public class Lesson {
    //example is optical path, coherant structures etcc..
    String lessonName;

    public Lesson(String lessonName) {
        this.lessonName = lessonName;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }
}
