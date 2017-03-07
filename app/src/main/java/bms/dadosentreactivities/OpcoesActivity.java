package bms.dadosentreactivities;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;

public class OpcoesActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String[] estados = getResources().getStringArray(R.array.arrayEstados);
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, estados));

        String estado = getIntent().getStringExtra("estado");
        if(estado != null){
            int position = Arrays.asList(estados).indexOf(estado);
            getListView().setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
            getListView().setItemChecked(position, true);
        }
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String result = l.getItemAtPosition(position).toString();

        Intent i = new Intent();
        i.putExtra("estado", result);
        setResult(RESULT_OK, i);
        finish();
    }
}
