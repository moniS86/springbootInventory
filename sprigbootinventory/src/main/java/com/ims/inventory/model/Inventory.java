package com.ims.inventory.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Inventories")
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
public @Data @AllArgsConstructor class Inventory{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private  long id;
	@NotNull
	private String name;
	private String description;
	

}