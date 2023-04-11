package com.nice.notifection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button click;
    TextView numm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        click=findViewById(R.id.click);
        numm=findViewById(R.id.numm);


      Calendar calendar=Calendar.getInstance();
   //     SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yy  hh:mm:ss");
        SimpleDateFormat sdf=new SimpleDateFormat(" hh:mm dd MM ");
        String mm=sdf.format(calendar.getTime());

        numm.setText(mm);


        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                numm.setText(mm);



                if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){

     NotificationChannel channel=new NotificationChannel("My noti","my secand ",NotificationManager.IMPORTANCE_DEFAULT);
                    NotificationManager manager=getSystemService(NotificationManager.class);
                    manager.createNotificationChannel(channel);

                }





                NotificationCompat.Builder builder=new NotificationCompat.Builder(MainActivity.this,"My noti");
                 builder.setContentTitle("My Title");
                 builder.setContentText("Nice noti from saber");
                 builder.setSmallIcon(R.drawable.mass);
                 builder.setAutoCancel(true);
                NotificationManagerCompat managerCompat=NotificationManagerCompat.from(MainActivity.this);
                managerCompat.notify(1,builder.build());










            }
        });


    }
}