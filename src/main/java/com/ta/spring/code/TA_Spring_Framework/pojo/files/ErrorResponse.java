package com.ta.spring.code.TA_Spring_Framework.pojo.files;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder(toBuilder = true)
@JsonPropertyOrder({
"code",
"message",
"details",
"time_stamp"
})
public class ErrorResponse {
	
	private int code;
	private List<String> message;
	@JsonProperty("time_stamp")
	private LocalDateTime timeStamp;
	private String details;

}