package com.seyoung.navermaptest;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;

import java.util.List;

public class TourTypeAdapter extends RecyclerView.Adapter<TourTypeAdapter.ViewHolder> {

    private List<TourTypeData> mTourTypeData;

    public TourTypeAdapter(List<TourTypeData> tourTypeData) {
        mTourTypeData = tourTypeData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.tour_recyclerview, parent, false);
        ViewHolder viewHolder = new ViewHolder(linearLayout);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (mTourTypeData != null && !mTourTypeData.isEmpty()) {
            TourTypeData tourTypeData = mTourTypeData.get(position);
            holder.title_tv.setText(tourTypeData.getTitle());
            holder.tour_type_tv.setText(tourTypeData.getTourType());
            holder.address_tv.setText(tourTypeData.getAddress());
        }
    }

    @Override
    public int getItemCount() {
        return mTourTypeData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView title_tv;
        public TextView tour_type_tv;
        public TextView address_tv;
        public LottieAnimationView noDataAnim;
        public LinearLayout cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title_tv = itemView.findViewById(R.id.title_tv);
            tour_type_tv = itemView.findViewById(R.id.tour_type_tv);
            address_tv = itemView.findViewById(R.id.addr_tv);
            noDataAnim = itemView.findViewById(R.id.no_data_anim);
            cardView = itemView.findViewById(R.id.card_view);

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("asdwww   ", "asdwww ");
                }
            });
        }
    }
}
