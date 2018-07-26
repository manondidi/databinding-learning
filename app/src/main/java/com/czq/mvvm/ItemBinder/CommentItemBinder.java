package com.czq.mvvm.ItemBinder;

import android.annotation.SuppressLint;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.czq.mvvm.R;
import com.czq.mvvm.databinding.ItemCommentBinding;
import com.czq.mvvm.viewModel.CommentItemVm;

import me.drakeet.multitype.ItemViewBinder;

public class CommentItemBinder extends ItemViewBinder<CommentItemVm, CommentItemBinder.ViewHolder> {
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull CommentItemVm commentItemVm) {
        holder.binding.setCommentItemVm(commentItemVm);
        holder.binding.executePendingBindings();
    }

    @SuppressLint("ResourceType")
    @NonNull
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        return new CommentItemBinder.ViewHolder(DataBindingUtil.inflate(layoutInflater, R.layout.item_comment, viewGroup, false));
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ItemCommentBinding binding;

        ViewHolder(@NonNull ItemCommentBinding b) {
            super(b.getRoot());
            binding = b;
        }
    }
}