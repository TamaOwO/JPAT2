package vn.tama.jpat2.service;

import vn.tama.jpat2.entity.Category;

import java.util.List;

public interface ICategoryService {
    int count();
    List<Category> findAll(int page, int pagesize);
    List<Category> findByCategoryname(String catename);
    List<Category> findAll();
    Category findById(int cateid);
    void insert(Category category);
    void update(Category category);
    void delete(int cateid) throws Exception;
}
