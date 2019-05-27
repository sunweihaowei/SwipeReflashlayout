package cn.edu.gdpt.swipereflashlayout;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    //SwipeRefreshLayout总结：
    /*
    把布局包在里面，设置监听，把要实现的功能，写在监听里

    */
    private RecyclerView rcv;
    private SwipeRefreshLayout wr;
    private myadapter myadapter1;
    private List<Map<String,Object>> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        for (int i=0;i<50;i++){
            Map<String,Object> map=new HashMap<>();
            map.put("title","sunweihao"+i);
            list.add(map);
        }
        myadapter1=new myadapter(MainActivity.this,list);
        rcv.setAdapter(myadapter1);
       rcv.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false));
       wr.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
           @Override
           public void onRefresh() {
               list.clear();
               for (int i=0;i<50;i++){
                   Map<String,Object> map=new HashMap<>();
                   map.put("title","sunweihao"+i+i);
                   list.add(map);
               }
               myadapter1.notifyDataSetChanged();
               wr.setRefreshing(false);
           }
       });
    }

    private void initView() {


        rcv = (RecyclerView) findViewById(R.id.rcv);

        wr = (SwipeRefreshLayout) findViewById(R.id.wr);

    }
}
