package com.reader.qr.productscan;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CheckUserActivity extends AppCompatActivity {

    private TextView cu_title;
    private EditText cu_username;
    private EditText cu_password;
    private EditText cu_reg_fullname;
    private EditText cu_reg_email;
    private Button btn_Continue;
    private Button btn_Register;
    private LinearLayout cy_fl;
    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_init);

        ImageView im = (ImageView)findViewById(R.id.init_logo);
        Animation slideDown = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_down);
        im.startAnimation(slideDown);

        new CountDownTimer(3000,1000){
            @Override
            public void onTick(long millisUntilFinished){}

            @Override
            public void onFinish(){
                //set the new Content of your activity
                CheckUserActivity.this.setContentView(R.layout.activity_check_user);
                Animation slideD = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_down);
                cy_fl = (LinearLayout)findViewById(R.id.cy_fl);
                cy_fl.startAnimation(slideD);
                cu_title = (TextView)findViewById(R.id.cu_title);
                cu_username = (EditText)findViewById(R.id.cu_username);
                cu_password = (EditText)findViewById(R.id.cu_password);
                cu_reg_fullname = (EditText)findViewById(R.id.cu_reg_fullname);
                cu_reg_email = (EditText)findViewById(R.id.cu_reg_email);
                btn_Continue = (Button)findViewById(R.id.cu_btnContinue);
                btn_Register = (Button)findViewById(R.id.cu_btnRegister);

                final Animation sequential = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.sequential);



                btn_Continue.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Animation alpha = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.alpha);

                        btn_Continue.startAnimation(alpha);
                        if(cu_title.getText().toString().equals("Login")){
                            Intent i = new Intent(getApplicationContext(), ContainerActivity.class);
                            startActivity(i);
                            finish();
                        }else if(cu_title.getText().toString().equals("Register") && btn_Continue.getText().toString().equals("Continue")){
                            Animation slideDown3 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_down);
                            cu_username.clearAnimation();
                            cu_username.setVisibility(View.GONE);
                            cu_reg_fullname.setVisibility(View.VISIBLE);
                            cu_reg_fullname.startAnimation(slideDown3);
                            cu_password.clearAnimation();
                            cu_password.setVisibility(View.GONE);
                            cu_reg_email.setVisibility(View.VISIBLE);
                            cu_reg_email.startAnimation(slideDown3);
                            btn_Register.setText("Back");
                            btn_Continue.setText("Done");
                        }else if(cu_title.getText().toString().equals("Register") && btn_Continue.getText().toString().equals("Done")){

                        }
                    }
                });
                btn_Register.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Animation alpha2 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.alpha);
                        btn_Register.startAnimation(alpha2);
                        if (btn_Register.getText().toString().equals("Register")){
                            Animation slideDown3 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_down);
                            cu_title.setText("Register");
                            btn_Register.setText("Cancel");
                            cu_username.startAnimation(slideDown3);
                            cu_password.startAnimation(slideDown3);
                        }else if(btn_Register.getText().toString().equals("Cancel")){
                            Animation slideDown3 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_down);
                            cu_title.setText("Login");
                            btn_Register.setText("Register");
                            cu_username.setText("");
                            cu_password.setText("");
                            cu_reg_fullname.clearAnimation();
                            cu_reg_fullname.setVisibility(View.GONE);
                            cu_username.setVisibility(View.VISIBLE);
                            cu_username.startAnimation(slideDown3);
                            cu_reg_email.clearAnimation();
                            cu_reg_email.setVisibility(View.GONE);
                            cu_password.setVisibility(View.VISIBLE);
                            cu_password.startAnimation(slideDown3);
                        }else if(btn_Register.getText().toString().equals("Back")){
                            Animation slideDown3 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_down);
                            btn_Register.setText("Cancel");
                            btn_Continue.setText("Continue");
                            cu_reg_fullname.clearAnimation();
                            cu_reg_fullname.setVisibility(View.GONE);
                            cu_username.setVisibility(View.VISIBLE);
                            cu_username.startAnimation(slideDown3);
                            cu_reg_email.clearAnimation();
                            cu_reg_email.setVisibility(View.GONE);
                            cu_password.setVisibility(View.VISIBLE);
                            cu_password.startAnimation(slideDown3);
                        }
                    }
                });
            }
        }.start();
    }
}
