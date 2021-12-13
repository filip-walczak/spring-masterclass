package pl.training.shop.users;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.training.shop.common.PagedResult;

public interface UserRepository extends JpaRepository<User, String> {

    Page<User> findByLastNameContaining(String lastNameFragment, Pageable pageable);
}
