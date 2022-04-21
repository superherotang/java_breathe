package cn.alectang.posts.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author alectang
 * @since 2022-04-21
 */
@TableName("t_comment")
@ApiModel(value = "Comment对象", description = "")
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("uuid")
    private String uuid;

    @ApiModelProperty("帖子uuid")
    private String postsId;

    @ApiModelProperty("用户id")
    private Long uid;

    @ApiModelProperty("赞")
    private Integer like;

    @ApiModelProperty("内容")
    private String content;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("是否删除")
    private Integer isDeleted;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    public String getPostsId() {
        return postsId;
    }

    public void setPostsId(String postsId) {
        this.postsId = postsId;
    }
    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }
    public Integer getLike() {
        return like;
    }

    public void setLike(Integer like) {
        this.like = like;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "Comment{" +
            "uuid=" + uuid +
            ", postsId=" + postsId +
            ", uid=" + uid +
            ", like=" + like +
            ", content=" + content +
            ", createTime=" + createTime +
            ", isDeleted=" + isDeleted +
        "}";
    }
}
