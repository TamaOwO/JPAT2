package vn.tama.jpat2.dao;

import vn.tama.jpat2.entity.Category;

import java.util.List;

public interface ICategoryDao {
    int count();
    List<Category> findAll(int page, int pagesize);
    List<Category> findByCategoryname(String catename);
    List<Category> findAll();
    Category findById(int cateid);
    void delete(int cateid) throws Exception;
    void update(Category category);
    void insert(Category category);
}
