package com.czq.mvvm.model;

public class Comment {


    /**
     * id : 176690
     * deserve : 1
     * playStatus : played
     * playTimeRange : null
     * game : {"title":"塞尔达传说：旷野之息","icon":"http://i1.17173cdn.com/9axtlo/YWxqaGBf/gamelib/20180121/XSkTpTbmelzrDbb.jpg","iconType":"normal","id":10073924,"hasRecord":false,"platform":"NS","playedPerson":170,"deservePercent":0.96}
     * content : 任天堂教你做游戏。
     * userGameId : 176690
     * retweetCount : 0
     * reviewCreateTime : 1530852855
     * reviewUpdateTime : 1530852855
     * recordUpdateTime : 1530852855
     * recordCreateTime : 1530852855
     * userId : 138251392
     * nickname : marnhu
     * avatar : https://i.17173cdn.com/gdthue/YWxqaGBf/snsapp/20180706/iYhaIWbmrwFByej.jpg!a-1-120x120.jpg
     * isFireflyUser : false
     * likeCount : 0
     * createTime : 1530852855
     * dislikeCount : 0
     * likeStatus : normal
     * replyCount : 0
     * followStatus : unfollowed
     * feedId : null
     * feedType : null
     */

    public int id;
    public Integer deserve;
    public String playStatus;
    public Game game;
    public String content;
    public int userGameId;
    public int retweetCount;
    public int reviewCreateTime;
    public int reviewUpdateTime;
    public int recordUpdateTime;
    public int recordCreateTime;
    public int userId;
    public String nickname;
    public String avatar;
    public boolean isFireflyUser;
    public int likeCount;
    public int createTime;
    public int dislikeCount;
    public String likeStatus;
    public int replyCount;
    public String followStatus;


    public static class Game {
        /**
         * title : 塞尔达传说：旷野之息
         * icon : http://i1.17173cdn.com/9axtlo/YWxqaGBf/gamelib/20180121/XSkTpTbmelzrDbb.jpg
         * iconType : normal
         * id : 10073924
         * hasRecord : false
         * platform : NS
         * playedPerson : 170
         * deservePercent : 0.96
         */

        public String title;
        public String icon;
        public String iconType;
        public int id;
        public boolean hasRecord;
        public String platform;
        public int playedPerson;
        public double deservePercent;

    }
}
