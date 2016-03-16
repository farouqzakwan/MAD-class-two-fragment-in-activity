package com.fragement.farouq.frgment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.zip.Inflater;

public class TextFragemnt extends Fragment {

    TextView txt;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_text_fragemnt,container,false);

        txt = (TextView)view.findViewById(R.id.txtDisplay);
        // Inflate the layout for this fragment
        return view;
    }

    public void changeTextproperties(int size,String text){
        txt.setText(text);
        txt.setTextSize(size);
    }

}
