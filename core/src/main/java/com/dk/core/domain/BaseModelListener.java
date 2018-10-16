package com.dk.core.domain;




import javax.persistence.PreUpdate;

public class BaseModelListener {


	@PreUpdate
	public static void preUpdate(BaseModel baseModel) {
		baseModel.setLastModifyTime(System.currentTimeMillis());
	}




}
