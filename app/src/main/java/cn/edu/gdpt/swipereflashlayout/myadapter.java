package cn.edu.gdpt.swipereflashlayout;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.ActivityChooserView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

public class myadapter extends RecyclerView.Adapter<myadapter.MyViewHolder> {

    private final Context context;
    private final List<Map<String, Object>> list;

    public myadapter(Context context, List<Map<String, Object>> list) {
        this.context=context;
        this.list=list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= View.inflate(context,R.layout.item_list,null);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        Object title = list.get(i).get("title");
        myViewHolder.textView.setText(title+"");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.item_tv);
        }
    }
}
