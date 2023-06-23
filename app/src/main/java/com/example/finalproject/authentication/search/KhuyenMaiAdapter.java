package com.example.finalproject.authentication.search;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject.R;

import java.util.List;

public class KhuyenMaiAdapter extends RecyclerView.Adapter<KhuyenMaiAdapter.khuyenmaiViewholder>{
    private List<KhuyenMai> khuyenMaiList;

    public void setKhuyenMaiList(List<KhuyenMai> list) {
        this.khuyenMaiList = list;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public khuyenmaiViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_khuyenmai, parent, false);
        return new KhuyenMaiAdapter.khuyenmaiViewholder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull khuyenmaiViewholder holder, int position) {
        KhuyenMai khuyenMai = khuyenMaiList.get(position);
        if(khuyenMai == null){
            return;
        }
        holder.imgKhuyenMai.setImageResource(khuyenMai.getResourceImg());
        holder.txtTenKhuyenMai.setText(khuyenMai.getTitle());

    }


    @Override
    public int getItemCount() {
        if(khuyenMaiList != null){
            return khuyenMaiList.size();
        }
        return 0;
    }

    public class khuyenmaiViewholder extends RecyclerView.ViewHolder {

        private ImageView imgKhuyenMai;
        private TextView txtTenKhuyenMai;

        public khuyenmaiViewholder(@NonNull View itemView) {
            super(itemView);

            imgKhuyenMai = itemView.findViewById(R.id.imageviewKhuyenMai);
            txtTenKhuyenMai = itemView.findViewById(R.id.textviewKhuyenMai);
        }
    }
}
