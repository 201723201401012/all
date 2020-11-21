package cc.insistor;

import cc.insistor.dao.CompanyRepository;
import cc.insistor.model.po.Company;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class AllApplicationTests {
    @Autowired
    private CompanyRepository companyRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void testAdd() {
        Company company = new Company();
        company.setName("海康威视");
        companyRepository.save(company);
    }


    @Test
    void queryCompany(){
        List<Company> ali = companyRepository.findByName("阿里巴巴");
        for(Company it: ali){
            System.out.println(it);
        }

    }


    @Test
    void queryLike(){
        List<Company> ba = companyRepository.findByNameLike("巴");
        for(Company b : ba){
            System.out.println(b.getId()+" "+b.getName());
        }
    }


    @Test
    void deleteLike(){
        companyRepository.deleteCompanyByName("巴");

    }







}
