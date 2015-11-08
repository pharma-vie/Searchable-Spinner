package azim.ansari.searchablespinner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import azim.ansari.spinner.SearchableSpinner;

public class MainActivity extends AppCompatActivity {

    private SearchableSpinner spinner1, spinner2;
    private TextView first, second;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        first = (TextView) findViewById(R.id.first);
        second = (TextView) findViewById(R.id.second);

        String[] data = getResources().getStringArray(R.array.countries_array);

        spinner1 = (SearchableSpinner) findViewById(R.id.spinner1);
        spinner2 = (SearchableSpinner) findViewById(R.id.spinner2);

        spinner1.setData(data);
        spinner2.setData(data);

        spinner1.setDefaultText("Select country");
        spinner1.setInvalidTextColor(getResources().getColor(R.color.colorAccent));

        spinner1.setSelectionListener(new SearchableSpinner.OnSelectionListener() {
            @Override
            public void onSelect(int spinnerId, int position, String value) {
                Log.i("Select1", "Position : " + position + " : Value : " + value + " : " + spinnerId);
                setText(first, value);

            }
        });

        spinner2.setSelectionListener(new SearchableSpinner.OnSelectionListener() {
            @Override
            public void onSelect(int spinnerId, int position, String value) {
                Log.i("Select2", "Position : " + position + " : Value : " + value + " : " + spinnerId);
                setText(second, value);
            }
        });
    }

    public void getFirstValue(View view) {
        Log.i("First", spinner1.getValue() + "");
        setText(first, spinner1.getValue());
    }

    public void getSecondValue(View view) {
        Log.i("Second", spinner2.getValue() + "");
        setText(second, spinner2.getValue());
    }

    private void setText(TextView textView, String text) {
        if (text != null)
            textView.setText(text);
        else
            textView.setText("Nothing selected...");
    }
}
