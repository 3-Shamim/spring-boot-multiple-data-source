package com.learningstuff.springbootmultipledatasource.repositories.source_one;

import com.learningstuff.springbootmultipledatasource.models.source_one.SourceOne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * User: Md. Shamim Molla
 * Email: shamim.molla@vivasoftltd.com
 */

@Repository
public interface SourceOneRepository extends JpaRepository<SourceOne, Long> {
}
