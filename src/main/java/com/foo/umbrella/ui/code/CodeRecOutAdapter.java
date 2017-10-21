package com.foo.umbrella.ui.code;

import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.foo.umbrella.R;
import com.foo.umbrella.data.model.ForecastCondition;

import java.util.ArrayList;
import java.util.List;

public class CodeRecOutAdapter extends RecyclerView.Adapter<CodeRecOutAdapter.OutViewHolder>{


    private List<List<ForecastCondition>> forecast;

    private static Context context;
    private String unitChosen;

    public CodeRecOutAdapter(Context context, List<List<ForecastCondition>> forecastLists, String option){
        this.context = context;
        unitChosen = option;
        forecast = forecastLists;


    }

    public static class OutViewHolder extends RecyclerView.ViewHolder {

        RecyclerView recyclerViewGridList;
        TextView title;


        public OutViewHolder(View itemView) {
            super(itemView);
            Context context = itemView.getContext();
            recyclerViewGridList = (RecyclerView) itemView.findViewById(R.id.code_inner_rcVid);
            recyclerViewGridList.setLayoutManager(new GridLayoutManager(context,4));
            recyclerViewGridList.setHasFixedSize(true);
            title = (TextView) itemView.findViewById(R.id.card_titleId);

        }
    }

    @Override
    public CodeRecOutAdapter.OutViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_item,parent,false);

        return new CodeRecOutAdapter.OutViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CodeRecOutAdapter.OutViewHolder holder, int position) {

        if(position == 0){
            holder.title.setText(R.string.today);
        }
        else{
            holder.title.setText(R.string.tomorrow);
        }

        List<ForecastCondition> one = new ArrayList<>(forecast.get(position));
        CodeRecInAdapter horizontalAdapter = new CodeRecInAdapter(one,unitChosen);
        horizontalAdapter.setRowIndex(position);
        holder.recyclerViewGridList.setAdapter(horizontalAdapter);

    }

    @Override
    public int getItemCount() {
        return forecast.size();
    }


}
