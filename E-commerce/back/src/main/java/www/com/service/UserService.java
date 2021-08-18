package www.com.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import www.com.entities.User;

import java.util.List;


public interface UserService {
    List<User> getAll();

    void save(User user);

    User getById(long id);

    void deleteById(long id);

    Page<User> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);

    //Page<User> findUserPaginated(FindUserDTO findUserDTO, int pageNo, int pageSize, String sortField, String sortDirection);

    void resetPasswordSendEmail(User user, String domain);
}
