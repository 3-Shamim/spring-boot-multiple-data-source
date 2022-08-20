package com.learningstuff.springbootmultipledatasource.models.source_one;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by IntelliJ IDEA.
 * User: Md. Shamim Molla
 * Email: shamim.molla@vivasoftltd.com
 */

@Entity
@Table(schema = "source_one", name = "source_one")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class SourceOne {

    @Id
    private long id;

    private String name;

    private String countryCode;

}
