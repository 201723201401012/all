package cc.insistor.controller;


import cc.insistor.model.dto.CompanyDTO;
import cc.insistor.model.dto.PageDTO;
import cc.insistor.model.po.User;
import cc.insistor.model.vo.JsonResultVO;
import cc.insistor.service.CompanyService;
import cc.insistor.service.FileUploadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * @author cc
 * @date 2020-11-21 10:45
 *
 * Valid
 *  用于验证注解是否符合要求，直接加在变量user之前，在变量中添加验证信息的要求，
 *  当不符合要求时就会在方法中返回message 的错误提示信息。
 *
 *
 * requestparam( required = false) 的作用？
 *  不传值后台也不会报错，但是如果@requestparam( required = false)的括号中指定了基本数据类型，
 *  例如(@requestparam(value = 'num' required = false)  int num) 这个时候如果不传值是会报错的，
 *  因为不传值就赋null,但是int类型不能为null,解决办法，修改成Integer即可
 *
 *
 *
 *  RequestBody：
 *      作用：
 *          主要用来接收前端传递给后端的json字符串中的数据的(请求体中的数据的)；
 *      要求：
 *          GET方式无请求体，所以使用@RequestBody接收数据时，前端不能使用GET方式提交数据，而是用POST方式进行提交。
 *          在后端的同一个接收方法里，@RequestBody与@RequestParam()可以同时使用，@RequestBody最多只能有一个，而@RequestParam()可以有多个。
 */
@Api(tags = "测试")
@RestController
@RequestMapping("/api/v1/test")
public class TestController {
    @Autowired
    private CompanyService companyService;
    @Autowired
    private FileUploadService fileUploadService;

    @ApiOperation("上传文件")
    @PostMapping("/upload")
    public String upload(MultipartFile uploadFile, HttpServletRequest req){
        return fileUploadService.upload(uploadFile,req);
    }

    @ApiOperation("user")
    @PostMapping("/user")
    public User create (@Valid @RequestBody User user) {
        System.out.println(user.getId());
        System.out.println(user.getName());
        System.out.println(user.getPassWord());
        user.setId(111);
        return user;
    }



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
    @ApiOperation("不分页查询公司")
    @ApiImplicitParam(paramType = "query", name = "name", value = "公司名称", required = false, dataType = "String")
    @GetMapping("/findByName")
    public JsonResultVO findCompanyByName(@RequestParam(required = false) String name){
        return companyService.findCompanyByName(name);
    }

    @ApiOperation("编辑公司")
    @PostMapping("/update")
    public JsonResultVO updateCompany(@RequestBody @Valid CompanyDTO companyDTO){
        return companyService.updateCompany(companyDTO);
    }

    @ApiOperation("通过名字分页查询公司")
    @ApiImplicitParam(paramType = "query",name = "cc",value = "公司名称",required = false,dataType = "String")
    @GetMapping("/findByPage")
    public JsonResultVO findCompanyByPage(@RequestParam(required = false) String name, @Valid PageDTO pageDTO){
        return companyService.findCompanyByPage(name,pageDTO);
    }
}
