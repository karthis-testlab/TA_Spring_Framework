package com.ta.spring.code.TA_Spring_Framework.pojo.files;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "user_info")
@JsonPropertyOrder({
	"id",
	"name",
	"dob"
})
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "auto_id")
	@SequenceGenerator(initialValue = 6, name = "auto_id")
	private int id;
	
	@NotNull(message = "name is a mandatory field")
	@Size(min = 2, max = 20, message = "name should between 2 to 20 charaters")
	private String name;
	
	@Past(message = "dob cannot be in current or future date")
	private LocalDate dob;

}