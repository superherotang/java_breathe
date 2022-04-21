package cn.alectang.community.vo;


public class CommunityAnnouncementSimple{

    private int contentType;

    /**
     * 帖子内容
     */
    private String postsContent;

    public int getContentType() {
        return contentType;
    }

    public void setContentType(int contentType) {
        this.contentType = contentType;
    }

    public String getPostsContent() {
        return postsContent;
    }

    public void setPostsContent(String postsContent) {
        this.postsContent = postsContent;
    }


    @Override
    public String toString() {
        return "CommunityAnnouncementSimple{" +
                "contentType=" + contentType +
                ", postsContent='" + postsContent + '\'' +
                '}';
    }
}
