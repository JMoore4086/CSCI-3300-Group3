package com.group3.peakmode;

import java.util.Scanner;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class ExerciseActivity extends AppCompatActivity {
    private Spinner spinnerGoal, spinnerLevel;
    private Button btnRecommend;
    private TextView tvRecommendation;

    private final String[] goals = {"Lose weight", "Build muscle", "Improve stamina"};
    private final String[] levels = {"Beginner", "Intermediate", "Advanced"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        spinnerGoal = findViewById(R.id.spinnerGoal);
        spinnerLevel = findViewById(R.id.spinnerLevel);
        btnRecommend = findViewById(R.id.btnRecommend);
        tvRecommendation = findViewById(R.id.tvRecommendation);


        ArrayAdapter<String> goalAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, goals);
        goalAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGoal.setAdapter(goalAdapter);

        ArrayAdapter<String> levelAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, levels);
        levelAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerLevel.setAdapter(levelAdapter);

        btnRecommend.setOnClickListener(v -> {
            int goal = spinnerGoal.getSelectedItemPosition() + 1;
            int level = spinnerLevel.getSelectedItemPosition() + 1;

            String recommendation = getRecommendation(goal, level);
            tvRecommendation.setText(recommendation);
        });


        Button btnGoToCalories = findViewById(R.id.btnGoToCalories);
        btnGoToCalories.setOnClickListener(v -> {
            Intent intent = new Intent(ExerciseActivity.this, CaloriesActivity.class);
            startActivity(intent);
        });
    }

    private String getRecommendation(int goal, int level) {
        if (goal == 1 && level == 1) {
            return "Start losing weight by creating a diet plan where you eat less calories than your body needs, this creates a caloric deficit which makes your body burn more fat for energy. As for workouts you can do to help, try using the treadmill or running for 15 minutes and additionally you can do lightweight exercises to maintain muscle mass as you lose fat.";
        } else if (goal == 1 && level == 2) {
            return "Create a meal plan that puts you in a caloric deficit while focusing on moderate intensity cardio workouts for about 30 minutes, especially running or swimming. An easy way to make sure you hit the right intensity is to play sports, which aren't too intense but still require some effort.";
        } else if (goal == 1 && level == 3) {
            return "Eat in a caloric deficit while doing high intensity cardio workouts for 45 minutes to 1 hour. The best options for cardio workouts could be to include High Intensity Interval Training circuits into your routine, where you give yourself less recovery time per set than you spend time doing the set. Additionally, make sure you run or swim for extended periods of time to burn more calories. Calisthenics are also a great option to burn additional calories so long as they are done in a high rep range, for example at least 50 pushups in one attempt is a good baseline";
        } else if (goal == 2 && level == 1) {
            return "In order to gain muscle it is often easiest to start with body weight exercises such as pushups, squats, sit-ups, planks, and pull-ups and move from there onto doing weighted exercises. Initially, do as many as you can for each of these sets and then attempt to hit that goal in that exercise 2 more times in one session and be consistent. Also focus on intaking about 1 gram or more of protein per 1lb that you weigh.";
        } else if (goal == 2 && level == 2) {
            return "Eat a high-protien diet while being consistently working out at least 4 days a week. Focus on heavy weighted exercises in the gym such as the bench press and its variations, lateral pull downs, shoulder press, squat racks, hamstring machines, ab machines, and many workouts on the cable machine. Additionally, make use of the dumbbell rack at the gym to do many variations of curls, shoulder fly's, or forearm workouts.";
        } else if (goal == 2 && level == 3) {
            return "Make a diet plan that helps you bulk up with high protein and carbohydrates for energy and calorie excess. Maintain high intensity weighted exercises with a low rep range (4-6) per set with as heavy of a weight as you can manage. Do this on every machine at the gym that you like, but never skip out of cable machines, flat and incline bench press, and the squat rack. Also include workouts to hit every muscle group you can, maximizing your potential gain in muscle weight. Use dumbbells at a moderate to heavy weight for training your arms in general. Make sure to workout 4-5 days a week and to avoid alcohol as it kills gains.";
        } else if (goal == 3 && level == 1) {
            return "To improve stamina you need to maintain a healthy and balanced diet with enough carbohydrates to support your caloric needs. Make sure to do body weight exercises like pushups, squats, sit-ups, planks, and pull-ups but do as many as you can each time. Also do as much cardio as you can manage, constantly aim to outperform yourself.";
        } else if (goal == 3 && level == 2) {
            return "Improve your stamina by eating a healthy and balanced diet filled with protein and carbohydrates, ideally from nutrient dense sources like nuts and meat. Do as many calisthenic exercises or weighted exercises as you know and constantly try to at least reach the same rep count as before, if not more but be careful not to burn yourself out too much and give yourself plenty of rest if you do. Do moderate intensity cardio exercises and try to contstantly improve your time on a run, for example.";
        } else if (goal == 3 && level == 3) {
            return "Eat a healthy and balanced diet that gives you a surplus of energy with a lot of protein and carbohydrates, especially food made with calorie efficient ingredients. Try High Intensity Interval Training circuits for both calisthenics and your normal weighted exercise routine. While maintaining that high intensity, opt to go for as high of a rep range as you possibly can for the weight that you do, only increasing the weight when it becomes too easy. Do intense cardio for at least 1 hour and be very consistent in working out 5 days a week.";
        } else {
            return "Invalid input. Please select valid options.";
        }
    }
}