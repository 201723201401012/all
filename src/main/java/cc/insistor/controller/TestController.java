package cc.insistor.controller;


import cc.insistor.model.dto.CompanyDTO;
import cc.insistor.model.vo.JsonResultVO;
import cc.insistor.service.CompanyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author cc
 * @date 2020-11-21 10:45
 */
@Api(tags = "测试")
@RestController
@RequestMapping("/api/v1/test")
public class TestController {
    @Autowired
    private CompanyService companyService;


    @ApiOperation("增")
    @PostMapping("/save")
    public JsonResultVO savaCompany(@RequestBody @Valid CompanyDTO companyDTO){
        return companyService.saveCompany(companyDTO);
    }

    @ApiOperation("删")
    @PostMapping("/deleteById/{id}")
    public JsonResultVO deleteCompanyById(@PathVariable String id){
        return companyService.deleteCompanyById(id);

    }

    public JsonResultVO updateCompany(CompanyDTO companyDTO){
        return companyService.updateCompany(companyDTO);
    }
}
