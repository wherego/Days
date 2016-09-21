package com.houxy.days.common;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.houxy.days.C;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Houxy on 2016/9/13.
 */
public class DialogUtil {


    /**
     *
     * @param activity
     * @param calendar
     */
    public static void showDatePickerDialog(Activity activity,Calendar calendar, DatePickerDialog.OnDateSetListener dateSetListener) {


        // 直接创建一个DatePickerDialog对话框实例，并将它显示出来
        new DatePickerDialog(activity, dateSetListener
                , calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), // 设置初始日期
                calendar.get(Calendar.DAY_OF_MONTH)).show();
    }

    public static void showSelectPicDialog(final Activity activity){
        new AlertDialog.Builder(activity).setItems(new String[]{"相册", "照相机", "取消"}, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0:
                        activity.startActivityForResult(UploadPictureUtil.getUploadIntent(C.PICK_FROM_FILE), C.PICK_FROM_FILE);
                        break;
                    case 1:
                        activity.startActivityForResult(UploadPictureUtil.getUploadIntent(C.PICK_FROM_CAMERA), C.PICK_FROM_CAMERA);
                        break;
                    case 2:
                        dialog.dismiss();
                        break;
                }
            }
        }).create().show();
    }

    public static void showSingleChoiceDialog(Activity activity, String title, final String[] choices, DialogInterface.OnClickListener onClickListener){

        new AlertDialog.Builder(activity).setTitle(title).setSingleChoiceItems(choices, 0, onClickListener)
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }).create().show();
    }

}
