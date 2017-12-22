package com.arunavaghosh.muiltiplepermission;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.arunavaghosh.singelMultiplePermission.Permisions.MultiplePermission;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       new MultiplePermission(MainActivity.this, new MultiplePermission.GetPermissionResult() {
           @Override
           public void getPermissionMessage(String permissionStatus) {

           }
       },"Location","Camera","File_STORAGE","SMS","CALENDAR","CONTACTS","CALL_PHONE","Record_Audio","Sensors");

    }
}
