package com.cg.ams.entity;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class UserErrorResponse {
	private int status;
	private String msg;
	private LocalDateTime localDateTime;
}
