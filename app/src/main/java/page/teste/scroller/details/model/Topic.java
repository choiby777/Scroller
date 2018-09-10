package page.teste.scroller.details.model;

import java.util.ArrayList;

/**
 * Created by Dreamz on 09-09-2018.
 */

public class Topic {
    //example is Basics of interference
    String topicName;
    ArrayList<Lesson> lessonList;

    public Topic(String topicName, ArrayList<Lesson> lessonList) {
        this.topicName = topicName;
        this.lessonList = lessonList;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public ArrayList<Lesson> getLessonList() {
        return lessonList;
    }

    public void setLessonList(ArrayList<Lesson> lessonList) {
        this.lessonList = lessonList;
    }
}
