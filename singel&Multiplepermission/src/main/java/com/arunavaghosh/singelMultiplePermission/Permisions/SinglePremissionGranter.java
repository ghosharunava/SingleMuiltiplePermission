package com.arunavaghosh.singelMultiplePermission.Permisions;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.Manifest.permission.ADD_VOICEMAIL;
import static android.Manifest.permission.BODY_SENSORS;
import static android.Manifest.permission.CALL_PHONE;
import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.GET_ACCOUNTS;
import static android.Manifest.permission.PROCESS_OUTGOING_CALLS;
import static android.Manifest.permission.READ_CALENDAR;
import static android.Manifest.permission.READ_CALL_LOG;
import static android.Manifest.permission.READ_CONTACTS;
import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.READ_PHONE_STATE;
import static android.Manifest.permission.READ_SMS;
import static android.Manifest.permission.RECEIVE_MMS;
import static android.Manifest.permission.RECEIVE_SMS;
import static android.Manifest.permission.RECEIVE_WAP_PUSH;
import static android.Manifest.permission.RECORD_AUDIO;
import static android.Manifest.permission.SEND_SMS;
import static android.Manifest.permission.USE_SIP;
import static android.Manifest.permission.WRITE_CALENDAR;
import static android.Manifest.permission.WRITE_CALL_LOG;
import static android.Manifest.permission.WRITE_CONTACTS;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

/**
 * Created by Android on 06-09-2017.
 */

public class SinglePremissionGranter {
    int PERMISSION_REQUEST_CODE = 99;



