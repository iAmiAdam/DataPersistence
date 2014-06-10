package info.adamjsmith.usingpreferences;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UsingPreferencesActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
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
    
}
