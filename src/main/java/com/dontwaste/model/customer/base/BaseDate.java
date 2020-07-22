package com.dontwaste.model.customer.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter @Getter
@MappedSuperclass
public class BaseDate extends BaseId {
    @CreatedDate
    @Column(name="CREATED_ON", updatable = false)
    private LocalDateTime createdOn;

    @LastModifiedDate
    @Column(name="UPDATED_ON")
    private LocalDateTime updatedOn;
}
