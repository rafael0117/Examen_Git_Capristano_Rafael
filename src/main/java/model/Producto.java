package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity

@Table(name="productos")
public class Producto implements Serializable {
	private static final long serialVersionUID=1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_prod")
	private int id_prod; 
	
	@Column(name="stock")
	private int stock;

	@Column(name="id_cate")
	private int id_cate;

	@Column(name="nom_prod",nullable = false)
	private String nom_prod;
	
	

}
