package page.teste.scroller.details.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import page.teste.scroller.R;
import page.teste.scroller.details.model.Chapter;
import page.teste.scroller.details.model.Lesson;
import page.teste.scroller.details.model.Topic;

/**
 * Created by Dreamz on 09-09-2018.
 */

public class IndexRecyclerviewAdapter extends RecyclerView.Adapter<IndexRecyclerviewAdapter.CourseViewHolder> {

    ArrayList<Chapter> chapterList;
    Context context;

    public IndexRecyclerviewAdapter(ArrayList<Chapter> chapterList, Context context) {
        this.chapterList = chapterList;
        this.context = context;
    }

    @Override
    public CourseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // infalte the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.chapter_list_card_item_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        CourseViewHolder vh = new CourseViewHolder(v); // pass the view to View Holder
        return vh;
    }

    @Override
    public void onBindViewHolder(CourseViewHolder holder, int position) {
        holder.parentView.removeAllViews();

        ArrayList<Topic> topics = chapterList.get(position).getTopicList();
        holder.chapterName.setText(chapterList.get(position).getChapterName());
        for(int i=0;i<topics.size();i++){
            View topicItem = getTopicView(topics.get(i));
            holder.parentView.addView(topicItem);
        }
    }

    private View getTopicView(Topic topic) {

        View subchild = LayoutInflater.from(context).inflate(R.layout.topic_list_item_layout, null, false);
        LinearLayout parentSubChild = subchild.findViewById(R.id.topicParent);
        TextView topictitle = subchild.findViewById(R.id.topictitle);
        topictitle.setText(topic.getTopicName());
        parentSubChild.removeAllViews();
        ArrayList<Lesson> lessonList = topic.getLessonList();
        for(int i=0;i<lessonList.size();i++){
            View lessonItem = getLessonView(lessonList.get(i),i==0,i==lessonList.size()-1);//attach this to topic list and return
            parentSubChild.addView(lessonItem);
        }
        return subchild;
    }

    private View getLessonView(Lesson lesson,boolean top,boolean bottom) {
        //return the view of lesson list item
        View lessonView = LayoutInflater.from(context).inflate(R.layout.lessons_list_item_layout,null,false);
        TextView title = lessonView.findViewById(R.id.lessontitle);
        TextView duration = lessonView.findViewById(R.id.lessonDuration);
        LinearLayout topSection = lessonView.findViewById(R.id.topsection);
        LinearLayout bottomSection = lessonView.findViewById(R.id.bottomsection);
        if(top){
            topSection.setVisibility(View.INVISIBLE);
        }
        if(bottom){
            bottomSection.setVisibility(View.INVISIBLE);
        }
        title.setText(lesson.getLessonName());
        duration.setText("00:40");
        return lessonView;
    }


    @Override
    public int getItemCount() {
        return chapterList.size();
    }

    public class CourseViewHolder extends RecyclerView.ViewHolder {
       LinearLayout parentView;
       TextView chapterName;
        public CourseViewHolder(View itemView) {
            super(itemView);
            // get the reference of item view's
            chapterName = (TextView) itemView.findViewById(R.id.chapterTitle);
            parentView = (LinearLayout) itemView.findViewById(R.id.parentCard);
        }
    }
}
