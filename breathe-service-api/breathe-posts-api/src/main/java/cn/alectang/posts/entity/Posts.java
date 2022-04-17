package cn.alectang.posts.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author 作者
 * @since 2022-04-13
 */
@TableName("t_posts")
public class Posts implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * UUID
     */
    private String uuid;

    /**
     * 类型(文本/图片/视频等)
     */
    private Integer postsType;

    /**
     * html/md/富文本
     */
    private Integer postsFormat;

    /**
     * 社区ID
     */
    private Long communityId;

    /**
     * 用户ID
     */
    private Long uid;

    /**
     * 帖子状态
     */
    private Integer postsStatus;

    /**
     * 是否置顶
     */
    private Integer isTop;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 是否删除
     */
    private Integer isDeleted;

    /**
     * 帖子内容
     */
    private String postsContent;

    /**
     * 帖子图片
     */
    private String postsImages;

    /**
     * 帖子视频
     */
    private String postsVideos;

    /**
     * 视频缩略图
     */
    private String thumbnailImg;

    /**
     * 帖子音频
     */
    private String postsAudio;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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
    public Long getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Long communityId) {
        this.communityId = communityId;
    }
    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
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
                "uuid=" + uuid +
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
