package cc.insistor;

import cc.insistor.dao.BookRepository;
import cc.insistor.dao.CompanyRepository;
import cc.insistor.model.po.Book;
import cc.insistor.model.po.Company;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.annotation.Rollback;

import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
class AllApplicationTests {
    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private BookRepository bookRepository;

    @Test
    @Transactional
    @Rollback(false)
    void uBook(){
        bookRepository.updateNameById(5,"水浒传");
    }
    @Test
    void test(){
        Sort.TypedSort<Book> sort = Sort.sort(Book.class);
        Sort descending = sort.by(Book::getPrice).descending().and(sort.by(Book::getId)).descending();
        List<Book> all = bookRepository.findAll(descending);
        for(Book bk : all){
            System.out.println(bk);
        }
    }
    @Test
    void findAllBook(){
        PageRequest id = PageRequest.of(1, 5, Sort.Direction.DESC, "id");
        Page<Book> all = bookRepository.findAll(id);
        List<Book> content = all.getContent();
        for(Book bk :all){
            System.out.println(bk);
        }
    }

    @Test
    void contextLoads() {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable page = PageRequest.of(0, 10, sort);
        Specification<Book> specification = new Specification<Book>() {
            @Override
            public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path path = root.get("id");
                Predicate gt = criteriaBuilder.gt(path, 2);
                return gt;
            }
        };
        Page<Book> all = bookRepository.findAll(specification, page);
        List<Book> content = all.getContent();
        for(Book bk:content){
            System.out.println(bk);
        }


    }

    @Test
    void save(){
        Book book = new Book();
        book.setName("c++");
        book.setAuthor("ll");
        book.setPrice(11f);
        bookRepository.save(book);
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

    }







}
