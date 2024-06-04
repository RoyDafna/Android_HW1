package com.example.hw1_roydafna;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.hw1_roydafna.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        binding.buttonCalc.setOnClickListener(buttonCalcOnClickListener);
        Spinner spinner = (Spinner) binding.spinnerOperand;
        ArrayAdapter<CharSequence> adapter = ArrayAdapter
                .createFromResource
                        (this,
                                R.array.Operand_array,
                                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
        View.OnClickListener buttonCalcOnClickListener =v->{
            int numLeft = Integer.parseInt(binding.editTextNumberLeft.getText().toString());
            int numRight = Integer.parseInt(binding.editTextNumberRight.getText().toString());

            switch (binding.spinnerOperand.getSelectedItem().toString()){
                case "+":
                    binding.textViewResult.setText(String.valueOf(numLeft + numRight));
                    break;
                case "-":
                    binding.textViewResult.setText(String.valueOf(numLeft - numRight));
                    break;
                case "×":
                    binding.textViewResult.setText(String.valueOf(numLeft * numRight));
                    break;
                case "÷":
                    binding.textViewResult.setText(String.valueOf(numLeft / numRight));
                    break;
                default:
                    binding.textViewResult.setText("Error");
            }
        } ;


}