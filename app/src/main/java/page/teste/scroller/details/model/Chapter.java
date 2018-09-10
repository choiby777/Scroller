package page.teste.scroller.details.model;

import java.util.ArrayList;

/**
 * Created by Dreamz on 09-09-2018.
 */

public class Chapter {
    //example is Interference
    String chapterName;
    ArrayList<Topic> topicList;

    public Chapter(String chapterName, ArrayList<Topic> topicList) {
        this.chapterName = chapterName;
        this.topicList = topicList;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public ArrayList<Topic> getTopicList() {
        return topicList;
    }

    public void setTopicList(ArrayList<Topic> topicList) {
        this.topicList = topicList;
    }
}
