package com.learningstuff.springbootmultipledatasource.repositories.source_two;

import com.learningstuff.springbootmultipledatasource.models.source_two.SourceTwo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * User: Md. Shamim Molla
 * Email: shamim.molla@vivasoftltd.com
 */

@Repository
public interface SourceTwoRepository extends JpaRepository<SourceTwo, Long> {
}
