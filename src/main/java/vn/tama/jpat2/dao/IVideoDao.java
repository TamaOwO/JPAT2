package vn.tama.jpat2.dao;

import vn.tama.jpat2.entity.Video;

import java.io.Serializable;
import java.util.List;

public interface IVideoDao extends Serializable {
    int count();
    List<Video> findAll(int page, int pagesize);
    List<Video> findByVideoname(String title);
    List<Video> findAll();
    Video findById(int vidid);
    void delete(int vidid) throws Exception;
    void update(Video video);
    void insert(Video video);
}
