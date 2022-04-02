package kz.narxoz.springapp.repository;

import kz.narxoz.springapp.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByEmailEndingWith(String email);              //1-tapsyrma
    List<User> findTop2ByNameStartsWith(String name);            //2-tapsyrma
    List<User> findBySurnameContaining(String surname);          //3-tapsyrma
    List<User> findByEmailNotContaining(String email);           //7-tapsyrma


    //native query
    @Query(value = "select * from users order by id asc", nativeQuery = true)
    List<User> findUsersByCustomQuery(); //4-tapsyrma

    @Query(value = "select * from users order by id desc limit 2", nativeQuery = true)
    List<User> findLastInsertedId();  //5-tapsyrma

    @Query(value = "select * from users order by name desc", nativeQuery = true)
    List<User> findUsersOrderByNameDesc();  //6-tapsyrma

    @Query(value = "select * from users where name=surname", nativeQuery = true)
    List<User> findByNameEqualsSurname();  //8-tapsyrma

    @Query(value = "select * from users where email like '%narxoz.kz' or email like '%yandex.ru' or email like '%gmail.com'", nativeQuery = true)
    List<User> findByEmailContains();  //9-tapsyrma

    @Query(value = "select distinct on (name) * from users", nativeQuery = true)
    List<User> findDistinctByname();   //10-tapsyrma
}