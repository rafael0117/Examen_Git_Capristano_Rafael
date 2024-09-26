package main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Inventario;

public class Principal {
	
	EntityManagerFactory factory;
	EntityManager em;

	
	public void registroInventario (Inventario data) throws Exception {
		factory=Persistence.createEntityManagerFactory("LPII_T1_CAPRISTANO_MAMANI");
		em = factory.createEntityManager();
		em.getTransaction().begin();
		em.persist(data);
		em.getTransaction().commit();
		em.close();
		factory.close();
		
		System.out.println("Producto registrado correctamente");
		
	}
	public void ListadoInventario() {
		factory = Persistence.createEntityManagerFactory("LPII_T1_CAPRISTANO_MAMANI");
		em=factory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Inventario> q=em.createQuery("Select e from Inventario e",Inventario.class);
		
		List<Inventario> res=q.getResultList();
		for(Inventario item:res) {
			System.out.println("NroInventario:"+String.valueOf(item.getNro_inventario())+",IdProducto:"+item.getId_producto());
		}
		em.getTransaction().commit();
		em.close();
	
	}
	
	public static void main (String[] args ) {
		Principal p=new Principal();
		try {
			/*INI:REGISTRAR ESTUDIANTE*/
			Inventario inv=new Inventario() ;
			inv.setNro_inventario(10);
			inv.setId_producto(10);
			inv.setFecha("25-09-2024");
			
			
			p.registroInventario(inv);
			/*FIN:REGISTRAR ESTUDIANTE*/
			
		
			
			
			/*INI:BUSCAR TODOS ESTUDIANTE*/
			p.ListadoInventario();
			/*FIN:BUSCAR TODOS ESTUDIANTE*/
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	

}
