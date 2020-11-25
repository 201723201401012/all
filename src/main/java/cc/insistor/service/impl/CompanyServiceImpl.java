package cc.insistor.service.impl;

import cc.insistor.dao.CompanyRepository;
import cc.insistor.model.dto.CompanyDTO;
import cc.insistor.model.dto.PageDTO;
import cc.insistor.model.po.Company;
import cc.insistor.model.vo.CompanyVO;
import cc.insistor.model.vo.JsonPageResultVO;
import cc.insistor.model.vo.JsonResultVO;
import cc.insistor.service.CompanyService;
import cc.insistor.util.JsonResultUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


/**
 * @author cc
 * Transactional(rollbackFor=Exception.class)，如果类加了这个注解，那么这个类里面的方法抛出异常，就会回滚，
 *  数据库里面的数据也会回滚
 *  springDataJpa中使用jpql完成 更新/删除操作
 *     需要手动添加事务的支持
 *     默认会执行结束之后，回滚事务
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
        BeanUtils.copyProperties(companyDTO, company);
        Company save = companyRepository.save(company);
        return JsonResultUtil.success(save);
    }


    @Transactional(rollbackFor = Exception.class)
    @Override
    public JsonResultVO findCompanyById(String id) {
        Optional<Company> byId = companyRepository.findById(id);
        CompanyVO companyVO = null;
        if (byId.isPresent()) {
            companyVO = new CompanyVO();
            BeanUtils.copyProperties(byId.get(), companyVO);
        }
        return JsonResultUtil.success(companyVO);
    }


    @Transactional(rollbackFor = Exception.class)
    @Override
    public JsonResultVO findCompanyByName(String name) {
        Sort.TypedSort<Company> sort = Sort.sort(Company.class);
        Sort and = sort.by(Company::getCreateTimestamp);
        List<Company> list;
        if (StringUtils.isNoneBlank(name)) {
            list = companyRepository.findByName(name,sort);
        } else {
            list = companyRepository.findAll(sort);
        }
        List<CompanyVO> listVo = list.stream().map(e -> {
            CompanyVO companyVO = new CompanyVO();
            BeanUtils.copyProperties(e, companyVO);
            return companyVO;

        }).collect(Collectors.toList());
        return JsonResultUtil.success(listVo);
    }


    @Transactional(rollbackFor = Exception.class)
    @Override
    public JsonResultVO findCompanyByPage(String name, PageDTO pageDTO) {
        Sort.TypedSort<Company> sort = Sort.sort(Company.class);
        Sort descending = sort.by(Company::getCreateTimestamp).descending().and(sort.by(Company::getId)).descending();
        Pageable of = PageRequest.of(pageDTO.getOffset(), pageDTO.getLimit(), descending);
        Page<Company>page;
        if(StringUtils.isNoneBlank(name)){
            page = companyRepository.findByPage(name, of);
        } else {
            page = companyRepository.findAll(of);
        }

        List<CompanyVO> list = page.stream().map(e -> {
            CompanyVO companyVO = new CompanyVO();
            BeanUtils.copyProperties(e,companyVO);
            return companyVO;
        }).collect(Collectors.toList());
        JsonPageResultVO jsonPageResultVO = new JsonPageResultVO(page.getTotalElements(), page.getTotalPages(), list);
        return JsonResultUtil.success(jsonPageResultVO);
    }


    @Transactional(rollbackFor = Exception.class)
    @Override
    public JsonResultVO checkExisCompanyName(String name) {
        return null;
    }
}
