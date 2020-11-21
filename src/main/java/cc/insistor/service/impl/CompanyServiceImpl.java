package cc.insistor.service.impl;

import cc.insistor.dao.CompanyRepository;
import cc.insistor.model.dto.CompanyDTO;
import cc.insistor.model.dto.PageDTO;
import cc.insistor.model.po.Company;
import cc.insistor.model.vo.CompanyVO;
import cc.insistor.model.vo.JsonResultVO;
import cc.insistor.service.CompanyService;
import cc.insistor.util.JsonResultUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


/**
 * @author cc
 *
 *
 * Transactional(rollbackFor=Exception.class)，如果类加了这个注解，那么这个类里面的方法抛出异常，就会回滚，
 *  数据库里面的数据也会回滚
 */

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyRepository companyRepository;


    @Transactional(rollbackFor = Exception.class)
    @Override
    public JsonResultVO saveCompany(CompanyDTO companyDTO) {
        Company company = new Company();
        BeanUtils.copyProperties(companyDTO, company);
        Company save = companyRepository.save(company);
        return JsonResultUtil.success(save);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public JsonResultVO deleteCompanyById(String id) {
        companyRepository.deleteById(id);
        return JsonResultUtil.success();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public JsonResultVO updateCompany(CompanyDTO companyDTO) {
        Company company = new Company();
        BeanUtils.copyProperties(companyDTO,company);
        Company save = companyRepository.save(company);
        return JsonResultUtil.success(save);
    }


    @Transactional(rollbackFor = Exception.class)
    @Override
    public JsonResultVO findCompanyById(String id) {
        Optional<Company> byId = companyRepository.findById(id);
        CompanyVO companyVO = null;
        if(byId.isPresent()){
            companyVO = new CompanyVO();
            BeanUtils.copyProperties(byId.get(),companyVO);
        }
        return JsonResultUtil.success(companyVO);
    }


    @Transactional(rollbackFor = Exception.class)
    @Override
    public JsonResultVO findCompanyByName(String name) {

        return null;
    }



    @Transactional(rollbackFor = Exception.class)
    @Override
    public JsonResultVO findCompanyByPage(String name, PageDTO pageDTO) {
        return null;
    }



    @Transactional(rollbackFor = Exception.class)
    @Override
    public JsonResultVO checkExisCompanyName(String name) {
        return null;
    }
}
