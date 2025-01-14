package com.example.b07demosummer2024;
//What type of energy do you use to heat your home?


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentQuestion14#//newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentQuestion17 extends Fragment {
    private SurveyResponseListner listner;
    private int questionID;
    public FragmentQuestion17 (int questionID){
        this.questionID = questionID;
    }
    private Button option1;
    private Button option2;
    private Button option3;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_question17, container, false);
        option1 = view.findViewById(R.id.q17option1);
        option2 = view.findViewById(R.id.q17option2); // Change BUTTONS
        option3 = view.findViewById(R.id.q17option3);

        option1.setOnClickListener(this::answer);
        option2.setOnClickListener(this::answer);
        option3.setOnClickListener(this::answer);
        return view;

    }

    @Override
    public void onAttach(Context context){

        super.onAttach(context);
        try{
            listner = (SurveyResponseListner) context;
        }
        catch (ClassCastException e){
            throw new ClassCastException(context.toString() + "doesn't properly implement");
        }
    }


    public void answer(View view){
        option1.setBackgroundColor(Color.rgb(0, 153, 153));
        option2.setBackgroundColor(Color.rgb(0, 153, 153));
        option3.setBackgroundColor(Color.rgb(0, 153, 153));

        option1.setActivated(true);
        option2.setActivated(true);
        option3.setActivated(true);

        Button option = (Button)view;
        String selectedOption = option.getText().toString();
        option.setBackgroundColor(Color.GRAY);
        option.setActivated(false);
        saveOption(selectedOption);
    }
    private void saveOption(String selectedOption){
        if (listner != null){
            listner.onOption(questionID, selectedOption);
        }
    }
}