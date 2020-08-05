package kz.simple.kyran.ui.tab2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import kz.simple.kyran.R;

public class AllCoursesFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_my_courses, container, false);
        LinearLayout linLayout=root.findViewById(R.id.linLayout1);
        LayoutInflater layInflater=getLayoutInflater();
        View view=layInflater.inflate(R.layout.course_element,linLayout,false);
        ImageView imgView=view.findViewById(R.id.imgView);
        imgView.setImageResource(R.drawable.ic_launcher_background);
        view.getLayoutParams().width = LinearLayout.LayoutParams.MATCH_PARENT;
        linLayout.addView(view);
        return root;
    }
}
