package org.sopt.idus.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.sopt.idus.domain.user.entity.User;
import org.sopt.idus.domain.user.repository.UserRepository;
import org.sopt.idus.global.exception.customexception.CustomException;
import org.springframework.stereotype.Service;

import static org.sopt.idus.domain.user.errorcode.UserErrorCode.USER_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User findById(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new CustomException(USER_NOT_FOUND));
    }
}
