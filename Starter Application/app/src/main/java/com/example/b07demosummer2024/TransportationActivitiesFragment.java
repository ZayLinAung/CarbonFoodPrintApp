package com.example.b07demosummer2024;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.AdapterView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;

public class TransportationActivitiesFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_transportation, container, false);

//        Button buttonTransportation = view.findViewById(R.id.buttonTransportation);
//        Button buttonFoodConsumption = view.findViewById(R.id.buttonFoodConsumption);
//        Button buttonConsumptionAndShopping= view.findViewById(R.id.buttonConsumptionAndShopping);
//
//        buttonTransportation.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                loadFragment(new RecyclerViewFragment());
//            }
//        });
//
//        buttonFoodConsumption.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                loadFragment(new RecyclerViewFragment());
//            }
//        });
//
//        buttonConsumptionAndShopping.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                loadFragment(new RecyclerViewFragment());
//            }
//        });


        return view;
    }


    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
