package page.teste.scroller.details;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import page.teste.scroller.R;
import page.teste.scroller.details.adapter.IndexRecyclerviewAdapter;
import page.teste.scroller.details.model.Chapter;
import page.teste.scroller.details.model.Lesson;
import page.teste.scroller.details.model.Topic;

public class CourseDetailActivity extends AppCompatActivity {
    RecyclerView indexRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private IndexRecyclerviewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        indexRecyclerView = findViewById(R.id.index_recyclerView);

        Lesson lesson = new Lesson("Introduction");
        Lesson lesson1 = new Lesson("Examples");
        Lesson lesson2 = new Lesson("Advanced Items");

        ArrayList<Lesson> lessonArrayList = new ArrayList<>();
        lessonArrayList.add(lesson);
        lessonArrayList.add(lesson1);
        lessonArrayList.add(lesson2);

        Topic topic = new Topic("Introduction to Interference",lessonArrayList);
        Topic topic2 = new Topic("Introduction to Mechanical Disturbance",lessonArrayList);

        ArrayList<Topic> topiclist = new ArrayList<>();
        topiclist.add(topic);
        topiclist.add(topic2);

        Topic topic3 = new Topic("Introduction to Diffraction",lessonArrayList);
        Topic topic4 = new Topic("Introduction to Particle Diffraction",lessonArrayList);

        ArrayList<Topic> topiclist2 = new ArrayList<>();
        topiclist2.add(topic3);
        topiclist2.add(topic4);


        Chapter chapter1 = new Chapter("Interference",topiclist);
        Chapter chapter2 = new Chapter("Diffraction",topiclist2);

        ArrayList<Chapter> chapterArrayList = new ArrayList<>();
        chapterArrayList.add(chapter1);
        chapterArrayList.add(chapter2);

        indexRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        indexRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new IndexRecyclerviewAdapter(chapterArrayList,this);
        indexRecyclerView.setAdapter(mAdapter);
        RecyclerView.ItemDecoration itemDecoration =
                new DividerItemDecoration(this, LinearLayoutManager.VERTICAL);
        indexRecyclerView.addItemDecoration(itemDecoration);

    }
}