    public SinglePremissionGranter(Context context, int reqCode, GetPermissionResult getPermissionResult) {
        switch (reqCode) {
            case 1:
                if (ContextCompat.checkSelfPermission(context.getApplicationContext(), ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    getPermissionResult.getPermissionMessage("OK");

                } else {
                    ActivityCompat.requestPermissions((Activity) context, new String[]{ACCESS_FINE_LOCATION}, PERMISSION_REQUEST_CODE);
                }
                break;
            case 2:
                if (ContextCompat.checkSelfPermission(context.getApplicationContext(), CAMERA) == PackageManager.PERMISSION_GRANTED) {
                    getPermissionResult.getPermissionMessage(" OK");

                } else {
                    getPermissionResult.getPermissionMessage("NotOK");
                    ActivityCompat.requestPermissions((Activity) context, new String[]{CAMERA}, PERMISSION_REQUEST_CODE);

                    if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) context, Manifest.permission.CAMERA)) {
                        Toast.makeText((Activity) context, "MEssage show", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        if (Appdata.Camera_flag.equals("true")) {
                            Appdata.Camera_flag = "false";
                        }
                        else {
                            Toast.makeText((Activity) context, "Settings", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent();
                            intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                            Uri uri = Uri.fromParts("package", context.getPackageName(), null);
                            intent.setData(uri);
                            context.startActivity(intent);
                        }
                    }

                }
                break;
            case 3:
                if (ContextCompat.checkSelfPermission(context.getApplicationContext(), READ_CALENDAR) == PackageManager.PERMISSION_GRANTED) {
                    getPermissionResult.getPermissionMessage("OK");
                } else {
                    ActivityCompat.requestPermissions((Activity) context, new String[]{READ_CALENDAR}, PERMISSION_REQUEST_CODE);
                }
                break;
            case 4:
                if (ContextCompat.checkSelfPermission(context.getApplicationContext(), WRITE_CALENDAR) == PackageManager.PERMISSION_GRANTED) {
                    getPermissionResult.getPermissionMessage("OK");
                } else {
                    ActivityCompat.requestPermissions((Activity) context, new String[]{WRITE_CALENDAR}, PERMISSION_REQUEST_CODE);
                }
                break;
            case 5:
                if (ContextCompat.checkSelfPermission(context.getApplicationContext(), READ_CONTACTS) == PackageManager.PERMISSION_GRANTED) {
                    getPermissionResult.getPermissionMessage("OK");
                } else {
                    ActivityCompat.requestPermissions((Activity) context, new String[]{READ_CONTACTS}, PERMISSION_REQUEST_CODE);
                }
                break;
            case 6:
                if (ContextCompat.checkSelfPermission(context.getApplicationContext(), WRITE_CONTACTS) == PackageManager.PERMISSION_GRANTED) {
                    getPermissionResult.getPermissionMessage("OK");
                } else {
                    ActivityCompat.requestPermissions((Activity) context, new String[]{WRITE_CONTACTS}, PERMISSION_REQUEST_CODE);
                }
                break;
            case 7:
                if (ContextCompat.checkSelfPermission(context.getApplicationContext(), GET_ACCOUNTS) == PackageManager.PERMISSION_GRANTED) {
                    getPermissionResult.getPermissionMessage("OK");
                } else {
                    ActivityCompat.requestPermissions((Activity) context, new String[]{GET_ACCOUNTS}, PERMISSION_REQUEST_CODE);
                }
                break;
            case 8:
                if (ContextCompat.checkSelfPermission(context.getApplicationContext(), ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    getPermissionResult.getPermissionMessage("OK");
                } else {
                    ActivityCompat.requestPermissions((Activity) context, new String[]{ACCESS_COARSE_LOCATION}, PERMISSION_REQUEST_CODE);
                }
                break;
            case 9:
                if (ContextCompat.checkSelfPermission(context.getApplicationContext(), RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED) {
                    getPermissionResult.getPermissionMessage("OK");
                } else {
                    ActivityCompat.requestPermissions((Activity) context, new String[]{RECORD_AUDIO}, PERMISSION_REQUEST_CODE);
                }
                break;
            case 10:
                if (ContextCompat.checkSelfPermission(context.getApplicationContext(), READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED) {
                    getPermissionResult.getPermissionMessage("OK");
                } else {
                    ActivityCompat.requestPermissions((Activity) context, new String[]{READ_PHONE_STATE}, PERMISSION_REQUEST_CODE);
                }
                break;
            case 11:
                if (ContextCompat.checkSelfPermission(context.getApplicationContext(), CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                    getPermissionResult.getPermissionMessage("OK");
                } else {
                    ActivityCompat.requestPermissions((Activity) context, new String[]{CALL_PHONE}, PERMISSION_REQUEST_CODE);
                }
                break;
            case 12:
                if (ContextCompat.checkSelfPermission(context.getApplicationContext(), READ_CALL_LOG) == PackageManager.PERMISSION_GRANTED) {
                    getPermissionResult.getPermissionMessage("OK");
                } else {
                    ActivityCompat.requestPermissions((Activity) context, new String[]{READ_CALL_LOG}, PERMISSION_REQUEST_CODE);
                }
                break;
            case 13:
                if (ContextCompat.checkSelfPermission(context.getApplicationContext(), WRITE_CALL_LOG) == PackageManager.PERMISSION_GRANTED) {
                    getPermissionResult.getPermissionMessage("OK");
                } else {
                    ActivityCompat.requestPermissions((Activity) context, new String[]{WRITE_CALL_LOG}, PERMISSION_REQUEST_CODE);
                }
                break;
            case 14:
                if (ContextCompat.checkSelfPermission(context.getApplicationContext(), ADD_VOICEMAIL) == PackageManager.PERMISSION_GRANTED) {
                    getPermissionResult.getPermissionMessage("OK");
                } else {
                    ActivityCompat.requestPermissions((Activity) context, new String[]{ADD_VOICEMAIL}, PERMISSION_REQUEST_CODE);
                }
                break;
            case 15:
                if (ContextCompat.checkSelfPermission(context.getApplicationContext(), USE_SIP) == PackageManager.PERMISSION_GRANTED) {
                    getPermissionResult.getPermissionMessage("OK");
                } else {
                    ActivityCompat.requestPermissions((Activity) context, new String[]{USE_SIP}, PERMISSION_REQUEST_CODE);
                }
                break;
            case 16:
                if (ContextCompat.checkSelfPermission(context.getApplicationContext(), PROCESS_OUTGOING_CALLS) == PackageManager.PERMISSION_GRANTED) {
                    getPermissionResult.getPermissionMessage("OK");
                } else {
                    ActivityCompat.requestPermissions((Activity) context, new String[]{PROCESS_OUTGOING_CALLS}, PERMISSION_REQUEST_CODE);
                }
                break;
            case 17:
                if (ContextCompat.checkSelfPermission(context.getApplicationContext(), BODY_SENSORS) == PackageManager.PERMISSION_GRANTED) {
                    getPermissionResult.getPermissionMessage("OK");
                } else {
                    ActivityCompat.requestPermissions((Activity) context, new String[]{BODY_SENSORS}, PERMISSION_REQUEST_CODE);
                }
                break;
            case 18:
                if (ContextCompat.checkSelfPermission(context.getApplicationContext(), SEND_SMS) == PackageManager.PERMISSION_GRANTED) {
                    getPermissionResult.getPermissionMessage("OK");
                } else {
                    ActivityCompat.requestPermissions((Activity) context, new String[]{SEND_SMS}, PERMISSION_REQUEST_CODE);
                }
                break;
            case 19:
                if (ContextCompat.checkSelfPermission(context.getApplicationContext(), RECEIVE_SMS) == PackageManager.PERMISSION_GRANTED) {
                    getPermissionResult.getPermissionMessage("OK");
                } else {
                    ActivityCompat.requestPermissions((Activity) context, new String[]{RECEIVE_SMS}, PERMISSION_REQUEST_CODE);
                }
                break;
            case 20:
                if (ContextCompat.checkSelfPermission(context.getApplicationContext(), READ_SMS) == PackageManager.PERMISSION_GRANTED) {
                    getPermissionResult.getPermissionMessage("OK");
                } else {
                    ActivityCompat.requestPermissions((Activity) context, new String[]{READ_SMS}, PERMISSION_REQUEST_CODE);
                }
                break;
            case 21:
                if (ContextCompat.checkSelfPermission(context.getApplicationContext(), RECEIVE_WAP_PUSH) == PackageManager.PERMISSION_GRANTED) {
                    getPermissionResult.getPermissionMessage("OK");
                } else {
                    ActivityCompat.requestPermissions((Activity) context, new String[]{RECEIVE_WAP_PUSH}, PERMISSION_REQUEST_CODE);
                }
                break;
            case 22:
                if (ContextCompat.checkSelfPermission(context.getApplicationContext(), RECEIVE_MMS) == PackageManager.PERMISSION_GRANTED) {
                    getPermissionResult.getPermissionMessage("OK");
                } else {
                    ActivityCompat.requestPermissions((Activity) context, new String[]{RECEIVE_MMS}, PERMISSION_REQUEST_CODE);
                }
                break;
            case 23:
                if (ContextCompat.checkSelfPermission(context.getApplicationContext(), READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                    getPermissionResult.getPermissionMessage("OK");
                } else {
                    ActivityCompat.requestPermissions((Activity) context, new String[]{READ_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
                }
                break;
            case 24:
                if (ContextCompat.checkSelfPermission(context.getApplicationContext(), WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                    getPermissionResult.getPermissionMessage("OK");
                } else {
                    ActivityCompat.requestPermissions((Activity) context, new String[]{WRITE_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
                }
                break;
        }
    }


    public interface GetPermissionResult {
        void getPermissionMessage(String permissionStatus);
    }
}
