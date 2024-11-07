package com.example.user.photoapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.user.photoapp.R;
import com.example.user.photoapp.delegate.PhotoDelegate;
import com.example.user.photoapp.mvp.data.vo.Hits;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.PhotoHolder>{
    Context ctxt;
    List<Hits> hits;
    PhotoDelegate delegate;

    public void onPhotoClick(PhotoDelegate delegate){
        this.delegate=delegate;
    }

    public PhotoAdapter(Context ctxt, List<Hits> hits) {
        this.ctxt = ctxt;
        this.hits = hits;
    }

    @NonNull
    @Override
    public PhotoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li=LayoutInflater.from(ctxt);
        View v=li.inflate(R.layout.sample_view,parent,false);
        PhotoHolder ph=new PhotoHolder(v);
        return ph;
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoHolder holder, int position) {
        Hits h=hits.get(position);
        Picasso.get().load(h.getWebformatURL()).placeholder(R.drawable.img).error(R.drawable.img3).into(holder.iv);
    }

    @Override
    public int getItemCount() {
        return hits.size();
    }

    public class PhotoHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        public PhotoHolder(View itemView) {
            super(itemView);
            iv=itemView.findViewById(R.id.iv_sv);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    delegate.onPhotoClick(hits.get(getAdapterPosition()));
                }
            });
        }
    }
}
