package com.example.amr.compass_17.Adapters;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.amr.compass_17.R;

import java.util.ArrayList;

/**
 * Created by Lenovo on 12/2/2016.
 */

public class messageAdapter extends ArrayAdapter<String> {
    Context context;
    int res;
    LayoutInflater inf;
    ArrayList<String> messages;

    public messageAdapter(Context context, int res, ArrayList<String> messages) {
        super(context, res, messages);
        this.context = context;
        this.res = res;
        this.messages = messages;
        inf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void add(String s){
        messages.add(s);
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        ViewHolder holder;

        if(convertView==null){
            convertView = inf.inflate(res,null);
            holder = new ViewHolder();
            holder.txtMessage = (TextView) convertView.findViewById(R.id.txtMessage);
            holder.contentWithBG = (LinearLayout) convertView.findViewById(R.id.contentWithBackground);
            holder.content = (LinearLayout) convertView.findViewById(R.id.content);
            convertView.setTag(holder);
        }
        else
            holder = (ViewHolder)convertView.getTag();
        setAlignment(holder);
        holder.txtMessage.setText(messages.get(i));
        return convertView;
    }

    static class ViewHolder {
        public TextView txtMessage;
        public LinearLayout contentWithBG;
        public LinearLayout content;
    }

    private void setAlignment(ViewHolder holder) {

        holder.contentWithBG.setBackgroundResource(R.drawable.out_message_bg);

        LinearLayout.LayoutParams layoutParams =
                (LinearLayout.LayoutParams) holder.contentWithBG.getLayoutParams();
        layoutParams.gravity = Gravity.LEFT;
        holder.contentWithBG.setLayoutParams(layoutParams);

        RelativeLayout.LayoutParams lp =
                (RelativeLayout.LayoutParams) holder.content.getLayoutParams();
        lp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, 0);
        lp.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        holder.content.setLayoutParams(lp);
        layoutParams = (LinearLayout.LayoutParams) holder.txtMessage.getLayoutParams();
        layoutParams.gravity = Gravity.LEFT;
        holder.txtMessage.setLayoutParams(layoutParams);

    }

}
