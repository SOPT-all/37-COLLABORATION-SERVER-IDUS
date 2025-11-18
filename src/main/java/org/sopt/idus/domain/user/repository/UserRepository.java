package org.sopt.idus.domain.user.repository;

import org.sopt.idus.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
