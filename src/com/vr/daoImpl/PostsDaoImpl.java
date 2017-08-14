package com.vr.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.vr.dao.PostsDao;
import com.vr.domain.Posts;
import com.vr.util.HibernateUtils;
@Repository
@Qualifier("postsDaoImpl")
public class PostsDaoImpl extends HibernateUtils implements PostsDao {
	public boolean createPosts(Posts posts) {
		return save(posts);
	}

	public boolean updatePosts(Posts posts) {
		return update(posts);
	}

	public boolean deletePosts(Posts posts) {
		return deletePosts(posts);
	}

	public Posts getPostsById(Integer id) {
		return (Posts) findByHql("from Posts n where n.id=?", new Object[] { id });
	}

	/*public List<posts> getRecent10posts() {
		String hql = "from posts as n order by n.id desc";
		
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		List<posts> res = null;
		Query query = null;
		try {
			query = session.createQuery(hql);
			query.setMaxResults(10);
			res = query.list();
		} catch (Exception e) {
            e.printStackTrace();
		}finally{
			session.close();
		}
		
		return res;
	}*/
    
	@Override
	public List<Object> getPostsByPage(int pageNo, int pageNum) {
		String hql="from Posts as n order by id desc";
		return listpage(hql, pageNo,pageNum);
	}

	
}
