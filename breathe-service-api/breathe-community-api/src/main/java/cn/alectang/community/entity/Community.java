package cn.alectang.community.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * @since 2022-04-08
 */
@TableName("t_community")
@ApiModel(value = "Community对象", description = "")
public class Community implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("社区名称")
    private String communityName;

    @ApiModelProperty("头像")
    private String avatar;

    @ApiModelProperty("社区简介")
    private String description;

    @ApiModelProperty("位置")
    private String location;

    @ApiModelProperty("创始人")
    private Long founder;

    @ApiModelProperty("管理员")
    private Long administrator;

    @ApiModelProperty("状态")
    private Integer status;

    @ApiModelProperty("创建时间")
    private LocalDateTime createdTime;

    public Long getId() {
        return id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    public Long getFounder() {
        return founder;
    }

    public void setFounder(Long founder) {
        this.founder = founder;
    }
    public Long getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Long administrator) {
        this.administrator = administrator;
    }
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    public String toString() {
        return "Community{" +
                "id=" + id +
                ", communityName='" + communityName + '\'' +
                ", avatar='" + avatar + '\'' +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", founder=" + founder +
                ", administrator=" + administrator +
                ", status=" + status +
                ", createdTime=" + createdTime +
                '}';
    }
}
