package com.niit.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Forum;
import com.niit.model.Friend;

@SuppressWarnings("deprecation")
@Repository
public class FriendDAOImpl implements FriendDAO

{
	
	public static final Logger log=LoggerFactory.getLogger(FriendDAOImpl.class);

	@Autowired
	
	private FriendDAO friendDAO;
	 
	@Autowired
	private SessionFactory sessionFactory;
	
	public FriendDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

	@Transactional
	public boolean save(Friend friend)
	
	{
	
		try
		{
			sessionFactory.getCurrentSession().save(friend);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		
		
		return false;

		}
		
		}

	@Transactional
	
	public boolean update(Friend friend) {
		try
		{
			sessionFactory.getCurrentSession().update(friend);
			return true;
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		
		return false;
		}
		
	}

	@Transactional
	
	public List<Friend> getmyfriends(String uid) 
	
	{
	
		String hql="from Friend where userid='"+uid+"'";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		List<Friend> list=query.list();
		return list;
		
	
	}
@Transactional
	public List<Friend> acceptedfriends(String uid,String fid) {
	String hql="from Friend where userid='"+uid+"'and friendid='"+fid+"'";
	Query query=sessionFactory.getCurrentSession().createQuery(hql);
	List<Friend> list=query.list();
			
		return list;
	}

	
	@Transactional
	
	public boolean unfriend(Friend friend) 
	
	{
	try
	{
		sessionFactory.getCurrentSession().delete(friend);
		return  true;
	}
	
	catch(Exception e)
	{
		e.printStackTrace();
		
	
		return false;
	}
	
	}

	@Transactional
	
	public Friend acceptfriend(String uid, String fid)
	
	{
		
		String hql="from Friend where userid='"+uid+"' and friendid='"+fid+"'";
		
		Query query  =sessionFactory.getCurrentSession().createQuery(hql);
		
		List<Friend> list=query.list();
		
		if(list==null)
		
		{
			return null;
		}
		
		else
		
		{
			return  list.get(0);
		}
		
	}

	@Transactional
	public Friend newrequest(String uid, String fid) {
		String hql="from Friend where userid='"+uid+"' and friendid='"+fid+"'";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		List<Friend> list=query.list();
		if(list==null)
		{
			
		return null;
		
		}
		else
		{
			return list.get(0);
		}
		}

	@Transactional
	public List<Friend> getrequestlist(String uid) {
		String hql="from Friend where friendid='"+uid+"' and status='n'";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		List<Friend> list=query.list();
		
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
/*	
	@Transactional
	
	public boolean saveOrUpdate(Friend friend) 
	{
	try
	{
		sessionFactory.getCurrentSession().saveOrUpdate(friend);
		return true;
		
	}
	
	catch(Exception e)
	
	{
		e.printStackTrace();
	}
		return false;
	}
	@Transactional
	public boolean Update(Friend friend)
	{
	try
	{
		SessionFactory.getCurrentSession().update(friend);
		
		return true;
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		return false;
	}
	@Transactional
	public Friend getFriend(int id)
	
	{
		String hql = "from friend where id="+"'"+id+"'";
		@SuppressWarnings({ "unused", "rawtypes" })
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Friend>list=query.list();
		
		if (list==null)
				{
			return null;
				}
		else
		{
		
			return list.get(0);
			
		}
	
	}
	@Transactional
	public Friend newrequest(int id)
	
	{
		log.info("Starting of the session new request");
	String hql="from friend where userid="+"'"+id+"'"+" and status='n'";
	log.debug(hql);
	Query query=sessionFactory.getCurrentSession().createQuery(hql);
	List<Friend>list=query.list();
	if(list==null)
	{
		return null;
		
	}
	else
		{
		
		return list.get(0);
		}
	}
	@Transactional
	public List<Friend> list() {
		Criteria c=sessionFactory.getCurrentSession().createCriteria(Friend.class);
		@SuppressWarnings("unchecked")
		List<Friend>list=c.list();
		return list;
	}
	@Transactional
	public boolean Delete(Friend friend) {
		try
		{
			sessionFactory.getCurrentSession().delete(friend);
			return true;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
	}
	@Transactional
	public List<Friend> getfriendlist(int uid) {
		String hql="from Friend where userid= "+uid;
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		List<Friend> list = query.list();
		return list;
	}
	public Friend UpdateStatus(String uid, String fid) {
		// TODO Auto-generated method stub
		return null;
	}
	public Friend UpdateStatus(String uid, String fid) {
		
		String hql="from friend where userid='"+uid+"'and friendid='"+fid"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Friend> list=query.list();
		if(list==null)
		{
			return null;
		}
		else 
		{
			return list.get(0);
		}
		
	}
*/