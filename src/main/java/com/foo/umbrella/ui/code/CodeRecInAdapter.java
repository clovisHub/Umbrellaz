package com.foo.umbrella.ui.code;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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

    static final String TAG = CodeRecInAdapter.class.getName().concat("_TAG");


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
        TextView textViewHour;
        ImageView imageView;

        public ItemViewHolder(View itemView) {

            super(itemView);

            textViewHour = (TextView) itemView.findViewById(R.id.singleHourId);
            textViewTemp = (TextView) itemView.findViewById(R.id.singleTempId);
            imageView = (ImageView) itemView.findViewById(R.id.singleImgVId);

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

                holder.textViewTemp.setText(forecast.get(position).getTempFahrenheit()+"\u00b0"+"F");

            }else{
                holder.textViewTemp.setText(forecast.get(position).getTempCelsius()+"\u00b0"+"C");
            }

            holder.textViewHour.setText(""+forecast.get(position).getDateTime().getHour());

            holder.imageView.setImageResource(setImageCell(forecast.get(position)));
           // holder.imageView.setImageResource();

           // notifyDataSetChanged();


    }

    @Override
    public int getItemCount() {
        return forecast.size();
    }

    private int setImageCell(ForecastCondition f){

        Log.d(TAG, "setImageCell: "+f.getIcon());

        if(f.getIcon().equalsIgnoreCase("fog")){

            return R.drawable.weather_fog;
        }
        else if(f.getIcon().trim().equalsIgnoreCase("lightningrainy")){

            return R.drawable.weather_lightning_rainy;
        }
        else if(f.getIcon().equalsIgnoreCase("lightning")){

            return R.drawable.weather_lightning;
        }
        else if(f.getIcon().equalsIgnoreCase("partlycloudy")){

            return R.drawable.weather_partlycloudy;
        }
        else if(f.getIcon().equalsIgnoreCase("mostlycloudy")){

            return R.drawable.weather_fog;
        }
        else if(f.getIcon().equalsIgnoreCase("cloudy")){

            return R.drawable.weather_cloudy;
        }
        else if(f.getIcon().equalsIgnoreCase("snowyrainy")){

            return R.drawable.weather_snowy_rainy;
        }
        else if(f.getIcon().equalsIgnoreCase("snowy")){

            return R.drawable.weather_snowy;
        }
        else if(f.getIcon().equalsIgnoreCase("hail")){

            return R.drawable.weather_hail;
        }
        else if(f.getIcon().equalsIgnoreCase("sunny")){

            return R.drawable.weather_sunny;
        }
        else if(f.getIcon().equalsIgnoreCase("windyvariant")){

            return R.drawable.weather_windy_variant;
        }
        else if(f.getIcon().equalsIgnoreCase("chancetstorms")){

            return R.drawable.weather_rainy;
        }
        else if(f.getIcon().equalsIgnoreCase("tstorms")){

            return R.drawable.weather_lightning_rainy;
        }
        else if(f.getIcon().equalsIgnoreCase("clear")){

            return R.drawable.weather_fog;
        }
        else{
            return R.drawable.ic_action_arrow;
        }
    }
}
