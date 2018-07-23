package com.czq.mvvm.ItemBinder;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.czq.mvvm.R;
import com.czq.mvvm.viewModel.EntryItemVm;

import me.drakeet.multitype.ItemViewBinder;

public class EntryItemBinder
        extends ItemViewBinder<EntryItemVm, EntryItemBinder.ViewHolder> {
    protected void onBindViewHolder(@NonNull ViewHolder paramViewHolder, @NonNull EntryItemVm paramEntryItemVm) {
    }

    @SuppressLint("ResourceType")
    @NonNull
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater paramLayoutInflater, @NonNull ViewGroup paramViewGroup) {
        return new ViewHolder(paramLayoutInflater.inflate(R.layout.item_entry, paramViewGroup, false));
    }

    static class ViewHolder
            extends RecyclerView.ViewHolder {
        ViewHolder(@NonNull View paramView) {
            super(paramView);
        }
    }
}
