package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name="inventario")
public class Inventario implements Serializable{

	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int nro_inventario;
	
	
	@Column(name="fecha" , nullable=false)
	private String fecha;
	
	@Column(name="id_prod")
	private int id_producto;
	
	@Transient
	private transient double costo_ingreso;
	
	
}
