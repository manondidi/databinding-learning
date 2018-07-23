package com.czq.mvvm.ItemBinder;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.czq.mvvm.R;
import com.czq.mvvm.busEvent.BusAction;
import com.czq.mvvm.databinding.ItemPlayStatusBinding;
import com.czq.mvvm.viewModel.PlayStatusItemVm;

import org.greenrobot.eventbus.EventBus;

import me.drakeet.multitype.ItemViewBinder;

public class PlayStatusItemBinder
        extends ItemViewBinder<PlayStatusItemVm, PlayStatusItemBinder.ViewHolder> {
    protected void onBindViewHolder(@NonNull ViewHolder paramViewHolder, @NonNull PlayStatusItemVm paramPlayStatusItemVm) {
        paramViewHolder.binding.executePendingBindings();
    }

    @NonNull
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater paramLayoutInflater, @NonNull ViewGroup paramViewGroup) {

        return new ViewHolder(DataBindingUtil.inflate(paramLayoutInflater, R.layout.item_play_status, paramViewGroup, false));
    }

    static class ViewHolder
            extends RecyclerView.ViewHolder {
        ItemPlayStatusBinding binding;

        ViewHolder(ItemPlayStatusBinding paramItemPlayStatusBinding) {
            super(paramItemPlayStatusBinding.getRoot());
            this.binding = paramItemPlayStatusBinding;
            this.binding.ivDropDown.setOnClickListener(v -> {
                EventBus.getDefault().post(new BusAction.HideCommentRecyclerViewEvent());
            });
        }
    }
}
