package com.czq.mvvm.ItemBinder;


import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.czq.mvvm.R;
import com.czq.mvvm.viewModel.EmptyTransparentItemVm;

import me.drakeet.multitype.ItemViewBinder;

public class EmptyTransparentItemBinder  extends ItemViewBinder<EmptyTransparentItemVm, EmptyTransparentItemBinder.ViewHolder> {
    protected void onBindViewHolder(@NonNull ViewHolder paramViewHolder, @NonNull EmptyTransparentItemVm paramEmptyTransparentItemVm) {
    }

    @SuppressLint("ResourceType")
    @NonNull
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater paramLayoutInflater, @NonNull ViewGroup paramViewGroup) {
        return new ViewHolder(paramLayoutInflater.inflate(R.layout.item_empty_transparent, paramViewGroup, false));
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ViewHolder(@NonNull View view) {
            super(view);
        }
    }
}
