package cc.insistor.service;

import cc.insistor.model.dto.CompanyDTO;
import cc.insistor.model.dto.PageDTO;
import cc.insistor.model.vo.JsonResultVO;

/**
 * @author cc
 */
public interface CompanyService {
    /**
     * 存入一个公司数据
     * @param companyDTO
     * @return JsonResultVO
     */
    JsonResultVO saveCompany(CompanyDTO companyDTO);

    /**
     * 通过id删除一个公司
     * @param id
     * @return
     */
    JsonResultVO deleteCompanyById(String id);

    /**
     * 删除某个公司
     * @param companyDTO
     * @return
     */
    JsonResultVO updateCompany(CompanyDTO companyDTO);


    /**
     * 通过id查找一个公司
     * @param id
     * @return
     */
    JsonResultVO findCompanyById(String id);


    /**
     * 通过name查找一个公司
     * @param name
     * @return
     */
    JsonResultVO findCompanyByName(String name);

    /**
     * 分页查找
     * @param name
     * @param pageDTO
     * @return
     */
    JsonResultVO findCompanyByPage(String name, PageDTO pageDTO);

    /**
     * 通过公司名称看是否存在
     * @param name
     * @return
     */
    JsonResultVO checkExisCompanyName(String name);



}
