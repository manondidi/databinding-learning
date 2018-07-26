package com.czq.mvvm.ItemBinder;

import android.annotation.SuppressLint;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.czq.mvvm.R;
import com.czq.mvvm.databinding.ItemEntryBinding;
import com.czq.mvvm.viewModel.EntryItemVm;

import me.drakeet.multitype.ItemViewBinder;

public class EntryItemBinder
        extends ItemViewBinder<EntryItemVm, EntryItemBinder.ViewHolder> {
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull EntryItemVm entryItemVm) {
        holder.binding.setViewModel(entryItemVm);
        holder.binding.executePendingBindings();
    }

    @NonNull
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup viewGroup) {
        return new ViewHolder(DataBindingUtil.inflate(inflater, R.layout.item_entry, viewGroup, false));
    }

    static class ViewHolder
            extends RecyclerView.ViewHolder {


        ItemEntryBinding binding;
        ViewHolder(@NonNull ItemEntryBinding b) {
            super(b.getRoot());
            binding = b;

        }
    }
}
