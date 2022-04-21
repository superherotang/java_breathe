package cn.alectang.posts.vo;

import cn.alectang.posts.entity.Posts;
import io.swagger.annotations.ApiModelProperty;

public class PostsInfo extends Posts {

    @ApiModelProperty("昵称")
    private String nickname;

    @ApiModelProperty("头像")
    private String avatar;

    private int share;
    private int comment;
    private int like;
    @ApiModelProperty("社区名称")
    private String communityName;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }


    public int getShare() {
        return share;
    }

    public void setShare(int share) {
        this.share = share;
    }

    public int getComment() {
        return comment;
    }

    public void setComment(int comment) {
        this.comment = comment;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    @Override
    public String toString() {
        return "PostsInfo{" +
                "nickname='" + nickname + '\'' +
                ", avatar='" + avatar + '\'' +
                ", share=" + share +
                ", comment=" + comment +
                ", like=" + like +
                ", communityName='" + communityName + '\'' +
                '}';
    }
}
