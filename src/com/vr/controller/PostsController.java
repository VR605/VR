package com.vr.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vr.domain.Posts;
import com.vr.service.PostsService;

@Controller
public class PostsController {
	@Autowired
	@Qualifier("postsServiceImpl")
	private PostsService PostsService;

	public PostsService getPostsService() {
		return PostsService;
	}

	public void setPostsService(PostsService PostsService) {
		this.PostsService = PostsService;
	}

//	@ResponseBody
//	@RequestMapping(value = "/posts/{nid}")
//	public Posts getposts(@PathVariable Integer nid) {
//		System.out.print(nid);
//		Posts posts = PostsService.getPostsById(nid);
//		System.out.print(posts == null);
//		if (posts != null) {
//			PostsService.injectContent(posts);
//		}
//		return posts;
//	}

	@ResponseBody
	@RequestMapping(value = "/bbs_list/{page}")
	public List<Posts> getPostsByPage(@PathVariable Integer page) {
		System.out.print(page);
		return PostsService.getPostsByPage(page, 10);
	}

//	@ResponseBody
//	@RequestMapping(value = "posts/upvote/{nid}")
//	public String upvotePosts(@PathVariable Integer nid) {
//		try {
//			Posts posts = PostsService.getPostsById(nid);
//			Integer upvote = posts.getUpvote();
//			if (upvote == null) {
//				upvote = 1;
//			} else {
//				upvote += 1;
//			}
//			posts.setUpvote(upvote);
//			PostsService.updatePosts(posts);
//			return "success";
//		} catch (Exception e) {
//			e.printStackTrace();
//			return "fail";
//		}
//    }
//	
//	@ResponseBody
//	@RequestMapping(value="posts/downvote/{nid}")
//	public String downvotePosts(@PathVariable Integer nid){
//		try {
//			Posts posts = PostsService.getPostsById(nid);
//			Integer downvote = posts.getDownvote();
//			if (downvote == null) {
//				downvote = 1;
//			} else {
//				downvote += 1;
//			}
//			posts.setUpvote(downvote);
//			PostsService.updatePosts(posts);
//			return "success";
//		} catch (Exception e) {
//			e.printStackTrace();
//			return "fail";
//		}
//	}
}
