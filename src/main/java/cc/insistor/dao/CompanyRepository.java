package cc.insistor.dao;

import cc.insistor.model.po.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author cc
 */
public interface CompanyRepository extends JpaRepository<Company, String> , JpaSpecificationExecutor<Company> {

    /**
     * 通过name查找
     *
     * @param name
     * @return
     */
    List<Company> findByName(String name);

    /**
     * 模糊查询
     *
     * @param name
     * @return
     */
    @Modifying
    @Query("select c from Company c where c.name like %?1%")
    List<Company> findByNameLike(String name);

    /**
     * 通过名字查找
     *
     * @param name
     * @param sort
     * @return
     */
    @Query(value = "select t from Company t where t.name like %?1%")
    List<Company> findByName(String name, Sort sort);

    /**
     * 分页查询
     *
     * @param name
     * @param page
     * @return
     */
    @Query(value = "select t from Company t where t.name like %?1%")
    Page<Company> findByPage(String name, Pageable page);


}
