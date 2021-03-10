package com.sanju.udemylearning;

import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SwipeVideosAdapter extends RecyclerView.Adapter<SwipeVideosAdapter.VideoViewHolder>{
    private List<SwipeVideoItem> mSwipeVideoItems;

    public SwipeVideosAdapter(List<SwipeVideoItem> swipeVideoItems) {
        mSwipeVideoItems = swipeVideoItems;
    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VideoViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_videos_container,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {
        holder.setVideoData(mSwipeVideoItems.get(position));
    }

    @Override
    public int getItemCount() {
        return mSwipeVideoItems.size();
    }

    static class VideoViewHolder extends RecyclerView.ViewHolder{
        VideoView mVideoView;
        TextView txtTitle,txtDesc;
        ProgressBar mProgressBar;

        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);
            mVideoView = itemView.findViewById(R.id.videoView);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtDesc = itemView.findViewById(R.id.txtDesc);
            mProgressBar = itemView.findViewById(R.id.progressBar);
        }
        void setVideoData(SwipeVideoItem swipeVideoItem){
            txtTitle.setText(swipeVideoItem.videoTitle);
            txtDesc.setText(swipeVideoItem.videoDesc);
            mVideoView.setVideoPath(swipeVideoItem.videoURL);
            mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mProgressBar.setVisibility(View.GONE);
                    mp.start();

                    float videoRatio = mp.getVideoWidth() / (float)mp.getVideoHeight();
                    float screenRatio = mVideoView.getWidth() / (float)mVideoView.getHeight();
                    float scale  = videoRatio / screenRatio;
                    if (scale >= 1f){
                        mVideoView.setScaleX(scale);
                    }else {
                        mVideoView.setScaleY(1f / scale);
                    }
                }
            });
            mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mp.start();
                }
            });
        }
    }
}
