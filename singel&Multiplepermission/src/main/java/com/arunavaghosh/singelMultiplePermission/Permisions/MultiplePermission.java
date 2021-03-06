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
import static android.Manifest.permission.WRITE_CALENDAR;
import static android.Manifest.permission.WRITE_CONTACTS;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

/**
 * Created by Android on 12/20/2017.
 */

public class MultiplePermission {

    List<String> not_granted = new ArrayList<>();
    List<String> denied = new ArrayList<>();
    List<Integer> Sennt_permission_count = new ArrayList<>();
    List<Integer> Grant_permission_count = new ArrayList<>();
    List<String> Permission_shouldshow = new ArrayList<>();
    Context mContext;
    int counter=0;

    private static final int PERMISSION_REQUEST_CODE = 99;

    public MultiplePermission(Context context, MultiplePermission.GetPermissionResult getPermissionResult, String... reqName ){


        mContext=context;
        for(String Permssion_name : reqName )
        {
            counter=counter+1;
            Sennt_permission_count.add(counter);


            switch (Permssion_name) {
                case "Location" :
                    if (ContextCompat.checkSelfPermission(context.getApplicationContext(), ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED)
                    {
                        Grant_permission_count.add(1);
                    } else {

                        not_granted.add("android.permission.ACCESS_FINE_LOCATION");
                    }
                    break;
                case "Camera" :
                    if (ContextCompat.checkSelfPermission(context.getApplicationContext(), CAMERA) == PackageManager.PERMISSION_GRANTED)

                    {
                        Grant_permission_count.add(1);

                    } else {
                        not_granted.add("android.permission.CAMERA");

                    }
                    break;

                case "File_STORAGE" :
                    if (ContextCompat.checkSelfPermission(context.getApplicationContext(),WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)
                    {
                        Grant_permission_count.add(1);
                    }
                    else {

                        not_granted.add("android.permission.WRITE_EXTERNAL_STORAGE");
                    }
                    break;
                case "SMS" :
                    if (ContextCompat.checkSelfPermission(context.getApplicationContext(),SEND_SMS) == PackageManager.PERMISSION_GRANTED)
                    {
                        Grant_permission_count.add(1);
                    }
                    else {

                        not_granted.add("android.permission.SEND_SMS");
                    }
                    break;

                case "CALENDAR" :
                    if (ContextCompat.checkSelfPermission(context.getApplicationContext(),WRITE_CALENDAR) == PackageManager.PERMISSION_GRANTED)
                    {

                        Grant_permission_count.add(1);
                    }
                    else {

                        not_granted.add("android.permission.WRITE_CALENDAR");
                    }
                    break;

                case "CONTACTS" :
                    if (ContextCompat.checkSelfPermission(context.getApplicationContext(),WRITE_CONTACTS) == PackageManager.PERMISSION_GRANTED)
                    {

                        Grant_permission_count.add(1);
                    }
                    else {

                        not_granted.add("android.permission.WRITE_CONTACTS");
                    }
                    break;
                case "CALL_PHONE" :
                    if (ContextCompat.checkSelfPermission(context.getApplicationContext(),CALL_PHONE) == PackageManager.PERMISSION_GRANTED)
                    {

                        Grant_permission_count.add(1);
                    }
                    else {

                        not_granted.add("android.permission.CALL_PHONE");
                    }
                    break;

                case "Record_Audio" :
                    if (ContextCompat.checkSelfPermission(context.getApplicationContext(),RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED)
                    {

                        Grant_permission_count.add(1);
                    }
                    else {

                        not_granted.add("android.permission.RECORD_AUDIO");
                    }
                    break;
                case "Sensors" :
                    if (ContextCompat.checkSelfPermission(context.getApplicationContext(),BODY_SENSORS) == PackageManager.PERMISSION_GRANTED)
                    {

                        Grant_permission_count.add(1);
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


            for(int j=0;j<not_granted.size();j++)
            {
                if (ContextCompat.checkSelfPermission(context.getApplicationContext(), not_granted.get(j)) == PackageManager.PERMISSION_GRANTED)

                {

                    Grant_permission_count.add(1);
                }
                else
                {
                    denied.add( not_granted.get(j));

                }

            }

        }


        if(denied.size()>0){


            for (int i=0;i<denied.size();i++)
            {

                boolean flag= ActivityCompat.shouldShowRequestPermissionRationale((Activity) context, denied.get(i));


                //shouldShowRequestPermissionRationale,if we chekh dont ask me again agsinst chekh box then
                if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) context, denied.get(i)))
                {
                    Toast.makeText((Activity) context, "MEssage show", Toast.LENGTH_SHORT).show();
                    Permission_shouldshow.add("show");
                }
                else {


                }

            }
            if (!(Permission_shouldshow.size()>0))
            {

                if (Appdata.Camera_flag.equals("true")) {

                    Appdata.Camera_flag = "false";

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
     // Toast.makeText(context, "3 Grant Counter\n"+Permission_shouldshow.size(), Toast.LENGTH_SHORT).show();

        if(Sennt_permission_count.size()==Grant_permission_count.size()){

            getPermissionResult.getPermissionMessage("OK");

        }
        else{

            getPermissionResult.getPermissionMessage("Not Ok");

        }


    }
    public interface GetPermissionResult {
        void getPermissionMessage(String permissionStatus);
    }
}