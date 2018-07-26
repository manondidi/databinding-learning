package com.czq.mvvm.converter;

import com.czq.mvvm.R;
import com.czq.mvvm.model.GameCard;
import com.czq.mvvm.viewModel.EntryItemVm;

public class EntryItemVmConverter {

    public static EntryItemVm convertEntryItemVm(GameCard gameCard) {
        EntryItemVm entryItemVm = new EntryItemVm();
        entryItemVm.cardLv = gameCard.lv;
        entryItemVm.cardName = gameCard.lvName;
        int resId = 0;
        switch (gameCard.lv) {
            case 1:
                resId = R.mipmap.tong;
                break;
            case 2:
                resId = R.mipmap.yin;
                break;
            case 3:
                resId = R.mipmap.jin;
                break;
            case 4:
                resId = R.mipmap.zuan;
                break;
            case 5:
                resId = R.mipmap.hei;
                break;
            default:
                resId = R.mipmap.tong;
        }

        entryItemVm.cardResId = resId;
        return entryItemVm;
    }
}
