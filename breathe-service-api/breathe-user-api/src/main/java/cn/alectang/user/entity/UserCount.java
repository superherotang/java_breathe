package cn.alectang.user.entity;

public class UserCount {

    private Integer like;
    private Integer follow;
    private Integer fans;
    private Integer history;


    public UserCount init() {
        this.like = 0;
        this.follow = 0;
        this.fans = 0;
        this.history = 0;
        return this;
    }


    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getFollow() {
        return follow;
    }

    public void setFollow(int follow) {
        this.follow = follow;
    }

    public int getFans() {
        return fans;
    }

    public void setFans(int fans) {
        this.fans = fans;
    }

    public int getHistory() {
        return history;
    }

    public void setHistory(int history) {
        this.history = history;
    }

    @Override
    public String toString() {
        return "UserCount{" +
                "like=" + like +
                ", follow=" + follow +
                ", fans=" + fans +
                ", history=" + history +
                '}';
    }
}
