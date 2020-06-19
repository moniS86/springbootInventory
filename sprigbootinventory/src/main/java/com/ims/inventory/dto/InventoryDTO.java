package com.ims.inventory.dto;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
public @Data @AllArgsConstructor class InventoryDTO{

	private  long id;
	@NotNull
	private String name;
	private String description;
	

}