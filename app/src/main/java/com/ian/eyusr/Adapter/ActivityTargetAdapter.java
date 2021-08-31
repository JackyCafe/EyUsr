package com.ian.eyusr.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ian.eyusr.Obj.ActivityTarget;
import com.ian.eyusr.Obj.DailyTarget;
import com.ian.eyusr.Obj.DailyTargetDAO;
import com.ian.eyusr.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ActivityTargetAdapter extends RecyclerView.Adapter<ActivityTargetAdapter.ViewHolder> {

    List<ActivityTarget> datas;
    Context context;

    public ActivityTargetAdapter(Context context, List<ActivityTarget> datas)
    {
        this.datas = datas;
        this.context = context;
        Log.i("RecycleView","ActivityTargetAdapter:");
     }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView targetView,finishView,nonfinishView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            targetView = itemView.findViewById(R.id.tv_target);
            finishView = itemView.findViewById(R.id.tv_finish);
            nonfinishView = itemView.findViewById(R.id.tv_nonfinish);
        }
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context c = parent.getContext();
        View v = LayoutInflater.from(c).inflate(R.layout.targetlistlayout, parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.targetView.setText(datas.get(position).getActivity_target());
        holder.targetView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DailyTargetDAO dao = new DailyTargetDAO(context);
                DailyTarget dailyTarget= new DailyTarget();
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
                ActivityTarget activityTarget = (ActivityTarget) datas.get(position);
                dailyTarget.setActivity_target(activityTarget.getActivity_target());
                dailyTarget.setActivity_id(activityTarget.getId());
                dailyTarget.setDate(sdf.format(date));
                dailyTarget.setScore(2);
                dao.insert(dailyTarget);
                int score = dao.getScore();
                Log.i("RecycleView","score:"+score);
            }
        });
        holder.finishView.setText(""+datas.get(position).getActivity_finish());
        holder.nonfinishView.setText(""+datas.get(position).getNonactivity_finish());

    }

    @Override
    public int getItemCount() {
        return datas.size();    }
}
