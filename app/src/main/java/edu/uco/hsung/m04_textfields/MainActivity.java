package edu.uco.hsung.m04_textfields;


import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText sendTextField = (EditText) findViewById(R.id.send_textfield);
        sendTextField
                .setOnEditorActionListener(new TextView.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView v, int actionId,
                                                  KeyEvent event) {
                        if (actionId == EditorInfo.IME_ACTION_SEND) {
                            // "send" action
                            Toast.makeText(MainActivity.this,
                                    "SEND action pressed", Toast.LENGTH_LONG)
                                    .show();
                            return true;
                        } else {
                            return false;
                        }
                    }
                });

        AutoCompleteTextView nameView =
                (AutoCompleteTextView) findViewById(R.id.autocomplete_name);
        String[] names = getResources().getStringArray(R.array.names_array);
        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, names);
        nameView.setAdapter(adapter);

    }
}
