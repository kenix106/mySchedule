package cl.evilgenius.myschedule.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.List;

import cl.evilgenius.myschedule.R;
import cl.evilgenius.myschedule.data.Queries;
import cl.evilgenius.myschedule.models.Event;

public class sheduleAdapter extends RecyclerView.Adapter<sheduleAdapter.ViewHolder> {

    private List<Event> eventList = new Queries().eventList();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.lis_item_event, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Event event = eventList.get(i);
        viewHolder.name.setText(event.getName());
        viewHolder.date.setText(event.getDate());
        viewHolder.hour.setText(event.getHour());
        viewHolder.checkBox.setChecked(event.isDone());

        viewHolder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

            }
        });
        //estamos a la escucha si se apreta la opcion
        viewHolder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        viewHolder.date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        viewHolder.hour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }


    @Override
    public int getItemCount() {

        return eventList.size();
    }

    public void update(Event event){
        eventList.add(event);
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private CheckBox checkBox;
        private TextView name;
        private TextView date;
        private TextView hour;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            checkBox = (CheckBox) itemView.findViewById(R.id.eventCheckBox);
            name = itemView.findViewById(R.id.nameEvent);
            date = itemView.findViewById(R.id.dateEvent);
            hour = itemView.findViewById(R.id.hourEvent);

        }
    }

}
