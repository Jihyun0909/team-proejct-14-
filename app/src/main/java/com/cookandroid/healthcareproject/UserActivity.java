package com.cookandroid.healthcareproject;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class UserActivity extends AppCompatActivity {

    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        // UI 요소 연결
        EditText etName = findViewById(R.id.et_user_name);
        EditText etAge = findViewById(R.id.et_user_age);
        EditText etHeight = findViewById(R.id.et_user_height);
        EditText etWeight = findViewById(R.id.et_user_weight);
        RadioGroup rgGender = findViewById(R.id.rg_gender);
        RadioButton rbMale = findViewById(R.id.rb_male);
        RadioButton rbFemale = findViewById(R.id.rb_female);
        Button btnCalculateBMI = findViewById(R.id.btn_calculate_bmi);

        // 초기화 및 데이터 설정
        user = (User) getIntent().getSerializableExtra("user");
        if (user != null) {
            etName.setText(user.getName());
            etAge.setText(String.valueOf(user.getAge()));
            etHeight.setText(String.valueOf(user.getHeight()));
            etWeight.setText(String.valueOf(user.getWeight()));
            if ("남자".equals(user.getGender())) {
                rbMale.setChecked(true);
            } else if ("여자".equals(user.getGender())) {
                rbFemale.setChecked(true);
            }
        }

        // BMI 계산 버튼 클릭 이벤트
        btnCalculateBMI.setOnClickListener(v -> {
            try {
                // 입력값 가져오기
                String name = etName.getText().toString().trim();
                int age = Integer.parseInt(etAge.getText().toString().trim());
                double height = Double.parseDouble(etHeight.getText().toString().trim());
                double weight = Double.parseDouble(etWeight.getText().toString().trim());

                // 성별 확인
                String gender = "";
                int selectedGenderId = rgGender.getCheckedRadioButtonId();
                if (selectedGenderId == R.id.rb_male) {
                    gender = "남자";
                } else if (selectedGenderId == R.id.rb_female) {
                    gender = "여자";
                }

                if (gender.isEmpty()) {
                    Toast.makeText(this, "성별을 선택하세요.", Toast.LENGTH_SHORT).show();
                    return;
                }

                // BMI 계산
                double bmi = weight / Math.pow(height / 100, 2);
                String bmiMessage = "BMI: " + String.format("%.2f", bmi);

                // 결과 표시
                Toast.makeText(this, bmiMessage, Toast.LENGTH_LONG).show();
            } catch (NumberFormatException e) {
                Toast.makeText(this, "유효한 값을 모두 입력하세요.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
