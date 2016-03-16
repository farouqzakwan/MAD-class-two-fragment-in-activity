package com.fragement.farouq.frgment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

public class ToolbarFragment extends Fragment {

    int seekerValue = 10;
    String text = "";
    EditText edtText;
    SeekBar seekBar;

    public ToolbarFragment() {

    }
    ToolbarListener toolbarListener;
    //the interface method is meant to be override in the activity
    public  interface ToolbarListener{
        //this will be used in the activity where fragments will be created
        public void onButtonPressedClicked(int position,String text);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_toolbar, container, false);

        edtText = (EditText)view.findViewById(R.id.edtTxt);
        seekBar = (SeekBar)view.findViewById(R.id.seekBar);

        //set onseekbarchangelistener to the seekkbar
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            //int progress : current progress value

                seekerValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        Button btnPress = (Button)view.findViewById(R.id.btnPress);

        //setonclick listener to the button..
        btnPress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //method to run what happen when button clicked
                onButtonPressed(v);
            }
        });

        return view;
    }

    public void onButtonPressed(View view){
        //when button is pressed,get the value of the seekbar and value of the editText..
        text = edtText.getText().toString();
        //use the callback to passed the value..
        toolbarListener.onButtonPressedClicked(seekerValue,text);
    }

    //this method use to see if there is callback when fragments attached to the activity..
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            toolbarListener = (ToolbarListener) context;
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
