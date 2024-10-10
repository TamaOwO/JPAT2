package vn.tama.jpat2.service.impl;

import vn.tama.jpat2.dao.ICategoryDao;
import vn.tama.jpat2.dao.impl.CategoryDao;
import vn.tama.jpat2.entity.Category;
import vn.tama.jpat2.service.ICategoryService;

import java.util.List;

public class CategoryService implements ICategoryService {
    ICategoryDao cateDao = new CategoryDao();

    @Override
    public int count() {
        return cateDao.count();
    }

    @Override
    public List<Category> findAll(int page, int pagesize) {
        return cateDao.findAll(page, pagesize);
    }

    @Override
    public List<Category> findByCategoryname(String catename) {
        return cateDao.findByCategoryname(catename);
    }

    @Override
    public List<Category> findAll() {
        return cateDao.findAll();
    }

    @Override
    public Category findById(int cateid) {
        return cateDao.findById(cateid);
    }

    @Override
    public void insert(Category category) {
        cateDao.insert(category);
    }

    @Override
    public void update(Category category) {
        cateDao.update(category);
    }

    @Override
    public void delete(int cateid) throws Exception {
        cateDao.delete(cateid);
    }
}
