package sidespell.tech.midtermassignment01;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener  {


    private AutoCompleteTextView AutoComp;
    private ArrayAdapter<String> Adapt;
    ListView mListView;
    String[] Countries;
    ArrayList<String> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String[] country = getResources().getStringArray(R.array.Countries1);
        Adapt = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, country);

        AutoComp = (AutoCompleteTextView) findViewById(R.id.autoComplete);
        AutoComp.setAdapter(Adapt);
        AutoComp.setThreshold(1);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        TextView mText = (TextView) view;
        itemList=new ArrayList<String>(Arrays.asList(Countries));
        ListView listV=(ListView)findViewById(R.id.listView);
        listV.setAdapter(Adapt);

        String Items = AutoComp.getText().toString();
        itemList.add(mText.toString());
        Adapt.notifyDataSetChanged();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
