package pl.training.shop.users;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import pl.training.shop.common.PagedResult;

@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User add(User user) {
        return userRepository.save(user);
    }

    public User findById(String id) {
        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    public PagedResult<User> findByLastName(String lastNameFragment, int pageSize, int pageNumber) {
        Page<User> usersPage = userRepository.findByLastNameContaining(lastNameFragment, PageRequest.of(pageNumber, pageSize));
        return new PagedResult(usersPage.toList(), pageNumber, usersPage.getTotalPages());
    }
}
