package sg.edu.rp.c346.id19044628.demodynamiclistviewcolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText edTextColour, edTextIndex;
    Button btnAddItem, btnRemoveItem, btnUpdateItem;
    ListView lvColour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edTextColour=findViewById(R.id.editTextColour);
        edTextIndex=findViewById(R.id.editTextIndex);
        btnAddItem=findViewById(R.id.buttonAddItem);
        btnRemoveItem=findViewById(R.id.buttonRemoveItem);
        btnUpdateItem=findViewById(R.id.buttonUpdateItem);
        lvColour=findViewById(R.id.listViewColour);

        ArrayList<String>alColours;
        alColours=new ArrayList<String>();
        alColours.add("Red");
        alColours.add("Orange");

        ArrayAdapter aaColour = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,alColours);
        lvColour.setAdapter(aaColour);

        btnAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String colour= edTextColour.getText().toString();
               //add item without index --> alColours.add(colour);

                int pos=Integer.parseInt(edTextIndex.getText().toString()); //add item with specific index
                alColours.add(pos, colour);
                aaColour.notifyDataSetChanged();
            }
        });

        btnRemoveItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int pos=Integer.parseInt(edTextIndex.getText().toString());
                alColours.remove(pos);
                aaColour.notifyDataSetChanged();
            }
        });

        btnUpdateItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String colour= edTextColour.getText().toString();
                int pos=Integer.parseInt(edTextIndex.getText().toString());
                alColours.set(pos, colour);
                aaColour.notifyDataSetChanged();
            }
        });

        lvColour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String colour= alColours.get(position);
                Toast.makeText(MainActivity.this, colour, Toast.LENGTH_SHORT).show();
            }
        });

    }
}