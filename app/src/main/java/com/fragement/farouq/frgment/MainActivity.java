package com.fragement.farouq.frgment;



import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements ToolbarFragment.ToolbarListener{

    TextFragemnt txtFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        txtFragment  =(TextFragemnt)getSupportFragmentManager().findFragmentById(R.id.fragmentText);
    }

    //from the interface  in ToolbarFragment.ToolbarListener..
    @Override
    public void onButtonPressedClicked(int position, String text) {
        //positiion : value of the seekbar
        //text : text from the edittext..
        //position and text gets from the callback in ToolbarFragment class...see methods when button clicked..

        Toast.makeText(this,"Text : "+text+", seekbar : "+position+" ",Toast.LENGTH_LONG).show();

        txtFragment.changeTextproperties(position,text);
    }
}
