package com.example.webinarlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvcourses;
    ArrayList<Course> courses = Course.generateNRandomCourses(100);
    public static final String TAG = "convert";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvcourses = findViewById(R.id.lvcourses);
        CourseAdapter courseAdapter = new CourseAdapter();
        lvcourses.setAdapter(courseAdapter);
    }

    class CourseAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return courses.size();
        }

        @Override
        public Course getItem(int position) {
            return courses.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Log.d(TAG, "getview:" + convertView);
/*
            View itemView= getLayoutInflater().inflate(

R.layout.list_item_course,
                    parent,
                    false
            );

            TextView tvCourseName=itemView.findViewById(R.id.tvcoursename);
            TextView tvTeacherName= itemView.findViewById(R.id.tvTeacherName);
            TextView tvLectures=itemView.findViewById(R.id.tvlectures);
             Course course= getItem(position);
            tvCourseName.setText(course.getName());
            tvTeacherName.setText(course.getTeachername());
            tvLectures.setText(String.valueOf(course.getLectures()));
            return itemView;*/
            CourseViewHolder holder;
            if (convertView == null) {

                convertView = getLayoutInflater().inflate(

                        R.layout.list_item_course,
                        parent,
                        false
                );
                holder = new CourseViewHolder(convertView);
                convertView.setTag((holder));
            } else {
                holder = (CourseViewHolder) convertView.getTag();
            }
           // TextView tvCourseName = convertView.findViewById(R.id.tvcoursename);
           // TextView tvTeacherName = convertView.findViewById(R.id.tvTeacherName);
          //  TextView tvLectures = convertView.findViewById(R.id.tvlectures);

            Course course = getItem(position);
             holder.tvCourseName.setText(course.getName());
             holder.tvTeacherName.setText(course.getTeachername());
             holder.tvLectures.setText(String.valueOf(course.getLectures()));

            return convertView;
        }


        class CourseViewHolder {
            TextView tvCourseName, tvTeacherName, tvLectures;

            CourseViewHolder(View convertView) {
                tvCourseName = convertView.findViewById(R.id.tvcoursename);
                tvTeacherName = convertView.findViewById(R.id.tvTeacherName);
                tvLectures = convertView.findViewById(R.id.tvlectures);
            }
        }
    }
}
