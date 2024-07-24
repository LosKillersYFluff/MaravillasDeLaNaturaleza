package com.example.maravillas;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class TutorialActivity extends AppCompatActivity {

    private Button buttonTab1;
    private Button buttonTab2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        buttonTab1 = findViewById(R.id.boton_reconocer);
        buttonTab2 = findViewById(R.id.boton_frase);

        buttonTab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTab(new Fragment());
                buttonTab1.setEnabled(false);
                buttonTab2.setEnabled(true);
            }
        });

        buttonTab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTab(new Fragment());
                buttonTab1.setEnabled(true);
                buttonTab2.setEnabled(false);
            }
        });

        // Show the first tab by default
        buttonTab1.performClick();
    }

    private void showTab(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.info, fragment);
        transaction.commit();
    }
}
