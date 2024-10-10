package vn.tama.jpat2.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import vn.tama.jpat2.config.JPAConfig;
import vn.tama.jpat2.dao.IVideoDao;
import vn.tama.jpat2.entity.Video;

import java.util.List;

public class VideoDao implements IVideoDao {
    @Override
    public int count() {
        EntityManager enma = JPAConfig.getEntityManager();
        String jpql = "SELECT count(v) FROM Video v";
        Query query = enma.createQuery(jpql);
        return ((Long)query.getSingleResult()).intValue();
    }

    @Override
    public List<Video> findAll(int page, int pagesize) {
        EntityManager enma = JPAConfig.getEntityManager();
        TypedQuery<Video> query= enma.createNamedQuery("Video.findAll", Video.class);
        query.setFirstResult(page*pagesize);
        query.setMaxResults(pagesize);
        return query.getResultList();
    }

    @Override
    public List<Video> findByName(String title) {
        EntityManager enma = JPAConfig.getEntityManager();
        String jpql = "SELECT v FROM Video v WHERE v.title like :title";
        TypedQuery<Video> query= enma.createQuery(jpql, Video.class);
        query.setParameter("title","%" + title + "%");
        return query.getResultList();
    }

    @Override
    public List<Video> findAll() {
        EntityManager enma = JPAConfig.getEntityManager();
        TypedQuery<Video> query= enma.createNamedQuery("Video.findAll", Video.class);
        return query.getResultList();
    }

    @Override
    public Video findById(int vidid) {
        EntityManager enma = JPAConfig.getEntityManager();
        Video vid = enma.find(Video.class,vidid);
        return vid;
    }

    @Override
    public void delete(int vidid) throws Exception {
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        try {
            trans.begin();
            //gọi phuong thức để insert, update, delete
            Video vid = enma.find(Video.class,vidid);
            if(vid!= null) {
                enma.remove(vid);
            }else {
                throw new Exception("Không tìm thấy");
            }
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            throw e;
        } finally {
            enma.close();
        }
    }

    @Override
    public void update(Video video) {
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        try {
            trans.begin();

            //gọi phuong thức để insert, update, delete
            enma.merge(video);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            throw e;
        } finally {
            enma.close();
        }
    }

    @Override
    public void insert(Video video) {
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        try {
            trans.begin();

            //gọi phuong thức để insert, update, delete
            enma.persist(video);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            throw e;
        } finally {
            enma.close();
        }
    }
}
