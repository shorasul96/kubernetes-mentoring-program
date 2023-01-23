package com.epam.userservice.repository;

import com.epam.userservice.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Modifying
    @Query(value = "update epam_users "
            + " set amount_of_posts = (amount_of_posts + 1) "
            + " where id = :id",
            nativeQuery = true)
    void updatePostAmountByUserId(@Param("id") Long userId);
}
