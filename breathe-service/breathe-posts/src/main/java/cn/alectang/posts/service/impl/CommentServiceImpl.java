package cn.alectang.posts.service.impl;

import cn.alectang.common.exceptionhandler.BreatheException;
import cn.alectang.posts.entity.Comment;
import cn.alectang.posts.mapper.CommentMapper;
import cn.alectang.posts.service.ICommentService;
import cn.alectang.posts.vo.CommentInfo;
import cn.alectang.posts.vo.PostsInfo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author alectang
 * @since 2022-04-21
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements ICommentService {

    @Override
    public Map<String, Object> getCommentByPid(int c ,String pid) {
        Page<CommentInfo> page = new Page<>(c, 10);
         baseMapper.getCommentByPid(page,pid);

        List<CommentInfo> postsInfoList = page.getRecords();
        long current = page.getCurrent();
        long pages = page.getPages();
        long size = page.getSize();
        long total = page.getTotal();

        Map<String, Object> map = new HashMap<>();
        map.put("items", postsInfoList);
        map.put("current", current);
        map.put("pages", pages);
        map.put("size", size);
        map.put("total", total);

        return map;
    }

    @Override
    public void insertComment(@RequestBody Comment comment) {
        String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
        comment.setUuid(uuid);
        int insert = baseMapper.insert(comment);
        if (insert==0){
            throw  new BreatheException(20001,"评论识别");
        }
    }
}
