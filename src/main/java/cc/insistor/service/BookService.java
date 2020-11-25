package cc.insistor.service;

import cc.insistor.model.dto.PageDTO;

/**
 * @author
 * 书的service
 */
public interface BookService {

    void updateEmailById(String name, Integer id, PageDTO pageDTO);
}
