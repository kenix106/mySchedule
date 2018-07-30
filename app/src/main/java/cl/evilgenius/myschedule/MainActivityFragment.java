package cl.evilgenius.myschedule;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cl.evilgenius.myschedule.adapters.sheduleAdapter;
import cl.evilgenius.myschedule.models.Event;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private sheduleAdapter adapter;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.eventRV);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

     /*   for (int i = 0; i < 3 ; i++) {
            Event event = new Event();
            event.setName(String.valueOf("Nombre# " + i));
            event.setDate(String.valueOf("fecha= " + i));
            event.setHour(String.valueOf("Hora es : "+ i));
            event.setDone(false);
            event.save();
    }*/


         adapter = new sheduleAdapter();
        recyclerView.setAdapter(adapter);

    }

   public void updateList (Event event){
        adapter.update(event);
       Log.e("save, EVENT", event.getName());
       Log.e("save, EVENT", event.getDate());
       Log.e("save, EVENT", event.getHour());
   }
}
