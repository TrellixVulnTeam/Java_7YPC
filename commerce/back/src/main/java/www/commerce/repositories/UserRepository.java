package www.commerce.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import www.commerce.entities.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
    //User findByEmail(String email);
    User findByUsername(String username);
    boolean existsByUsername(String username);
    //boolean existsByEmail(String username);

}