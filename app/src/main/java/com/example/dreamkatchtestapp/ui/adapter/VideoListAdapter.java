package com.example.dreamkatchtestapp.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.dreamkatchtestapp.R;
import com.example.dreamkatchtestapp.model.ResultDataModel;
import com.example.dreamkatchtestapp.ui.home.ExoPlayerActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class VideoListAdapter extends RecyclerView.Adapter<VideoListAdapter.ViewHolder> {
    private List<ResultDataModel> mVideoList;
    private Context mContext;

    public VideoListAdapter(List<ResultDataModel> mVideoList, Context mContext) {
        this.mVideoList = mVideoList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_video, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ResultDataModel dataModel = mVideoList.get(position);


        Glide.with(mContext).load(dataModel.getFormattedData().getImage()).
                centerCrop()
                .placeholder(R.drawable.img_placeholder)
                .into(holder.ivVideo);

        ViewTreeObserver vto = holder.ivVideo.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                    holder.ivVideo.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                } else {
                    holder.ivVideo.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }

                ViewGroup.LayoutParams layoutParams = holder.ivVideo.getLayoutParams();
                layoutParams.height = LinearLayout.LayoutParams.MATCH_PARENT;
                holder.ivVideo.setLayoutParams(layoutParams);


            }
        });

    }

    @Override
    public int getItemCount() {
        return mVideoList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvName)
        TextView tvName;
        @BindView(R.id.ivVideo)
        ImageView ivVideo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
        @OnClick({ R.id.ivVideo })
        public void onViewClicked(View view) {
            switch (view.getId()) {
                case R.id.ivVideo:

                    Intent intent = ExoPlayerActivity.getStartIntent(mContext, mVideoList.get(getAdapterPosition()).getFormattedData().getUrl());
                    intent.addFlags(FLAG_ACTIVITY_NEW_TASK);
                    mContext.getApplicationContext().startActivity(intent);
                    break;
            }
        }
    }

}
