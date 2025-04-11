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
    private TourType tourType;

    public TourTypeAdapter(List<TourTypeData> tourTypeData, TourType tourType) {
        mTourTypeData = tourTypeData;
        this.tourType = tourType;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tour_recyclerview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (mTourTypeData != null && !mTourTypeData.isEmpty()) {
            TourTypeData tourTypeData = mTourTypeData.get(position);
            holder.title_tv.setText(tourTypeData.getTitle());
            holder.tour_type_tv.setText(tourTypeData.getTourType());
            holder.address_tv.setText(tourTypeData.getAddress());
        }

        // ViewHolder랑 같이 setOnClickListener를 하면 기능이 안먹는거 같음
        // cardView 클릭 시, 지도에서 해당 위치로 카메라 이동
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("asdwww1   ", "asdwww1   ");

                // TourType의 closeSlidingUpPanelLayout에서 받은 매개변수(파라메터)를 받기
                // int position 에서 경고 뜸 : Do not treat position as fixed; only use immediately and call holder.getAdapterPosition() to look it up later
                // position을 클릭 리스너 내부에서 "나중에" 사용하고 있기 때문에 경고가 뜸
//                Double mapX = Double.parseDouble(mTourTypeData.get(position).getMapX());
//                Double mapY = Double.parseDouble(mTourTypeData.get(position).getMapY());

                int currentPosition = holder.getAdapterPosition();
                if (currentPosition != RecyclerView.NO_POSITION) {
                    Double mapX = Double.parseDouble(mTourTypeData.get(currentPosition).getMapX());
                    Double mapY = Double.parseDouble(mTourTypeData.get(currentPosition).getMapY());

                    // cardView 클릭 시, SlidingUpPanelLayout 닫는 기능
                    tourType.closeSlidingUpPanelLayout(mapX, mapY);
                }
            }
        });
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
        }
    }
}
