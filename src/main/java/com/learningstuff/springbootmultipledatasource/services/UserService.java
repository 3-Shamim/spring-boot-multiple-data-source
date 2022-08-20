package com.learningstuff.springbootmultipledatasource.services;

import com.learningstuff.springbootmultipledatasource.models.primary.User;
import com.learningstuff.springbootmultipledatasource.models.source_one.SourceOne;
import com.learningstuff.springbootmultipledatasource.models.source_two.SourceTwo;
import com.learningstuff.springbootmultipledatasource.repositories.primary.UserRepository;
import com.learningstuff.springbootmultipledatasource.repositories.source_one.SourceOneRepository;
import com.learningstuff.springbootmultipledatasource.repositories.source_two.SourceTwoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * Created by IntelliJ IDEA.
 * User: Md. Shamim Molla
 * Email: shamim.molla@vivasoftltd.com
 */

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final SourceOneRepository sourceOneRepository;
    private final SourceTwoRepository sourceTwoRepository;

    public HashMap<String, Object> users() {
        return new HashMap<>() {{
            put("primary-data-source", userRepository.findAll());
            put("data-source-one", sourceOneRepository.findAll());
            put("data-source-two", sourceTwoRepository.findAll());
        }};
    }

    public HashMap<String, Object> create(User user) {

        return new HashMap<>() {{
            put("primary-data-source", userRepository.save(user));
            put("data-source-one", sourceOneRepository.save(new SourceOne(user.getId(), user.getName(), "Code")));
            put("data-source-two", sourceTwoRepository.save(new SourceTwo(user.getId(), user.getName())));
        }};
    }

}
