package com.example.anjali.register;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Registerform_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerform_);

        final EditText editText=(EditText)findViewById(R.id.editText6);
        final EditText editText1=(EditText) findViewById(R.id.editText7);
        Button button =(Button)findViewById(R.id.button);
        final SharedPreferences sharedPreferences=this.getSharedPreferences("prefs",MODE_PRIVATE);
       button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String ed=editText.getText().toString();
                String ed1=editText1.getText().toString();

                Intent intent=new Intent(Registerform_Activity.this,MainActivity.class);
                intent.putExtra("username",editText.getText().toString());
                intent.putExtra("password",editText1.getText().toString());

                sharedPreferences.edit().putString("username",ed).apply();
                sharedPreferences.edit().putString("password",ed1).apply();

                String username= sharedPreferences.getString("username","");
                String password=sharedPreferences.getString("password","");

                Log.i("Button Clicked",username);
                Log.i("Button Clicked",password);

                startActivity(intent);
            }
        });
    }
}
