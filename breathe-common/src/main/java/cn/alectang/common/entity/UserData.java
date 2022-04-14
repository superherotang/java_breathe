package cn.alectang.common.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 *
 * </p>
 *
 * @author alectang
 * @since 2022-04-14
 */
@TableName("t_user_data")
@ApiModel(value = "UserData对象", description = "")
public class UserData implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("用户ID")
    private Long uid;

    @ApiModelProperty("头像")
    private String avatar;

    @ApiModelProperty("背景图片")
    private String background;

    @ApiModelProperty("昵称")
    private String nickname;

    @ApiModelProperty("简介")
    private String description;

    @ApiModelProperty("性别")
    private Integer sex;

    @ApiModelProperty("生日")
    private LocalDate birthday;

    @ApiModelProperty("地址")
    private String location;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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

    @Override
    public String toString() {
        return "UserData{" +
                "uid=" + uid +
                ", avatar=" + avatar +
                ", background=" + background +
                ", nickname=" + nickname +
                ", description=" + description +
                ", sex=" + sex +
                ", birthday=" + birthday +
                ", location=" + location +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                "}";
    }
}
