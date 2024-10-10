package vn.tama.jpat2.service.impl;

import vn.tama.jpat2.dao.IVideoDao;
import vn.tama.jpat2.dao.impl.VideoDao;
import vn.tama.jpat2.entity.Video;
import vn.tama.jpat2.service.IVideoService;

import java.util.List;

public class VideoService implements IVideoService {
    IVideoDao vidDao = new VideoDao();

    @Override
    public int count() {
        return vidDao.count();
    }

    @Override
    public List<Video> findAll(int page, int pagesize) {
        return vidDao.findAll(page, pagesize);
    }

    @Override
    public List<Video> findByVideoname(String title) {
        return vidDao.findByVideoname(title);
    }

    @Override
    public List<Video> findAll() {
        return vidDao.findAll();
    }

    @Override
    public Video findById(int vidid) {
        return vidDao.findById(vidid);
    }

    @Override
    public void delete(int vidid) throws Exception {
        vidDao.delete(vidid);
    }

    @Override
    public void update(Video video) {
        vidDao.update(video);
    }

    @Override
    public void insert(Video video) {
        vidDao.insert(video);
    }
}
