package com.care.connect;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.care.connect.utils.PrintMsg;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private int mainArrayListLength = 8;
    //    private BottomBar mBottomBar;
    Button bt_family, bt_friends, bt_utilities;
    TextView tv_selected_category;
    Context context;
    int selectedPos = -1;
    String[] imageId_selected = {
            "https://d1uy1wopdv0whp.cloudfront.net/buzzavatars/av1.png",
            "https://d1uy1wopdv0whp.cloudfront.net/buzzavatars/av2.png",
            "https://d1uy1wopdv0whp.cloudfront.net/buzzavatars/av3.png",
            "https://d1uy1wopdv0whp.cloudfront.net/buzzavatars/av4.png",
            "https://d1uy1wopdv0whp.cloudfront.net/buzzavatars/av5.png",
            "https://d1uy1wopdv0whp.cloudfront.net/buzzavatars/av6.png",
            "https://d1uy1wopdv0whp.cloudfront.net/buzzavatars/av7.png",
            "https://d1uy1wopdv0whp.cloudfront.net/buzzavatars/av8.png",
            "https://d1uy1wopdv0whp.cloudfront.net/buzzavatars/av9.png",
            "https://d1uy1wopdv0whp.cloudfront.net/buzzavatars/av10.png"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();
        context = this;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;

        bt_family = findViewById(R.id.bt_family);
        bt_friends = findViewById(R.id.bt_friends);
        bt_utilities = findViewById(R.id.bt_utilities);
        tv_selected_category = findViewById(R.id.tv_selected_category);

        bt_family.setOnClickListener(this);
        bt_friends.setOnClickListener(this);
        bt_utilities.setOnClickListener(this);

        setBottomMenu("family");

        ArrayList<String> names = new ArrayList<>();
        names.add("Samar");
        names.add("Kalyan");
        names.add("Venkat");
        names.add("Kumar");
        names.add("kailash");

        names.add("Srinivas");
        names.add("Rajesh");
        names.add("Sumanth");
        names.add("Prasad");
        names.add("Dinesh");

        Log.e("height", "" + height + " divide " + (height / 4));
        Log.e("width", "" + width + " width " + (width / 4));

        int count = mainArrayListLength - names.size();
        for (int i = 0; i <= count; i++) {
            names.add("empty");
        }

        ArrayList<String> leftArrayList = new ArrayList<String>(names.subList(0, 5));
        Log.e("samar", "SubList stored in ArrayList left: " + leftArrayList);

        ArrayList<String> rightArrayList = new ArrayList<String>(names.subList(5, 10));
        Log.e("samar", "SubList stored in ArrayList Right: " + rightArrayList);


        // set up the RecyclerView left
        RecyclerView rc_left = findViewById(R.id.rc_left);
        rc_left.setLayoutManager(new LinearLayoutManager(this));
        RecyclerLeftAdapter adapter = new RecyclerLeftAdapter(this, leftArrayList, "left",imageId_selected);
        rc_left.setAdapter(adapter);


        // set up the RecyclerView right
        RecyclerView rc_right = findViewById(R.id.rc_right);
        rc_right.setLayoutManager(new LinearLayoutManager(this));
        RecyclerLeftAdapter adapter1 = new RecyclerLeftAdapter(this, rightArrayList, "right",imageId_selected);
        rc_right.setAdapter(adapter1);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_family:
                setBottomMenu("family");
                break;
            case R.id.bt_friends:
                setBottomMenu("friends");
                break;
            case R.id.bt_utilities:
                setBottomMenu("utilities");
                break;
        }
    }

    private void setBottomMenu(String from) {

        String seleced_color = "";
        String grey ="#707070";
        tv_selected_category.setText(from);
        if(from.equalsIgnoreCase("family")){

//            seleced_color = getResources().getColor(R.color.blue);
            seleced_color = "#303F9F";

            PrintMsg.setprint(context,"sel Color"+(seleced_color));
            bt_family.setBackgroundResource(R.drawable.bt_gradient_family);
            bt_friends.setBackgroundResource(R.drawable.bt_gradient_unsel);
            bt_utilities.setBackgroundResource(R.drawable.bt_gradient_unsel);

            bt_family.setTextColor(Color.parseColor(seleced_color));
            bt_friends.setTextColor(Color.parseColor(grey));
            bt_utilities.setTextColor(Color.parseColor(grey));
        }else if(from.equalsIgnoreCase("friends")){
            seleced_color = "#388E3C";

            bt_family.setBackgroundResource(R.drawable.bt_gradient_unsel);
            bt_friends.setBackgroundResource(R.drawable.bt_gradient_friends);
            bt_utilities.setBackgroundResource(R.drawable.bt_gradient_unsel);

            bt_friends.setTextColor(Color.parseColor(seleced_color));
            bt_family.setTextColor(Color.parseColor(grey));
            bt_utilities.setTextColor(Color.parseColor(grey));
        }else if(from.equalsIgnoreCase("utilities")){
            seleced_color = "#E64A19";

            bt_family.setBackgroundResource(R.drawable.bt_gradient_unsel);
            bt_friends.setBackgroundResource(R.drawable.bt_gradient_unsel);
            bt_utilities.setBackgroundResource(R.drawable.bt_gradient_utilities);

            bt_utilities.setTextColor(Color.parseColor(seleced_color));
            bt_friends.setTextColor(Color.parseColor(grey));
            bt_family.setTextColor(Color.parseColor(grey));
        }
        tv_selected_category.getBackground().setColorFilter(Color.parseColor(seleced_color), PorterDuff.Mode.SRC_OVER);
    }

    public class RecyclerLeftAdapter extends RecyclerView.Adapter<RecyclerLeftAdapter.ViewHolder> {

        private List<String> mData;
        private LayoutInflater mInflater;
        private String type;
        private final String[] Imageid;

        // data is passed into the constructor
        RecyclerLeftAdapter(Context context, List<String> data, String type, String[] Imageid) {
            this.mInflater = LayoutInflater.from(context);
            this.mData = data;
            this.type = type;
            this.Imageid = Imageid;
        }

        // inflates the row activity_calling from xml when needed
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view;
            if (type.equalsIgnoreCase("left")) {
                view = mInflater.inflate(R.layout.recyclerview_left_item, parent, false);
                int height1 = (parent.getMeasuredHeight() / 4);
//                height1 = height1+30;
                view.setMinimumHeight(height1);
            } else {
                view = mInflater.inflate(R.layout.recyclerview_right_item, parent, false);
                int height1 = (parent.getMeasuredHeight() / 4);
//                height1 = height1+30;
                view.setMinimumHeight(height1);

            }
            return new ViewHolder(view);
        }

        //Binds the data to rows
        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            String name = mData.get(position);
            holder.tv_ContactName.setText(name);

            Glide.with(context).load(Imageid[position]).into(holder.iv_contact_image);

            holder.ll_top.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(HomeActivity.this , CallingActivity.class));
                }
            });
//        ViewGroup.LayoutParams params = holder.iv.getLayoutParams();
//        params.height = height;
//        holder.iv.setLayoutParams(params);
//        Log.e("height",""+height);
        }

        // gets the items list count
        @Override
        public int getItemCount() {
            return mData.size();
        }

        // stores and recycles views as they are scrolled off screen
        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView tv_ContactName;
            ImageView iv_contact_image;
            RelativeLayout ll_top;

            ViewHolder(View itemView) {
                super(itemView);
                tv_ContactName = itemView.findViewById(R.id.tv_ContactName);
                iv_contact_image = itemView.findViewById(R.id.iv_contact_image);
                ll_top = itemView.findViewById(R.id.ll_top);
            }
        }

        // convenience method for getting data at click position
        String getItem(int id) {
            return mData.get(id);
        }
    }
}
