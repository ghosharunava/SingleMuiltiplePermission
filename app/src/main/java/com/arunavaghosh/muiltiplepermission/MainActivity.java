package com.arunavaghosh.muiltiplepermission;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.arunavaghosh.singelMultiplePermission.Permisions.MultiplePermission;

public class MainActivity extends AppCompatActivity {

    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new MultiplePermission(MainActivity.this, new MultiplePermission.GetPermissionResult() {
                    @Override
                    public void getPermissionMessage(String permissionStatus) {

                        if(permissionStatus.equals("OK")){
                            Toast.makeText(MainActivity.this, "All Permissipon is taken", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(MainActivity.this, "Not All Permissipon is taken", Toast.LENGTH_SHORT).show();
                        }
                    }
                },"Location","Camera"/*,"Camera","File_STORAGE","SMS","CALENDAR","CONTACTS","CALL_PHONE","Record_Audio","Sensors"*/);

            }
        });


    }
}
