package com.reader.qr.productscan;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.LinearLayout;


public class ScanMenu extends Fragment {

    private ImageButton btn_sp;
    private ImageButton btn_sv;

    public ScanMenu() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
           /* mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);*/
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_scan_menu, container, false);
        return view;
    }

    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);

        btn_sp = (ImageButton)view.findViewById(R.id.btn_sp);
        btn_sv = (ImageButton)view.findViewById(R.id.btn_sv);

        btn_sp.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        btn_sp.setBackgroundResource(R.drawable.scanpro_c);
                        return true;
                    case MotionEvent.ACTION_UP:
                        btn_sp.setBackgroundResource(R.drawable.scanpro_i);
                        return true;
                }
                return false;
            }
        });

        btn_sv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        btn_sv.setBackgroundResource(R.drawable.scanven_c);
                        return true;
                    case MotionEvent.ACTION_UP:
                        btn_sv.setBackgroundResource(R.drawable.scanven_i);
                        return true;
                }
                return false;
            }
        });
    }
}
