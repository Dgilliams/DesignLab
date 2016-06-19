package com.damosdesigns.designlab.main;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.damosdesigns.designlab.R;

/**
 * Created by damosdesigns on 6/19/16.
 */
public class ProjectsAdapter extends RecyclerView.Adapter<ProjectsAdapter.MyViewHolder> {
    public Project[] getmDataset() {
        return mDataset;
    }

    public void setmDataset(Project[] mDataset) {
        this.mDataset = mDataset;
    }

    private Project[] mDataset;

    public ProjectsAdapter(Project[] myDataset){
        mDataset = myDataset;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public CardView mCardView;
        public TextView mTextView;
        public ImageView mBackground;
        public View mRelativeLayout;


        public MyViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.project_card_title_text);
            mBackground = (ImageView) itemView.findViewById(R.id.project_card_background);
            mRelativeLayout = itemView.findViewById(R.id.project_card_relative_layout);
        }

    }




    @Override
    public ProjectsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.project_tile_item, parent, false);

        // set the view's size, margins, paddings and layout parameters
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int i) {
        holder.mTextView.setText(mDataset[i].getmTitle());
        holder.mBackground.setBackgroundColor(mDataset[i].getmBackgroundColor());
        holder.mBackground.setBackground(mDataset[i].getmLogo());
//        holder.mRelativeLayout.setBackgroundColor(Util.returnRandomMaterialColor());
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }


}


