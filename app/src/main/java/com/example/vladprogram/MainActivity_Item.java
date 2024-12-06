//package com.example.vladprogram;
//
//import android.os.Bundle;
//import android.os.Handler;
//import android.os.Looper;
//import android.os.SystemClock;
//import android.view.View;
//import android.widget.Button;
//import android.widget.TextView;
//
//import androidx.activity.EdgeToEdge;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.graphics.Insets;
//import androidx.core.view.ViewCompat;
//import androidx.core.view.WindowInsetsCompat;
//
//import com.google.android.material.button.MaterialButton;
//
//import java.text.MessageFormat;
//import java.util.Locale;
//
//public class MainActivity_Item extends AppCompatActivity {
//    TextView time_text;
//    Button reset, start, stop;
//    int seconds, minutes, milliSeconds;
//    long millisecondTime, startTime, timeBuff, updateTime = 0L ;
//    Handler handler;
//
//
//
//    public final Runnable runnable = new Runnable() {
//        @Override
//        public void run() {
//            millisecondTime = SystemClock.uptimeMillis() - startTime;
//            updateTime = timeBuff + millisecondTime;
//            seconds = (int) (updateTime / 1000);
//            minutes = seconds / 60;
//            seconds = seconds % 60;
//            milliSeconds = (int) (updateTime % 1000);
//
//            time_text.setText(String.format("%d:%02d", minutes, seconds));
//            handler.postDelayed(this, 0);
//        }
//    };
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_main_item);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
//
//        time_text = findViewById(R.id.time_text);
//        stop = findViewById(R.id.end1);
//        start = findViewById(R.id.button_one_client);
//        handler = new Handler(Looper.getMainLooper());
//
//        startTime = SystemClock.uptimeMillis();
//        handler.postDelayed(runnable, 0);
//
//        start.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startTime = SystemClock.uptimeMillis();
//                handler.postDelayed(runnable, 0);
//                reset.setEnabled(false);
//                stop.setEnabled(true);
//                start.setEnabled(false);
//            }
//        });
//
//        stop.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                timeBuff += millisecondTime;
//                handler.removeCallbacks(runnable);
//                reset.setEnabled(true);
//                stop.setEnabled(false);
//                start.setEnabled(true);
//            }
//        });
//        time_text.setText("00:00");
//    }
//}