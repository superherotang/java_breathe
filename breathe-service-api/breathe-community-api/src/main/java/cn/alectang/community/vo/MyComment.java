package cn.alectang.community.vo;

public class MyComment {

    private Long id;

    private String communityName;

    private String avatar;

    public Long getId() {
        return id;
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "PickComment{" +
                "id=" + id +
                ", communityName='" + communityName + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}
