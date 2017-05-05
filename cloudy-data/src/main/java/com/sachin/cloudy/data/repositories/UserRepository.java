package com.sachin.cloudy.data.repositories;

import com.sachin.cloudy.data.entities.User;
import org.springframework.stereotype.Repository;

/**
 * Created by sachinhooda on 25/2/17.
 */
@Repository
public interface UserRepository extends BaseRepository<User, Long> {
    User findByEmail(String email);
}
