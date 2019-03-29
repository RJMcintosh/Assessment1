/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queuemanager;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rossspc
 */
public class OrderedlinkedlistTest {
    
    public OrderedlinkedlistTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of Head method, of class Orderedlinkedlist.
     */
       @Test
    public void testHead() throws Exception {
        System.out.println("head");
       Orderedlinkedlist instance = new Orderedlinkedlist();

         instance.add("test1",1);
         instance.add("test3",3);
         instance.add("test5",5);
         instance.add("test8",8);
       
       
        Object result = instance.head();
      
         System.out.println("Head Value "+result);
    }

    /**
     * Test of add method, of class Orderedlinkedlist.
     */
    @Test
    public void testAdd() throws Exception {
        System.out.println("add");
        Object item = null;
        int priority = 0;
        Orderedlinkedlist instance = new Orderedlinkedlist();
    
         instance.add("test1",1);
         instance.add("test3",3);
         instance.add("test2",2);
         instance.add("test4",4);
         
        
 
         Object result = instance.toString();
      
            System.out.println("Real Result "+result);
      
         
 
    }

    /**
     * Test of remove method, of class Orderedlinkedlist.
     */
    @Test
    public void testRemove() throws Exception {
        
        System.out.println("remove");
         
        Orderedlinkedlist instance = new Orderedlinkedlist();
        
        instance.add("test1",1);
         instance.add("test3",3);
         instance.add("test2",2);
         instance.add("test4",4);
         
        
        instance.remove();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of isEmpty method, of class Orderedlinkedlist.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        Orderedlinkedlist instance =  new Orderedlinkedlist();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Orderedlinkedlist.
     */
    @Test
    public void testToString() throws QueueOverflowException {
        System.out.println("toString");
      Orderedlinkedlist instance = new Orderedlinkedlist();
         
      
         instance.add("test1",1);
         instance.add("test6",6);
         instance.add("test2",2);
         instance.add("test5",5);
         
        String result = instance.toString(); 
      System.out.println(result);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }
    
        @Test
    public void testToString2() throws QueueOverflowException {
        System.out.println("toString");
      Orderedlinkedlist instance = new Orderedlinkedlist();
         
      
         instance.add("test4",4);
         instance.add("test1",1);
         instance.add("test2",2);
         instance.add(null,3);
         
        String result = instance.toString(); 
        
        System.out.println(result);
   
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }



   @Test
    public void testAdd2() throws Exception {
        System.out.println("add");
        Object item = null;
        int priority = 0;
        Orderedlinkedlist instance = new Orderedlinkedlist();
    

            instance.add(item,priority);
         instance.add(item,priority);
         instance.add(item,priority);
         instance.add(item,priority);
        
    
       
         Object result = instance.toString();
      
        
   System.out.println(result);
        
       
   //       result = instance.toString();
       // assertEquals(result);
        // TODO review the generated test code and remove the default call to fail.
     //   fail("The test case is a prototype.");
    }
    
    
       @Test
    public void testAdd3() throws Exception {
        System.out.println("add");
        Object item = null;
        int priority = 0;
        Orderedlinkedlist instance = new Orderedlinkedlist();
    
         instance.add("test1",1);
         instance.add("test3",3);
         instance.add("test2",2);
         instance.add("test4",4);
         instance.add("test1",5);
         instance.add("test3",6);
         instance.add("test2",7);
         instance.add("test4",8);
         
        
    
    
         Object result = instance.toString();

        
         
          
        instance.toString();
         
   System.out.println(result);
    }
    
    //removing with null values
        @Test
    public void testRemove2() throws Exception {
        
        System.out.println("remove");
         
        Orderedlinkedlist instance = new Orderedlinkedlist();
        
        instance.add("test1",1);
         instance.add(null,3);
         instance.add("test2",2);
         instance.add("test4",4);
         
        
        instance.remove();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    //Big array
        @Test
    public void testRemove3() throws Exception {
        
        System.out.println("remove");
         
        Orderedlinkedlist instance = new Orderedlinkedlist();
        
     instance.add("test1",1);
         instance.add("test3",3);
         instance.add("test2",2);
         instance.add("test4",4);
         instance.add("test1",5);
         instance.add("test3",6);
         instance.add("test2",7);
         instance.add("test4",8);
         
        
        instance.remove();
      
    }
    
}
