package com.example.b07demosummer2024;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class FlightFragment extends Fragment {

    private EditText numberFlight;
    private Spinner flightType;
    private Button submit;
    private FirebaseAuth auth;
    private FirebaseDatabase db;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_flight, container, false);

        submit = view.findViewById(R.id.buttonFlightSubmit);
        numberFlight = view.findViewById(R.id.editTextFlightNumber);
        flightType = view.findViewById(R.id.spinnerFlight);

        ArrayAdapter<CharSequence> unitAdapter = ArrayAdapter.createFromResource(getContext(),
                R.array.flight_haul, android.R.layout.simple_spinner_item);
        unitAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        flightType.setAdapter(unitAdapter);

        auth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance("https://b07finalproject-4e3be-default-rtdb.firebaseio.com/");

        submit.setOnClickListener(v -> {
            FirebaseUser currentUser = auth.getCurrentUser();
            if (currentUser != null) {
                String numberOfFlights = numberFlight.getText().toString().trim();
                String selectedFlightType = flightType.getSelectedItem().toString();
                addToDatabase(currentUser.getUid(), numberOfFlights, selectedFlightType);
            } else {
                Toast.makeText(getContext(), "Login required.", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    private void addToDatabase(String userId, String numberOfFlights, String flightType) {
        DatabaseReference logRef = db.getReference("users").child(userId).child("dailylogs").child(LocalDate.now().toString());
        String id = logRef.push().getKey();

        if (id != null) {
            Map<String, Object> activityData = new HashMap<>();
            activityData.put("activity_type", "transportation");
            activityData.put("information", Map.of(
                    "numberOfFlights", numberOfFlights,
                    "flightType", flightType
            ));

            logRef.child(id).setValue(activityData).addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    Toast.makeText(getContext(), "Data saved successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "Failed to save user data", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            Toast.makeText(getContext(), "Failed to generate unique ID", Toast.LENGTH_SHORT).show();
        }
    }
}