package cn.alectang.posts.vo;

import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;

public class CommentInfo {


    @ApiModelProperty("内容")
    private String uuid;

    @ApiModelProperty("内容")
    private String content;

    @ApiModelProperty("赞")
    private Integer like;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("昵称")
    private String nickname;

    @ApiModelProperty("头像")
    private String avatar;


    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getLike() {
        return like;
    }

    public void setLike(Integer like) {
        this.like = like;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

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


    @Override
    public String toString() {
        return "CommentInfo{" +
                "uuid='" + uuid + '\'' +
                ", content='" + content + '\'' +
                ", like=" + like +
                ", createTime=" + createTime +
                ", nickname='" + nickname + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}
