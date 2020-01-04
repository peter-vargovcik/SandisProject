package com.vargovcik.peter.happypear.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.vargovcik.peter.happypear.R;
import com.vargovcik.peter.happypear.components.CustomWeekPicker;
import com.vargovcik.peter.happypear.components.CustomWeekPickerListener;
import com.vargovcik.peter.happypear.components.DualPerformanceView;

import java.util.Calendar;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
       final View root = inflater.inflate(R.layout.fragment_home, container, false);
//        final TextView textView = root.findViewById(R.id.text_home);
//        homeViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });


        CustomWeekPicker weekPicker = root.findViewById(R.id.calendarTableView);

        weekPicker.setOnChangeListener(new CustomWeekPickerListener() {
            @Override
            public void onWeekChange(Calendar calendar) {
                String test = String.format("...%d Week %d...",calendar.get(Calendar.YEAR),calendar.get(Calendar.WEEK_OF_YEAR));

                Toast.makeText(root.getContext(),test,Toast.LENGTH_SHORT).show();
            }
        });

        DualPerformanceView performanceView = root.findViewById(R.id.performance_view_shops);
        performanceView.setNameAndSides("Shops","Centra","SuperValue");

        return root;
    }
}