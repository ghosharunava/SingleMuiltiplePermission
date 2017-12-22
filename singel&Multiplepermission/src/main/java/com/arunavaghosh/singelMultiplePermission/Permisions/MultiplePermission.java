package com.arunavaghosh.singelMultiplePermission.Permisions;
/**
 * Created by Arunava MB Ghosh on 12/20/2017.
 */


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.Manifest.permission.BODY_SENSORS;
import static android.Manifest.permission.CALL_PHONE;
import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.READ_CALENDAR;
import static android.Manifest.permission.READ_CONTACTS;
import static android.Manifest.permission.RECORD_AUDIO;
import static android.Manifest.permission.SEND_SMS;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

/**
 * Created by Android on 12/20/2017.
 */

public class MultiplePermission {
    List<String> not_granted = new ArrayList<>();
    List<String> denied = new ArrayList<>();
    Context mContext;

    private static final int PERMISSION_REQUEST_CODE = 99;

    public MultiplePermission(Context context, MultiplePermission.GetPermissionResult getPermissionResult, String... reqName ){

        mContext=context;
        for(String Permssion_name : reqName )
        {

            switch (Permssion_name) {
                case "Location" :
                    if (ContextCompat.checkSelfPermission(context.getApplicationContext(), ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED)
                    {
                        getPermissionResult.getPermissionMessage("Location Ok");
                    } else {
                        //  getPermissionResult.getPermissionMessage("Not OK");
                        // ActivityCompat.requestPermissions((Activity) context, new String[]{ACCESS_FINE_LOCATION}, PERMISSION_REQUEST_CODE);
                        not_granted.add("android.permission.ACCESS_FINE_LOCATION");
                    }
                    break;
                case "Camera" :
                    if (ContextCompat.checkSelfPermission(context.getApplicationContext(), CAMERA) == PackageManager.PERMISSION_GRANTED)

                    {
                        getPermissionResult.getPermissionMessage("Camera Ok");

                    } else {
                        //getPermissionResult.getPermissionMessage("Not OK");
                        not_granted.add("android.permission.CAMERA");
                        // ActivityCompat.requestPermissions((Activity) context, new String[]{CAMERA}, PERMISSION_REQUEST_CODE);
                    }
                    break;

                case "File_STORAGE" :
                    if (ContextCompat.checkSelfPermission(context.getApplicationContext(),WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)
                    {
                        getPermissionResult.getPermissionMessage("WRITE_EXTERNAL_STORAGE Ok");
                    }
                    else {

                        not_granted.add("android.permission.WRITE_EXTERNAL_STORAGE");
                    }
                    break;
                case "SMS" :
                    if (ContextCompat.checkSelfPermission(context.getApplicationContext(),SEND_SMS) == PackageManager.PERMISSION_GRANTED)
                    {
                        getPermissionResult.getPermissionMessage("SEND_SMS Ok");
                    }
                    else {

                        not_granted.add("android.permission.SEND_SMS");
                    }
                    break;

                case "CALENDAR" :
                    if (ContextCompat.checkSelfPermission(context.getApplicationContext(),READ_CALENDAR) == PackageManager.PERMISSION_GRANTED)
                    {
                        getPermissionResult.getPermissionMessage("READ_CALENDAR Ok");
                    }
                    else {

                        not_granted.add("android.permission.READ_CALENDAR");
                    }
                    break;

                case "CONTACTS" :
                    if (ContextCompat.checkSelfPermission(context.getApplicationContext(),READ_CONTACTS) == PackageManager.PERMISSION_GRANTED)
                    {
                        getPermissionResult.getPermissionMessage("READ_CONTACTS Ok");
                    }
                    else {

                        not_granted.add("android.permission.READ_CONTACTS");
                    }
                    break;




                case "CALL_PHONE" :
                    if (ContextCompat.checkSelfPermission(context.getApplicationContext(),CALL_PHONE) == PackageManager.PERMISSION_GRANTED)
                    {
                        getPermissionResult.getPermissionMessage("CALL_PHONE Ok");
                    }
                    else {

                        not_granted.add("android.permission.CALL_PHONE");
                    }
                    break;

                case "Record_Audio" :
                    if (ContextCompat.checkSelfPermission(context.getApplicationContext(),RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED)
                    {
                        getPermissionResult.getPermissionMessage("RECORD_AUDIO Ok");
                    }
                    else {

                        not_granted.add("android.permission.RECORD_AUDIO");
                    }
                    break;
                case "Sensors" :
                    if (ContextCompat.checkSelfPermission(context.getApplicationContext(),BODY_SENSORS) == PackageManager.PERMISSION_GRANTED)
                    {
                        getPermissionResult.getPermissionMessage("BODY_SENSORS Ok");
                    }
                    else {

                        not_granted.add("android.permission.BODY_SENSORS");
                    }
                    break;

            }

        }
        /**
         *  requestPermissions methods
         */
        if(not_granted.size()>0){

            String[] array = not_granted.toArray(new String[not_granted.size()]);
            ActivityCompat.requestPermissions((Activity) context,array, PERMISSION_REQUEST_CODE);

            for(int j=0;j<not_granted.size();j++){


                if (ContextCompat.checkSelfPermission(context.getApplicationContext(), not_granted.get(j)) == PackageManager.PERMISSION_GRANTED)

                {
                    // getPermissionResult.getPermissionMessage("Camera Ok");

                }else
                {
                    denied.add( not_granted.get(j));

                }

            }
        }
        if(denied.size()>0){

            for (int i=0;i<denied.size();i++){

                boolean flag= ActivityCompat.shouldShowRequestPermissionRationale((Activity) context, denied.get(i));


                if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) context, denied.get(i)))
                {
                    Toast.makeText((Activity) context, "MEssage show", Toast.LENGTH_SHORT).show();
                }
                else {

                    if (Appdata.Camera_flag.equals("true")) {

                    }
                    else
                    {
                        Toast.makeText((Activity) context, "Settings", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent();
                        intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                        Uri uri = Uri.fromParts("package", context.getPackageName(), null);
                        intent.setData(uri);
                        context.startActivity(intent);
                    }
                }

            }
            Appdata.Camera_flag = "false";
        }
    }
    public interface GetPermissionResult {
        void getPermissionMessage(String permissionStatus);
    }
}