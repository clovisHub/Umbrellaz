package com.foo.umbrella.ui.code;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.foo.umbrella.R;
import com.foo.umbrella.data.model.ForecastCondition;

import java.util.List;

public class CodeRecAdapter extends RecyclerView.Adapter<CodeRecAdapter.ViewHolder>{

    private List<ForecastCondition> forecast;
    private Context theContext;
    private  String day;

    public CodeRecAdapter(Context context, List<ForecastCondition> forecastConditions, String curDay){

        forecast = forecastConditions;
        theContext = context;
        day = curDay;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_item,parent,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        String date = forecast.get(position).getDateTime().getDayOfWeek().name().toString();

        holder.textViewa1.setText(forecast.get(position).getCondition().toString());

    }

    @Override
    public int getItemCount() {
        return forecast.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView textViewa1;

        public ViewHolder(View itemView) {

            super(itemView);

           // textViewa1 = (TextView) itemView.findViewById(R.id.set_txta1);

        }
    }
}
