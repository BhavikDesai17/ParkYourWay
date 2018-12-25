package com.example.bhavik.navigation;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;

public class Time_Picker extends AppCompatActivity {
    int year = Calendar.getInstance().get(Calendar.YEAR);
    private static TextView text_ViewA;
    private static TextView text_ViewMA;
    private static TextView text_ViewFA;
    private static TextView text_viewHA;
    private static TextView text_ViewL;
    private static TextView text_viewML;
    private static TextView text_viewFL;
    private static TextView text_viewMinA;
    private static TextView text_viewForA;
    private static TextView text_ViewHL;
    private static TextView text_ViewMinL;
    private static TextView text_ViewForL;
    private static TextView text_viewDate;
    private static Calendar currenttime;
    int hour,minute,month,year1;
    int hour1,minute1,hour2,minute2;
    String format1,format2;
    String finalTimeArriving,finalTimeLeaving,finalTime;
    String format,date;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time__picker);
        text_ViewA = (TextView)findViewById(R.id.timerView); //Arriving Hour Time
        text_ViewMA = (TextView)findViewById(R.id.textView13); //Arriving Min Time
        text_ViewFA = (TextView)findViewById(R.id.textView14); //Arriving Format
        text_viewHA = (TextView)findViewById(R.id.finalView); //Final Hour of Arrival Booking
        text_ViewL = (TextView) findViewById(R.id.textView4); //Leaving Hour Time
        text_viewML = (TextView) findViewById(R.id.textView16); //Leaving Minute Time
        text_viewFL = (TextView) findViewById(R.id.textView17); //Leaving Format
        text_ViewHL = (TextView) findViewById(R.id.textView19); //Final Hour of Leaving Booking
        text_ViewMinL = (TextView) findViewById(R.id.textView21); //Final Min of Leaving Booking
        text_ViewForL = (TextView) findViewById(R.id.textView23); //Final Format of Leaving Booking
        text_viewMinA = (TextView)findViewById(R.id.textView6); //Final Minute of Arrival Booking
        text_viewForA = (TextView)findViewById(R.id.textView7); //Format of arrival booking
        text_viewDate = (TextView)findViewById(R.id.textView11); //Date
        currenttime = Calendar.getInstance();
        date = DateFormat.getDateInstance(DateFormat.FULL).format(currenttime.getTime());
        month = currenttime.get(Calendar.MONTH);
        year1 = currenttime.get(Calendar.YEAR);
        hour = currenttime.get(Calendar.HOUR_OF_DAY);
        minute = currenttime.get(Calendar.MINUTE);
        selectedTimeFormat(hour);
        text_viewDate.setText("  " + date);
        text_ViewA.setText(" " + hour);
        text_ViewMA.setText(" " + minute);
        text_ViewFA.setText(" " + format);
        text_ViewA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showYearDialog();
            }
        });
        text_ViewL.setText(" " + hour);
        text_viewML.setText(" " + minute);
        text_viewFL.setText(" " + format);
        text_ViewL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showYearDialog1();
            }
        });
        /*text_View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(Time_Picker.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        selectedTimeFormat(hourOfDay);
                        text_View.setText("Arriving Time : " + hourOfDay + ":" + minute + " " + format);
                        finalTimeArriving = String.valueOf(hourOfDay).toString() + ":" + String.valueOf(minute).toString() + " " + String.valueOf(format).toString();
                    }
                },hour,minute,true);
                timePickerDialog.show();
            }
        });
        text_View2.setText("Leaving Time : " + hour + ":" + minute + " " + format);
        text_View2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(Time_Picker.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        selectedTimeFormat(hourOfDay);
                        text_View2.setText("Leaving Time : " + hourOfDay + ":" + minute + " " + format);
                        finalTimeLeaving = String.valueOf(hourOfDay).toString() + ":" + String.valueOf(minute).toString() + " " + String.valueOf(format).toString();
                        finalTime = "  " + finalTimeArriving + "-" + finalTimeLeaving;
                        text_view1.setText(finalTime);
                    }
                },hour,minute,true);
                timePickerDialog.show();
            }
        });*/
    }

    private void showYearDialog1() {
        selectedTimeFormat(hour);
        final Dialog d = new Dialog(Time_Picker.this);
        d.setTitle("Time Picker");
        d.setContentView(R.layout.activity_time_picker_dialog);
        Button set = (Button)d.findViewById(R.id.button1);
        Button cancel = (Button)d.findViewById(R.id.button2);
        TextView year_text = (TextView)d.findViewById(R.id.title_text);
        year_text.setText("Leaving Time");
        final NumberPicker nopicker = (NumberPicker)d.findViewById(R.id.numberPicker1);
        final NumberPicker nopicker1 = (NumberPicker)d.findViewById(R.id.numberPicker2);
        nopicker.setMaxValue(23);
        nopicker.setMinValue(hour);
        nopicker.setWrapSelectorWheel(false);
        nopicker.setValue(hour);
        nopicker.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);

        nopicker1.setMaxValue(59);
        nopicker1.setMinValue(minute);
        nopicker1.setWrapSelectorWheel(false);
        nopicker1.setValue(minute);
        nopicker1.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);

        nopicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                if(nopicker.getValue()==hour){
                    nopicker1.setMinValue(minute);
                }else{
                    nopicker1.setMinValue(0);
                }
            }
        });

        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_ViewL.setText(String.valueOf(nopicker.getValue()));
                text_viewML.setText(String.valueOf(nopicker1.getValue()));
                text_viewFL.setText(String.valueOf(format));
                hour2 = nopicker.getValue();
                minute2 = nopicker1.getValue();
                format2 = String.valueOf(format);
                text_ViewHL.setText("   " + hour2);
                text_ViewMinL.setText(" " + minute2);
                text_ViewForL.setText("" + format2);
                d.dismiss();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d.dismiss();
            }
        });
        d.show();
    }

    private void showYearDialog() {
        selectedTimeFormat(hour);
        final Dialog d = new Dialog(Time_Picker.this);
        d.setTitle("Year Picker");
        d.setContentView(R.layout.activity_time_picker_dialog);
        Button set = (Button)d.findViewById(R.id.button1);
        Button cancel = (Button)d.findViewById(R.id.button2);
        TextView year_text = (TextView)d.findViewById(R.id.title_text);
        year_text.setText("Arriving Time");
        final NumberPicker nopicker = (NumberPicker)d.findViewById(R.id.numberPicker1);
        final NumberPicker nopicker1 = (NumberPicker)d.findViewById(R.id.numberPicker2);
        nopicker.setMaxValue(23);
        nopicker.setMinValue(hour);
        nopicker.setWrapSelectorWheel(false);
        nopicker.setValue(hour);
        nopicker.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);

        nopicker1.setMaxValue(59);
        nopicker1.setMinValue(minute);
        nopicker1.setWrapSelectorWheel(false);
        nopicker1.setValue(minute);
        nopicker1.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);

        nopicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                if(nopicker.getValue()==hour){
                    nopicker1.setMinValue(minute);
                }else{
                    nopicker1.setMinValue(0);
                }
            }
        });

        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_ViewA.setText(String.valueOf(nopicker.getValue()));
                text_ViewMA.setText(String.valueOf(nopicker1.getValue()));
                text_ViewFA.setText(String.valueOf(format));
                hour1 = nopicker.getValue();
                minute1 = nopicker1.getValue();
                format1 = String.valueOf(format);
                text_viewHA.setText("  " + hour1);
                text_viewMinA.setText(" " + minute1);
                text_viewForA.setText("" + format1);
                d.dismiss();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d.dismiss();
            }
        });
        d.show();
    }

    public void selectedTimeFormat(int hour){
        if(hour == 0){
            hour += 12;
            format = "AM";
        }else if(hour == 12){
            format ="PM";
        }else if(hour > 12){
            hour -= 12;
            format = "PM";
        }else{
            format = "AM";
        }
    }
}
