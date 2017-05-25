package org.androidtown.fragment.lab;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    public static final String filePath = "notes.txt";
    EditText editText;

    File sdCard = Environment.getExternalStorageDirectory();
    File directory = new File(sdCard.getAbsolutePath() );
    final File file = new File(directory, filePath);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.editText);//find id==editText
        directory.mkdir();
    }
    public void onButton1Clicked(View v) {


        try {
            FileOutputStream out = new FileOutputStream(file);
            OutputStreamWriter osw = new OutputStreamWriter(out);
            osw.write(editText.getText().toString()); //Write the contents of the editTest on the SD card.
            osw.close();

        } catch (Throwable t) {

            Toast.makeText(getApplicationContext(),"Write the file.", Toast.LENGTH_LONG).show();
        }

    }

    public void onButton2Clicked(View v) {


        editText.setText("");//Remove text from the edit text

    }

    public void onButton3Clicked(View v) {

        String read = new String();
        try {
            FileInputStream in = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(in);

            int content;
            while ((content = isr.read()) != -1) { //Read the string until there are no characters.

                read += (char) content;
            }
            isr.close();
            editText.setText(read);  //Bring the string to the EDIT test.
        } catch (Throwable t) {

            Toast.makeText(getApplicationContext(), "read the Text", Toast.LENGTH_LONG).show();
        }


    }

    public void onButton4Clicked(View v) {


        finish();//App exit

    }

}

