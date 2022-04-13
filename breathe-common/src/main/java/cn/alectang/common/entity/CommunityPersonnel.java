package cn.alectang.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
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
@TableName("t_community_personnel")
@ApiModel(value = "CommunityPersonnel对象", description = "")
public class CommunityPersonnel implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(type = IdType.ASSIGN_UUID)
    private String uuid;

    @ApiModelProperty("社区ID")
    private Long communityId;

    @ApiModelProperty("用户ID")
    private Long uid;

    @ApiModelProperty("用户类型")
    private Integer userType;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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
    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "CommunityPersonnel{" +
            "uuid=" + uuid +
            ", communityId=" + communityId +
            ", uid=" + uid +
            ", userType=" + userType +
        "}";
    }
}
