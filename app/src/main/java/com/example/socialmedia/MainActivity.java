package com.example.socialmedia;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

public class MainActivity extends AppCompatActivity {

    ViewPager2 viewPager2;

    MyCustomAdapter myCustomAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        myCustomAdapter = new MyCustomAdapter(
                getSupportFragmentManager(),
                getLifecycle()
        );

        viewPager2 = findViewById(R.id.viewPager1);
        viewPager2.setOrientation(ViewPager2.ORIENTATION_VERTICAL);

        FirstFragment firstFragment = new FirstFragment();
        SecondFragment secondFragment = new SecondFragment();
        ThirdFragment thirdFragment = new ThirdFragment();

        myCustomAdapter.loadFragment(firstFragment);
        myCustomAdapter.loadFragment(secondFragment);
        myCustomAdapter.loadFragment(thirdFragment);

        viewPager2.setAdapter(myCustomAdapter);
    }
}