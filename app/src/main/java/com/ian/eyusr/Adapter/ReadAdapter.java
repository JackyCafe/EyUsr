package com.ian.eyusr.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.ian.eyusr.Obj.ReadClass;
import com.ian.eyusr.R;
import com.ian.eyusr.ReadingContentActivity;

import java.util.List;

public class ReadAdapter extends RecyclerView.Adapter<ReadAdapter.ViewHolder> {
    List<ReadClass> data;
    Context context;
    private ViewHolder holder;
    private int position;

    public ReadAdapter(List<ReadClass> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.reader_items,parent,false);
        ViewHolder vh =new ViewHolder(v);
        context = parent.getContext();
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        this.holder = holder;
        this.position = holder.getAdapterPosition();
        holder.title.setText(data.get(this.position).getTitle());
        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(holder.itemView.getContext(), ReadingContentActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("data",data.get(position));
                it.putExtra("content",bundle);
                context.startActivity(it);
            }
        });
//        holder.content.setText(HtmlCompat.fromHtml(data.get(position).getContent(),HtmlCompat.FROM_HTML_MODE_LEGACY));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        public TextView title,content;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
//            content = itemView.findViewById(R.id.content);
        }
    }
}
