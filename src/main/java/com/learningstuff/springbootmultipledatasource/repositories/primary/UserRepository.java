package com.learningstuff.springbootmultipledatasource.repositories.primary;

import com.learningstuff.springbootmultipledatasource.models.primary.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * User: Md. Shamim Molla
 * Email: shamim.molla@vivasoftltd.com
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
