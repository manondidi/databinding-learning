package com.czq.mvvm.converter;

import com.czq.mvvm.model.GameCard;
import com.czq.mvvm.viewModel.EntryItemVm;

public class EntryItemVmConverter {

    public static EntryItemVm convertEntryItemVm(GameCard gameCard) {
        EntryItemVm entryItemVm = new EntryItemVm();
        entryItemVm.cardLv = gameCard.lv;
        entryItemVm.cardName = gameCard.name;
        return entryItemVm;
    }
}
