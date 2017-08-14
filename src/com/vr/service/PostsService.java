package com.vr.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.vr.domain.Posts;

public interface PostsService {
	public boolean createPosts(Posts posts);

	public boolean deletePosts(Posts posts);

	public boolean updatePosts(Posts posts);

	//public Posts injectContent(Posts posts);
	
//	public void setEditorId(Posts posts,Integer eid);
//    
//	public void pushPosts(Posts posts);
	
	public Posts getPostsById(Integer id);
	
	public List<Posts> getPostsByPage(int pageNo,int pageNum);
}
