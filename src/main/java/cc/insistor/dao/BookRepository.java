package cc.insistor.dao;

import cc.insistor.model.po.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author cc
 */
public interface BookRepository extends JpaRepository<Book,Integer>, JpaSpecificationExecutor<Book> {
    /**
     *  查询以某个字符开始的所有书（使用既定规范命名的方法进行查询）使用find也可以
     * @param author
     * @return
     */
    List<Book> getBooksByAuthorStartingWith(String author);

    /**
     * 以作者姓名查找这本书
     * @param author
     * @return
     */
    List<Book> findByAuthor(String author);


    /**
     * 查询单价大衣某个值的所有书（使用既定规范命名的方法进行查询）使用get也可以
     * @param price
     * @return
     */
    List<Book> findBooksByPriceGreaterThan(Float price);


    /**
     * 查询id最大的书（使用原生的SQL进行查询）
     * 原生态的就是用数据库里的字段和表名，需要加上 nativeQuery = true
     * @return
     */
    @Query(value = "select * from t_book where id=(select max(id) from t_book)", nativeQuery = true)
    Book getMaxIdBook();


    /**
     * 根据id和author进行查询（使用JPQL语句查询）
     * 进行查询
     * @param author
     * @param id
     * @return
     */
    @Query("select b from Book b where b.id>:id and b.author=:author")
    List<Book> getBookByIdAndAuthor(@Param("author") String author, @Param("id") Integer id);


    /**
     * 根据id和name进行查询（使用JPQL语句查询，不过传参使用?1、?2这种方式）
     * @param name
     * @param id
     * @return
     */
    @Query("select b from Book b where b.id<?2 and b.name like %?1%" )
    List<Book> getBookByIdAndName(String name, Integer id);

    /**
     * byId
     * @param name
     * @return
     */
    @Query(value = "select * from t_book  where book_name like %?1%",nativeQuery = true)
    List<Book> cc(String name);

    /**
     * 通过id修改名字
     * @param id
     * @param value
     * @return
     */
    @Query(value="update Book set name = ?2 where id = ?1")
    @Modifying
    void updateNameById(Integer id,String value);




}
