package com.vr.serviceImpl;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.vr.dao.PostsDao;
import com.vr.domain.Posts;
import com.vr.service.PostsService;
import com.vr.util.*;
@Service
@Qualifier("postsServiceImpl")
public class PostServiceImpl implements PostsService{
	@Autowired
	@Qualifier("postsDaoImpl")
	private PostsDao postsDao;


	public boolean createPosts(Posts posts) {
		return postsDao.createPosts(posts);
	}

	public boolean deletePosts(Posts posts) {
		return postsDao.deletePosts(posts);
	}

	public boolean updatePosts(Posts posts) {
		return postsDao.updatePosts(posts);
	}
	
    public Posts getPostsById(Integer id){
    	return postsDao.getPostsById(id);
    }
    
//	public Posts injectContent(Posts posts) {
//		String path = posts.getPath().substring(0,posts.getPath().length());
//		//System.out.print(path);
//		BufferedReader bf = null;
//		String content = "";
//		StringBuilder sb = new StringBuilder();
//		try {
//			bf =new BufferedReader(new InputStreamReader(new FileInputStream("/"+path), "UTF-8"));  
//			while (content != null) {
//				content = bf.readLine();
//				if (content == null) {
//					break;
//				}
//				sb.append(content);
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally{
//			try {
//				bf.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//        posts.setContents(sb.toString());
//		return posts;
//	}
	
	public List<Posts> getPostsByPage(int pageNo,int pageNum){
		List<Object> postsObj=postsDao.getPostsByPage(pageNo, pageNum);
		List<Posts> posts=new ArrayList<Posts>();
		for(Object o:postsObj){
			posts.add((Posts)o);
		}
		return posts;
	}
//	public void setEditorId(Posts posts,Integer eid){
//		posts.setEditorId(eid);
//		updateposts(posts);
//	}
//    
//	public void pushposts(Posts posts){
//		posts.setIsPush(1);
//		updateposts(posts);
//	}
		
}
