package cn.alectang.posts.entity;

/**
 * <p>
 *
 * </p>
 *
 * @author alectang
 * @since 2022-04-06
 */

public class PostsCount {
    private int share;
    private int comment;
    private int like;

    public PostsCount init(){
        this.share=0;
        this.comment=0;
        this.like=0;
        return this;
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

    @Override
    public String toString() {
        return "PostCount{" +
                "share='" + share + '\'' +
                ", comment='" + comment + '\'' +
                ", like='" + like + '\'' +
                '}';
    }
}
