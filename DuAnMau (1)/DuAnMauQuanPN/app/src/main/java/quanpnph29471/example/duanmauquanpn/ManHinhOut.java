package quanpnph29471.example.duanmauquanpn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;

public class ManHinhOut extends AppCompatActivity {
    LinearLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_out);
        layout = findViewById(R.id.id_LinearLayoutOut);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                layout.setVisibility(View.INVISIBLE);
                Intent intent = new Intent(ManHinhOut.this,ManHinhChinh.class);
                startActivity(intent);
            }
        },5000);
    }
}