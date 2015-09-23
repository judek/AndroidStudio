package com.judek.myapplication;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.view.View;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;





public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new OnClickListener()
        {
            public void onClick(View v)
            {
                TextView iv = (TextView) findViewById(R.id.textView);
                java.util.Date date= new java.util.Date();
                System.out.println(new Timestamp(date.getTime()));
                Timestamp ts = new Timestamp(date.getTime());
                String S =new SimpleDateFormat("MM/dd/yyyy h:mm:ss a").format(ts);
                iv.setText(S);

                ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);

                //We need API 11
                //ClipData clip = ClipData.newPlainText("label", "Text to copy");
                //clipboard.setPrimaryClip(clip);

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
