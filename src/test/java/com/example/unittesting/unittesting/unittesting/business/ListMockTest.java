package com.example.unittesting.unittesting.unittesting.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

public class ListMockTest {

	/*
	 * Retornos por defecto:
	 * 	null
	 * 	Lista vacía
	 * 	false
	 * 	0
	 * 
	 */
	
	
	List<String> mock = mock(List.class);
	
	@Test
	public void size_basic() {
		when(mock.size()).thenReturn(5);
		assertEquals(5,mock.size());
	}
	
	@Test
	public void returnDifferentValues() {
		when(mock.size()).thenReturn(5).thenReturn(10);
		assertEquals(5,mock.size());
		assertEquals(10,mock.size());
	}
	
	@Test
	public void returnWithParameters() {
		when(mock.get(0)).thenReturn("asd");
		assertEquals("asd",mock.get(0));
	}
	
	@Test
	public void returnGenericParameters() {
		when(mock.get(Mockito.anyInt())).thenReturn("asd");
		assertEquals("asd",mock.get(0));
		assertEquals("asd",mock.get(1));
		assertEquals("asd",mock.get(5));
	}
	
	@Test
	public void verificationBasics() {
		//SUT
//		String value = mock.get(0);
		
		//Verify OK
//		verify(mock).get(0);
//		verify(mock).get(Mockito.anyInt());
//		verify(mock,times(1)).get(Mockito.anyInt());
		
		mock.get(10);
		verify(mock).get(10);
		//Le pido comprobar cuantos llamados se realizaron a get(10)
		//Por defecto, verifica que se llamó una vez  

		//Si quiero comprobar más de un llamado uso times(..)
		
		//SUT
		mock.get(0);
		mock.get(0);
//		verify(mock).get(0); 
		//Falla porque se llamó 2 veces a get(0), tengo que indicarle con times(2) para decirle que se llamó 2 veces

		//SUT
		mock.get(1);
		mock.get(1);
		verify(mock,times(2)).get(1); 
		//Ahora si, le dije que se llamó 2 veces, efectivamente fue así, entonces el test pasa OK
		
		
		//SUT
		verify(mock,times(5)).get(Mockito.anyInt()); 
		//Si quiero comprobarla cantidad de llamados con parámetro cualquier entero, uso anyInt() 
		
		//PAra verificar que se llamó "al menos" X llamados...
		verify(mock,atLeast(3)).get(Mockito.anyInt());
		
		//PAra verificar que se llamó "al menos una vez" llamados...
		verify(mock,atLeastOnce()).get(Mockito.anyInt());
		
		//PAra verificar que se llamó "como máximo" X llamados...
		verify(mock,Mockito.atMost(8)).get(Mockito.anyInt());
		
		//PAra verificar que nunca se llamó get(20)...
		verify(mock,Mockito.never()).get(20);
		
	}
	
	@Test
	public void argumentCapturing() {
		//SUT
		mock.add("some string");
		
		//Verification
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mock).add(captor.capture());
		
		assertEquals("some string",captor.getValue());
	}
	
	@Test
	public void multipleArgumentCapturing() {
		//SUT
		mock.add("some string1");
		mock.add("some string2");
		
		//Verification	   
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		
		verify(mock,times(2)).add(captor.capture());//Tengo que indicar el segundo parámetro

		List<String> allValues = captor.getAllValues();
		assertEquals("some string1",allValues.get(0));
		assertEquals("some string2",allValues.get(1));
	}
	
	@Test
	@Ignore
	public void mocki() {
		ArrayList arrayListMock = mock(ArrayList.class);
		System.out.println(arrayListMock.get(0));//null
		System.out.println(arrayListMock.size());//0
		arrayListMock.add("Test");
		arrayListMock.add("Test2");
		System.out.print(arrayListMock.size());
		when(arrayListMock.size()).thenReturn(5);
		System.out.print(arrayListMock.size());		
	}
	
	
	@Test
//	@Ignore
	public void spying() {
		ArrayList arrayListSpy = spy(ArrayList.class);
		arrayListSpy.add("Test0");
		System.out.println(arrayListSpy.get(0));//0
		System.out.println(arrayListSpy.size());//1
		arrayListSpy.add("Test");
		arrayListSpy.add("Test2");
		System.out.println(arrayListSpy.size());//3

		when(arrayListSpy.size()).thenReturn(5);
		System.out.println(arrayListSpy.size());//5		
		
		arrayListSpy.add("Test4");
		System.out.println(arrayListSpy.size());//5		
		
		verify(arrayListSpy).add("Test4");
	}
	
}
