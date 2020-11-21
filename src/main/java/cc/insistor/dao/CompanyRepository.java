package cc.insistor.dao;

import cc.insistor.model.po.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author cc
 */
public interface CompanyRepository extends JpaRepository<Company,String> {

    /**
     * 通过name查找
     * @param name
     * @return
     */
    List<Company>findByName(String name);

    /**
     * 模糊查询
     * @param name
     * @return
     */
    @Modifying
    @Query("select c from Company c where c.name like %?1%")
    List<Company>findByNameLike(String name);


    /**
     * 通过模糊名字删除
     * @param name
     */
    @Query("delete from Company c where c.name = ?1")
    void deleteCompanyByName(String name);




}
