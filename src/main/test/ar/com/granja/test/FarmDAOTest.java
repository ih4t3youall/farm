package ar.com.granja.test;

import java.util.Iterator;

import org.junit.Test;
import org.mockito.Mockito;

import ar.com.granja.dao.FarmDAO;
import ar.com.granja.dto.FarmDTO;

public class FarmDAOTest {

	
	private FarmDAO farmDAO;
	
	@Test
	public void test() {
		
		farmDAO = Mockito.mock(FarmDAO.class);
		
		FarmDTO farmDTO = Mockito.mock(FarmDTO.class);
		
		
		Iterator i=Mockito.mock(Iterator.class);
		Mockito.when(i.next()).thenReturn("Hello").thenReturn("World");
		
	}

}
