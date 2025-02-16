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
public class FragmentQuestion14 extends Fragment {
    private SurveyResponseListner listner;
    private int questionID;
    public FragmentQuestion14 (int questionID){
        this.questionID = questionID;
    }
    private Button naturalGas;
    private Button electricity;
    private Button oil;
    private Button propane;
    private Button wood;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_question14, container, false);
        naturalGas = view.findViewById(R.id.q14option1);
        electricity = view.findViewById(R.id.q14option2); // Change BUTTONS
        oil = view.findViewById(R.id.q14option3);
        propane = view.findViewById(R.id.q14option4);
        wood = view.findViewById(R.id.q14option5);

        naturalGas.setOnClickListener(this::answer);
        electricity.setOnClickListener(this::answer);
        oil.setOnClickListener(this::answer);
        propane.setOnClickListener(this::answer);
        wood.setOnClickListener(this::answer);

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
        naturalGas.setBackgroundColor(Color.rgb(0, 153, 153));
        electricity.setBackgroundColor(Color.rgb(0, 153, 153));
        oil.setBackgroundColor(Color.rgb(0, 153, 153));
        propane.setBackgroundColor(Color.rgb(0, 153, 153));
        wood.setBackgroundColor(Color.rgb(0, 153, 153));
        naturalGas.setActivated(true);
        electricity.setActivated(true);
        oil.setActivated(true);
        propane.setActivated(true);
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