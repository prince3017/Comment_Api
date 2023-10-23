package com.example.CommentApi.Repo;

import com.example.CommentApi.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByCommentTo(String commentTo);
}
