package page.teste.scroller.adapters;

/**
 * Created by pratap.kesaboyina on 24-12-2014.
 */

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

import page.teste.scroller.R;
import page.teste.scroller.models.SectionDataModel;

public class RecyclerViewDataAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String TAG = "RecyclerViewDataAdapter";
    private ArrayList<SectionDataModel> dataList;
    private Context mContext;

    public RecyclerViewDataAdapter(Context context, ArrayList<SectionDataModel> dataList) {
        this.dataList = dataList;
        this.mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Log.d(TAG, "onCreateViewHolder: viewType : " + viewType);
        if (viewType == 1){

            View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, null);
            ItemRowHolder mh = new ItemRowHolder(v);
            return mh;

        }else{

            View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_single_card, null);
            ItemRowHolder2 mh = new ItemRowHolder2(v);
            return mh;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 1) return 1;
        else return  0;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {

        if (viewHolder.getItemViewType() == 1){
            ItemRowHolder itemRowHolder = (ItemRowHolder)viewHolder;

            final String sectionName = dataList.get(i).getHeaderTitle();

            ArrayList singleSectionItems = dataList.get(i).getAllItemsInSection();

            SectionListDataAdapter itemListDataAdapter = new SectionListDataAdapter(mContext, singleSectionItems);

            itemRowHolder.recycler_view_list.setHasFixedSize(true);
            itemRowHolder.recycler_view_list.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
            itemRowHolder.recycler_view_list.setAdapter(itemListDataAdapter);


            itemRowHolder.recycler_view_list.setNestedScrollingEnabled(false);

        }else{
        }
    }

    @Override
    public int getItemCount() {
        return (null != dataList ? dataList.size() : 0);
    }

    public class ItemRowHolder extends RecyclerView.ViewHolder {

        protected RecyclerView recycler_view_list;

        public ItemRowHolder(View view) {
            super(view);

            this.recycler_view_list = (RecyclerView) view.findViewById(R.id.recycler_view_list);
        }
    }

    public class ItemRowHolder2 extends RecyclerView.ViewHolder {

        protected ImageView imageView;
        protected TextView textView;

        public ItemRowHolder2(View view) {
            super(view);

            this.imageView = view.findViewById(R.id.itemImage);
            this.textView = view.findViewById(R.id.tvTitle);
        }
    }

}