package cl.evilgenius.myschedule;

import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;

import cl.evilgenius.myschedule.models.Event;

public class MainActivity extends AppCompatActivity {

    private MainActivityFragment mainActivityFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mainActivityFragment =(MainActivityFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_event);

                ImageButton button = dialog.findViewById(R.id.save_dialog);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        EditText input_name = dialog.findViewById(R.id.name_dialog);
                        EditText input_date = dialog.findViewById(R.id.date_dialog);
                        EditText input_hour = dialog.findViewById(R.id.hour_dialog);
                        String name = input_name.getText().toString();
                        String date = input_date.getText().toString();
                        String hour = input_hour.getText().toString();

                        if (name.trim().length()>0){
                            Event event = new Event();
                            event.setName(name);
                            event.setHour(hour);
                            event.setDate(date);
                            event.setDone(false);
                            event.save();

                            Log.e("savedDB", String.valueOf(event));

                            mainActivityFragment.updateList(event);
                        }
                        dialog.dismiss();

                    }
                });


                dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
                dialog.show();

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
