package sg.edu.rp.c346.id22000210.democontextmenutranslation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Create a variable
    TextView tvTranslatedText;
    TextView tvTranslatedText2;

    String wordClicked = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Link the variable to the UI element
        tvTranslatedText = findViewById(R.id.textViewTranslatedText);
        tvTranslatedText2 = findViewById(R.id.textViewTranslatedText2);

        //Initiate that tvTranslatedText has a context menu
        registerForContextMenu(tvTranslatedText);
        registerForContextMenu(tvTranslatedText2);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,0,0,"English");
        menu.add(0,1,1,"Italian");

        //Code to store word that is being clicked
        if (v == tvTranslatedText) {
            wordClicked = "hello";
        }
        else if (v == tvTranslatedText2) {
            wordClicked = "bye";
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        //Hello, Ciao
        if(wordClicked.equalsIgnoreCase("hello")) {
            if(item.getItemId()==0) { //Check whether the selected item ID is 0
                tvTranslatedText.setText("Hello");
                return true; //menu item successfully handled
            }
            else if(item.getItemId()==1) { //Check whether the selected item ID is 1
                tvTranslatedText.setText("Ciao");
                return true; //menu item successfully handled
            }
        }

        //Bye, Addio
        if(wordClicked.equalsIgnoreCase("bye")) {
            if(item.getItemId()==0) { //Check whether the selected item ID is 0
                tvTranslatedText2.setText("Bye");
                return true; //menu item successfully handled
            }
            else if(item.getItemId()==1) { //Check whether the selected item ID is 1
                tvTranslatedText2.setText("Addio");
                return true; //menu item successfully handled
            }
        }
        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }

}