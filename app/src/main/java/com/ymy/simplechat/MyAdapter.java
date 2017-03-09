package com.ymy.simplechat;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ymy on 2017/3/9.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<Msg> msgs ;

    public MyAdapter(List<Msg> msgs) {
        this.msgs = msgs;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        LinearLayout LLleft;
        LinearLayout LLright;
        TextView text1;
        TextView text2;

        public ViewHolder(View itemView) {
            super(itemView);
            LLleft = (LinearLayout) itemView.findViewById(R.id.LLleft);
            LLright = (LinearLayout) itemView.findViewById(R.id.LLright);
            text1 = (TextView) itemView.findViewById(R.id.text1);
            text2 = (TextView) itemView.findViewById(R.id.text2);

        }
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_left,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Msg msg = msgs.get(position);
        Log.e("111",""+msg);
            if (msg.getType() == Msg.send){
                holder.LLleft.setVisibility(View.VISIBLE);
                holder.LLright.setVisibility(View.GONE);
                holder.text1.setText(msg.getContent());
            } else if(msg.getType() == Msg.recive){
                holder.LLleft.setVisibility(View.GONE);
                holder.LLright.setVisibility(View.VISIBLE);
                holder.text2.setText(msg.getContent());
            }
    }

    @Override
    public int getItemCount() {
        return msgs.size();
    }
}
