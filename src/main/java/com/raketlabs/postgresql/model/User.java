package com.raketlabs.postgresql.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Users")
public class User extends AuditModel {
	@Id
    @GeneratedValue(generator = "user_generator")
    @SequenceGenerator(
            name = "user_generator",
            sequenceName = "user_sequence",
            initialValue = 1000
    )
    private Long id;
	
	
	@NotBlank
    @Size(min = 2, max = 100)
    private String name;
	
	@NotBlank
    @Size(min = 8, max = 100)
    private String email;
	
	@NotBlank
    @Size(min = 6, max = 100)
    private String password;
}
