package de.haw_hamburg.dailymanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Spinner;

import java.lang.reflect.GenericArrayType;

public class AddEntryActivity extends AppCompatActivity {

    int getYear;
    int getMonth;
    int getDay;

    int remindOption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_entry);

        final EditText editTime = findViewById(R.id.editTime);
        final EditText editName = findViewById(R.id.editName);
        final EditText editLocation = findViewById(R.id.editLocation);
        final EditText editNote = findViewById(R.id.editNote);
        final Spinner spinner = findViewById(R.id.spinner);
        Button buttonSave = findViewById(R.id.buttonSave);
        final CalendarView calendarViewEvent = findViewById(R.id.calendarViewEvent);

        //Spinner mit Werte füllen
        String[] arraySpinner = new String[] {
                "keine", "15 min vorher", "30 min vorher", "1 Stunde vorher",
                "morgens um 08:00", "1 Tag vorher","andere Zeit"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        //Spinner Onselected
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                remindOption = position;
                Log.i("checkEvent",String.valueOf(remindOption));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //Calender SetOnDateChange Listener
        calendarViewEvent.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                getYear=year;
                getMonth=month;
                getDay=dayOfMonth;
            }
        });




        //Save Button Onclick
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getTime = editTime.getText().toString();
                String eventName = editName.getText().toString();

                String date = String.valueOf(calendarViewEvent.getDate());

                String[] splitTime = getTime.split(":");

                int hour = Integer.parseInt(splitTime[0]);
                int min = Integer.parseInt(splitTime[1]);

                String location = editLocation.getText().toString();

                String note = editNote.getText().toString();

                //String remindOption = spinner.getTransitionName();
                //Log.i("checkEvent", "Year: " + String.valueOf(getYear) + " Month: " + String.valueOf(getMonth)+ " Day: " + String.valueOf(getDay));

                Event myEvent = new Event( getYear,  getMonth,  getDay,  hour,  min, eventName, location, note, remindOption);
                Log.i("checkEvent" , myEvent.toString());

                WriterService.writeObject(AddEntryActivity.this, myEvent);

                Intent intent = new Intent(AddEntryActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });



    }


}

