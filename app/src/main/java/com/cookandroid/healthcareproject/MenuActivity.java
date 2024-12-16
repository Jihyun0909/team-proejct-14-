package com.cookandroid.healthcareproject;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // 유저 화면 버튼 클릭 이벤트
        findViewById(R.id.btn_user).setOnClickListener(v -> {
            // UserActivity로 이동
            Intent intent = new Intent(MenuActivity.this, UserActivity.class);

            // User 객체 생성 후 데이터 전달
            User user = new User("John Doe", 30, 175.0, 70.0, "Male");
            intent.putExtra("user", user); // User 객체 전달
            startActivity(intent);
        });

        findViewById(R.id.btn_log).setOnClickListener(v -> {
            // 기록 화면으로 이동 (추후 구현)
        });

        findViewById(R.id.btn_metric).setOnClickListener(v -> {
            // 지표 화면으로 이동 (추후 구현)
        });

        findViewById(R.id.btn_recommend).setOnClickListener(v -> {
            // 추천 화면으로 이동 (추후 구현)
        });
    }
}
