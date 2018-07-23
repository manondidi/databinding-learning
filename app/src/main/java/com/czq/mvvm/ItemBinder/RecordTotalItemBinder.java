package com.czq.mvvm.ItemBinder;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.czq.mvvm.R;
import com.czq.mvvm.viewModel.RecordTotalItemVm;

import me.drakeet.multitype.ItemViewBinder;

public class RecordTotalItemBinder
        extends ItemViewBinder<RecordTotalItemVm, RecordTotalItemBinder.ViewHolder>
{
    protected void onBindViewHolder(@NonNull ViewHolder paramViewHolder, @NonNull RecordTotalItemVm paramRecordTotalItemVm) {}

    @SuppressLint("ResourceType")
    @NonNull
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater paramLayoutInflater, @NonNull ViewGroup paramViewGroup)
    {
        return new ViewHolder(paramLayoutInflater.inflate(R.layout.item_record_total, paramViewGroup, false));
    }

    static class ViewHolder
            extends RecyclerView.ViewHolder
    {
        ViewHolder(@NonNull View paramView)
        {
            super(paramView);
        }
    }
}
