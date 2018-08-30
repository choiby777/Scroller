package page.teste.scroller;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dreamz on 30-08-2018.
 */

public class CourseRVAdapter extends RecyclerView.Adapter<CourseRVAdapter.SimpleViewHolder> {

    private final Context mContext;
    private static List<Course> mData;
    private static RecyclerView horizontalList;

    public static class SimpleViewHolder extends RecyclerView.ViewHolder {
        private HorizontalRVAdapter horizontalAdapter;

        public SimpleViewHolder(View view) {
            super(view);
            Context context = itemView.getContext();
            horizontalList = (RecyclerView) itemView.findViewById(R.id.horizontal_list);
            horizontalList.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            horizontalAdapter = new HorizontalRVAdapter();
            horizontalList.setAdapter(horizontalAdapter);
        }
    }

    public CourseRVAdapter(Context context, List<Course> data) {
        mContext = context;
        if (data != null)
            mData = new ArrayList<Course>(data);
        else mData = new ArrayList<>();
    }

    public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(mContext).inflate(R.layout.courses_item, parent, false);
        return new SimpleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SimpleViewHolder holder, final int position) {
       // holder.title.setText(mData.get(position).getTitle());

        holder.horizontalAdapter.setData(mData.get(position).getChapters()); // List of Strings
        holder.horizontalAdapter.setRowIndex(position);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

}
