package com.czq.mvvm.converter;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;

import com.czq.mvvm.enums.PlayStatusEnum;
import com.czq.mvvm.model.Comment;
import com.czq.mvvm.util.TimeUtil;
import com.czq.mvvm.viewModel.CommentItemVm;

import java.util.ArrayList;
import java.util.List;

import static com.czq.mvvm.enums.PlayStatusEnum.PLAYED;
import static com.czq.mvvm.enums.PlayStatusEnum.PLAYING;
import static com.czq.mvvm.enums.PlayStatusEnum.PLUS_ONE;
import static com.czq.mvvm.enums.PlayStatusEnum.UNSET;
import static com.czq.mvvm.enums.PlayStatusEnum.WISH;

public class CommentConverter {

    public static List<CommentItemVm> convertCommentItemVmList(List<Comment> comments) {
        List<CommentItemVm> list = new ArrayList<>();
        for (Comment comment : comments) {
            list.add(convertCommentItemVm(comment));
        }
        return list;
    }

    public static CommentItemVm convertCommentItemVm(Comment comment) {
        CommentItemVm commentItemVm = new CommentItemVm();
        commentItemVm.commentId = "" + comment.id;
        commentItemVm.userId = "" + comment.userId;
        commentItemVm.avatar = comment.avatar;
        commentItemVm.isPraise = !comment.likeStatus.equals("normal");
        commentItemVm.praiseCount = comment.likeCount;
        commentItemVm.userNick = comment.nickname;
        String playStatusStr = "";
        switch (comment.playStatus) {
            case PLAYED:
                playStatusStr = "玩过,";
                break;
            case WISH:
                playStatusStr = "想玩,";
                break;
            case PLAYING:
                playStatusStr = "在玩,";
                break;
            case PLUS_ONE:
                playStatusStr = "喜加一,";
                break;
            case UNSET:
                playStatusStr = "";
                break;
        }
        playStatusStr += TimeUtil.getFormatTime(comment.recordUpdateTime);
        commentItemVm.playStatus = playStatusStr;

        if (comment.deserve == null) {
            commentItemVm.commentContent = new SpannableString(comment.content);
        } else {
            String deserveStr = comment.deserve == 1 ? "值得玩  |  " : "不值得玩 |   ";
            ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.parseColor(comment.deserve == 1 ? "#f39a00" : "#aaaaaa"));
            commentItemVm.commentContent = new SpannableString(deserveStr + comment.content);
            commentItemVm.commentContent.setSpan(colorSpan, 0, deserveStr.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        }
        return commentItemVm;


    }
}
