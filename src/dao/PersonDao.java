package dao;

import entities.Person;

import java.util.List;

public interface PersonDao {
    void createPersonTable();
    int insert(Person person);
    Person selectById(int id);
    List<Person> selectAll();
    void update(int id);
    void delete(Person person, int id);
}
