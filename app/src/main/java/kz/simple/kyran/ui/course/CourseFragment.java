package kz.simple.kyran.ui.course;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import kz.simple.kyran.R;
import kz.simple.kyran.ViewPagerAdapter;
import kz.simple.kyran.ui.tab1.MyCoursesFragment;
import kz.simple.kyran.ui.tab2.AllCoursesFragment;
import kz.simple.kyran.ui.tab3.MaterialsFragment;

public class CourseFragment extends Fragment  {

    private CourseViewModel courseViewModel;
    private FragmentActivity myContext;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        courseViewModel =
                ViewModelProviders.of(this).get(CourseViewModel.class);
        View root = inflater.inflate(R.layout.fragment_course, container, false);

        ViewPager viewPager = (ViewPager) root.findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        TabLayout tabLayout = (TabLayout) root.findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);


        return root;
    }
    @Override public void onAttach(Activity activity) {
        myContext=(FragmentActivity) activity;
        super.onAttach(activity);
    }
    private void setupViewPager(ViewPager viewPager) {

        ViewPagerAdapter adapter = new ViewPagerAdapter(myContext.getSupportFragmentManager());
        adapter.addFragment(new MyCoursesFragment(), getString(R.string.tab_my_courses));
        adapter.addFragment(new AllCoursesFragment(), getString(R.string.tab_all_courses));
        adapter.addFragment(new MaterialsFragment(), getString(R.string.tab_materials));
        viewPager.setAdapter(adapter);
    }


}