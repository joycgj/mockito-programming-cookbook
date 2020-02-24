package com.javacodegeeks;

import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class MyServiceTest {

    @Mock
    private MyDao myDao;

    @Test
    public void testFindById() {
        MockitoAnnotations.initMocks(this);
        MyService myService = new MyService(myDao);
        myService.findById(1L);
        Mockito.verify(myDao);
    }

    @Test
    public void testMock() {
        // Mock
        LinkedList mocklinkedList = Mockito.mock(LinkedList.class);
        // Stub
        Mockito.when(mocklinkedList.get(0)).thenReturn("First Value");
        // Verify
        Assert.assertEquals("First Value", mocklinkedList.get(0));
        Mockito.verify(mocklinkedList).get(0);
    }
}
