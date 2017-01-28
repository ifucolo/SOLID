package com.budgetedonline.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.budgetedonline.R;
import com.budgetedonline.Util.Util;
import com.budgetedonline.entity.DataBase;
import com.budgetedonline.entity.IntervalDataBase;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by iagomendesfucolo on 06/12/16.
 */

public class BudgetAdapter extends RecyclerView.Adapter<BudgetAdapter.ViewHolder> {

    private ArrayList<IntervalDataBase> dataBases;
    private Context context;
    public BudgetAdapter(ArrayList<IntervalDataBase> dataBases, Context context) {
        this.dataBases = dataBases;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler, parent,false);;
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        IntervalDataBase intervalDataBase = dataBases.get(position);

        holder.date.setText(Util.formateDate(intervalDataBase.date));
        holder.name.setText(intervalDataBase.description);
        holder.value.setText(context.getString(R.string.money, String.valueOf(intervalDataBase.amount)));
    }

    @Override
    public int getItemCount() {
        return dataBases.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.layout)
        LinearLayout layout;

        @BindView(R.id.date)
        TextView date;

        @BindView(R.id.name)
        TextView name;

        @BindView(R.id.value)
        TextView value;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}
