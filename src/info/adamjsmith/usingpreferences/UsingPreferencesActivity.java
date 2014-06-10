package info.adamjsmith.usingpreferences;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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
    
}
