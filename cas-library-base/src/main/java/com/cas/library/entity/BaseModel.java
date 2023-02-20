package com.cas.library.entity;

import java.time.LocalDateTime;

import com.cas.library.entity.EnumModel.StatusEnum;

public class BaseModel {

	protected Integer page;
	protected Integer totalPage;
	protected Integer totalRecord;

	protected StatusEnum status;
	private LocalDateTime createdDate;
	private LocalDateTime updatedDate;

}
