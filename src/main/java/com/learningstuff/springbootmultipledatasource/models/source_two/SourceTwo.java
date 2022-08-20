package com.learningstuff.springbootmultipledatasource.models.source_two;

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
@Table(schema = "source_two")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class SourceTwo {

    @Id
    private long id;

    private String name;

}
