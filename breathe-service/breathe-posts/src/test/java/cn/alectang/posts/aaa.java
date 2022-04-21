package cn.alectang.posts;

import cn.alectang.posts.mapper.PostsMapper;
import cn.alectang.posts.vo.PostsInfo;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public class aaa {


//    @Test
//    public void selectPage() {
//        final Page<Posts> mpPage = postsMapper.selectPage(new Page<>(1, 2), Wrappers.<Posts>query().select().orderByDesc("create_time"));
//        System.out.println("总页数 " + mpPage.getPages());
//        System.out.println("总记录数 " + mpPage.getTotal());
//        final List<Posts> userList = mpPage.getRecords();
//        userList.forEach(System.out::println);
//    }


    @Test
    void ddd(){
//        Page<PostsInfo> page = new Page<>(1,5);
//        postsMapper.selectPostInfoPage(page,12L);
//
//        System.out.println(page.getRecords());
//        System.out.println(page.getPages());
//        System.out.println(page.getTotal());
//        System.out.println(page.getRecords());
//        System.out.println(page.getRecords());
    }

    @Test
    void test(){
        List aaa= new ArrayList<>();
        aaa.add("jhasbdbas");
        aaa.add("jhasbdbas");
        aaa.add("jhasbdbas");
        aaa.add("jhasbdbas");
        aaa.add("jhasbdbas");
        aaa.add(6);
        aaa.add("7");
        aaa.add("8");
        aaa.add("9");
        String str=JSON.toJSONString(aaa);

        System.out.println(str);
        
        JSONArray bbb=JSON.parseArray(str);

        System.out.println(bbb);
        
    }
}
