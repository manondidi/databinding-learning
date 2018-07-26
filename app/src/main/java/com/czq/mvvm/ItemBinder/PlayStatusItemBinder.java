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
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull PlayStatusItemVm playStatusItemVm) {

        holder.binding.setViewModel(playStatusItemVm);
        holder.binding.executePendingBindings();
    }

    @NonNull
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup viewGroup) {

        return new ViewHolder(DataBindingUtil.inflate(inflater, R.layout.item_play_status, viewGroup, false));
    }

    static class ViewHolder
            extends RecyclerView.ViewHolder {
        ItemPlayStatusBinding binding;

        ViewHolder(ItemPlayStatusBinding b) {
            super(b.getRoot());
            this.binding = b;
            this.binding.ivDropDown.setOnClickListener(v -> {
                EventBus.getDefault().post(new BusAction.HideCommentRecyclerViewEvent());
            });
        }
    }
}
