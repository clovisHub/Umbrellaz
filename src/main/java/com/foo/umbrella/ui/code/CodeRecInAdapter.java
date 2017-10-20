package com.foo.umbrella.ui.code;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.foo.umbrella.R;
import com.foo.umbrella.data.model.ForecastCondition;

import java.util.List;

public class CodeRecInAdapter extends RecyclerView.Adapter<CodeRecInAdapter.ItemViewHolder>{

    private List<ForecastCondition> forecast = null;
    private String chosenUnit;
    private int cdRowIndex = -1;


    public CodeRecInAdapter(List<ForecastCondition> currentList, String option){

        if(forecast!= currentList){
            forecast = currentList;
            chosenUnit = option;

        }

    }

    public void setRowIndex(int index){
        cdRowIndex = index;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{

        TextView textViewTemp;
       // TextView textViewHour;
        //ImageView imageView;

        public ItemViewHolder(View itemView) {

            super(itemView);

           // textViewHour = (TextView) itemView.findViewById(R.id.singleHourId);
            textViewTemp = (TextView) itemView.findViewById(R.id.singleTempId);
            // imageView = (ImageView) itemView.findViewById(R.id.singleImgVid);

        }
    }


    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_item,parent,false);

        return new ItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {

        //if(forecast.get(position).getDateTime().getDayOfMonth() == day){

            if (chosenUnit.toLowerCase().trim().equals("fahrenheit")) { // if chosen is fahrenheit

                holder.textViewTemp.setText(forecast.get(position).getTempFahrenheit());

            }else{
                holder.textViewTemp.setText(forecast.get(position).getTempCelsius());
            }

          //  holder.textViewHour.setText(forecast.get(position).getDateTime().getHour());

         //   holder.imageView.setImageResource(setImageCell(forecast.get(position)));

           // notifyDataSetChanged();
        //}

    }

    @Override
    public int getItemCount() {
        return forecast.size();
    }

    private int setImageCell(ForecastCondition f){

        if(f.getIcon().toLowerCase().contains("fog")){

            return R.drawable.weather_fog;
        }
        else if(f.getIcon().toLowerCase().contains("lightning rainy")){

            return R.drawable.weather_lightning_rainy;
        }
        else if(f.getIcon().toLowerCase().contains("lightning")){

            return R.drawable.weather_lightning;
        }
        else if(f.getIcon().toLowerCase().contains("party cloud")){

            return R.drawable.weather_partlycloudy;
        }
        else if(f.getIcon().toLowerCase().contains("cloud")){

            return R.drawable.weather_cloudy;
        }
        else if(f.getIcon().toLowerCase().contains("snowy rainy")){

            return R.drawable.weather_snowy_rainy;
        }
        else if(f.getIcon().toLowerCase().contains("snowy")){

            return R.drawable.weather_snowy;
        }
        else if(f.getIcon().toLowerCase().contains("hail")){

            return R.drawable.weather_hail;
        }
        else if(f.getIcon().toLowerCase().contains("sunny")){

            return R.drawable.weather_sunny;
        }
        else if(f.getIcon().toLowerCase().contains("windy")){

            return R.drawable.weather_windy_variant;
        }
        else{
            return R.drawable.ic_action_arrow;
        }
    }
}
