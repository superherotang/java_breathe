package cn.alectang.common.entity;

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
 * @since 2022-04-07
 */
@TableName("t_posts")
@ApiModel(value = "Posts对象", description = "")
public class Posts implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("UUID")
    private String uudi;

    @ApiModelProperty("类型(文本/图片/视频等)")
    private Integer postsType;

    @ApiModelProperty("html/md/富文本")
    private Integer postsFormat;

    @ApiModelProperty("社区ID")
    private Integer communityId;

    @ApiModelProperty("用户ID")
    private Long uid;

    @ApiModelProperty("帖子状态")
    private Integer postsStatus;

    @ApiModelProperty("是否置顶")
    private Integer isTop;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty("是否删除")
    private Integer isDeleted;

    @ApiModelProperty("帖子内容")
    private String postsContent;

    @ApiModelProperty("帖子图片")
    private String postsImages;

    @ApiModelProperty("帖子视频")
    private String postsVideos;

    @ApiModelProperty("视频缩略图")
    private String thumbnailImg;

    @ApiModelProperty("帖子音频")
    private String postsAudio;

    public String getUudi() {
        return uudi;
    }

    public void setUudi(String uudi) {
        this.uudi = uudi;
    }
    public Integer getPostsType() {
        return postsType;
    }

    public void setPostsType(Integer postsType) {
        this.postsType = postsType;
    }
    public Integer getPostsFormat() {
        return postsFormat;
    }

    public void setPostsFormat(Integer postsFormat) {
        this.postsFormat = postsFormat;
    }
    public Integer getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Integer communityId) {
        this.communityId = communityId;
    }
    public Long getUserId() {
        return uid;
    }

    public void setUserId(Long userId) {
        this.uid = userId;
    }
    public Integer getPostsStatus() {
        return postsStatus;
    }

    public void setPostsStatus(Integer postsStatus) {
        this.postsStatus = postsStatus;
    }
    public Integer getIsTop() {
        return isTop;
    }

    public void setIsTop(Integer isTop) {
        this.isTop = isTop;
    }
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }
    public String getPostsContent() {
        return postsContent;
    }

    public void setPostsContent(String postsContent) {
        this.postsContent = postsContent;
    }
    public String getPostsImages() {
        return postsImages;
    }

    public void setPostsImages(String postsImages) {
        this.postsImages = postsImages;
    }
    public String getPostsVideos() {
        return postsVideos;
    }

    public void setPostsVideos(String postsVideos) {
        this.postsVideos = postsVideos;
    }
    public String getThumbnailImg() {
        return thumbnailImg;
    }

    public void setThumbnailImg(String thumbnailImg) {
        this.thumbnailImg = thumbnailImg;
    }
    public String getPostsAudio() {
        return postsAudio;
    }

    public void setPostsAudio(String postsAudio) {
        this.postsAudio = postsAudio;
    }

    @Override
    public String toString() {
        return "Posts{" +
            "uudi=" + uudi +
            ", postsType=" + postsType +
            ", postsFormat=" + postsFormat +
            ", communityId=" + communityId +
            ", uid=" + uid +
            ", postsStatus=" + postsStatus +
            ", isTop=" + isTop +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
            ", isDeleted=" + isDeleted +
            ", postsContent=" + postsContent +
            ", postsImages=" + postsImages +
            ", postsVideos=" + postsVideos +
            ", thumbnailImg=" + thumbnailImg +
            ", postsAudio=" + postsAudio +
        "}";
    }
}
