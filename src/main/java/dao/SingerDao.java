package dao;

import entities.Singer;

import java.util.List;

public interface SingerDao {
    List<Singer> findAll();
    List<Singer> findByFirstName();
    String findLastNameById();
    String findFirstNameById();
    void insert(Singer singer);
    void update(Singer singer);
    void delete(long singerId);
    List<Singer> findAllWithDetail();
    void insertWithDetail(Singer singer);

}
