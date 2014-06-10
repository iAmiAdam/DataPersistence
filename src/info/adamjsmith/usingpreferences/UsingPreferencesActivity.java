package info.adamjsmith.usingpreferences;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UsingPreferencesActivity extends Activity {
	
	EditText textBox;
	static final int READ_BLOCK_SIZE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        textBox = (EditText) findViewById(R.id.txtText1);
    }
    
    public void onClickLoad(View view) {
    	Intent i = new Intent("info.adamjsmith.AppPreferenceActivity");
    	startActivity(i);
    }
    
    public void onClickDisplay(View view) {
    	SharedPreferences appPrefs = getSharedPreferences("info.adamjsmith.usingpreferences_preferences", MODE_PRIVATE);
    	DisplayText(appPrefs.getString("editTextPref", "test"));
    }
    
    public void onClickModify(View view) {
    	SharedPreferences appPrefs = getSharedPreferences("info.adamjsmith.usingpreferences_preferences", MODE_PRIVATE);
    	SharedPreferences.Editor prefsEditor = appPrefs.edit();
    	prefsEditor.putString("editTextPref", ((EditText) findViewById(R.id.txtString)).getText().toString());
    	prefsEditor.commit();
    }
    
    private void DisplayText(String str) {
    	Toast.makeText(getBaseContext(), str, Toast.LENGTH_LONG).show();
    }
    
    public void onClickSaveFile(View view) {
    	String str = textBox.getText().toString();
    	try {
    		FileOutputStream fOut = openFileOutput("textfile.txt", MODE_WORLD_READABLE);
    		OutputStreamWriter osw = new OutputStreamWriter(fOut);
    		
    		osw.write(str);
    		osw.flush();
    		osw.close();
    		
    		DisplayText("File Saved Successfully!");
    	} catch(IOException ioe) {
    		ioe.printStackTrace();
    	}
    }
    
    public void onClickLoadFile(View view) {
    	try {
    		FileInputStream fIn = openFileInput("textfile.txt");
    		InputStreamReader isr = new InputStreamReader(fIn);
    		
    		char[] inputBuffer = new char[READ_BLOCK_SIZE];
    		String s = "";
    		
    		int charRead;
    		while ((charRead = isr.read(inputBuffer))>0) {
    			String readString = String.copyValueOf(inputBuffer, 0, charRead);
    			s += readString;
    			inputBuffer = new char[READ_BLOCK_SIZE];
    		}
    		textBox.setText(s);
    		DisplayText("File Loaded successfully!");
    	} catch (IOException ioe) {
    		ioe.printStackTrace();
    	}
    }
    
}
