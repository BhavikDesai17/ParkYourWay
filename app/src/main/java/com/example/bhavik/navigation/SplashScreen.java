package com.example.bhavik.navigation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash_screen);
        Thread loading = new Thread(){
            public void run() {
            try{
                sleep(5000);
                Intent main = new Intent(SplashScreen.this,Navigation.class);
                startActivity(main);
            }
            catch (Exception e){
                e.printStackTrace();
            }
            finally {
                finish();
            }
            }
        };
        loading.start();
    }
}
