package system;
import org.junit.Test;

import system.PhonyList;

import static org.junit.Assert.*;

public class TestPhonyList {

	/*
	 * Helper method to create lists.
	 */
	private PhonyList<Integer> list(Integer... content) {
		PhonyList<Integer> list = new PhonyList<>();
		for (Integer i : content)
			list.add(i);
		return list;
	}

	/*
	 * Helper method to create a big list [1,2,3,...,10000]
	 */
	private PhonyList<Integer> thousandElementsList() {
		PhonyList<Integer> thousandElementsList = new PhonyList<>();
		for (int i = 1; i <= 10000; i++) {
			thousandElementsList.add(i);
		}
		return thousandElementsList;
	}



	/**
	 * Tests the "equals" method with an empty list.
	 * 
	 * @see PhonyList#equals(Object)
	 * @type Functional
	 * @input list=[], list=[]
	 * @oracle It must return true.
	 * @passed Yes
	 */
	@Test
	public void testEquals_EmptyLists() {
		PhonyList<Integer> emptyList1 = list();
		PhonyList<Integer> emptyList2 = list();
		
		assertTrue(emptyList1.equals(emptyList2));
		
	}
	
	/**
	 * Tests the "equals" method with another equal list.
	 * 
	 * @see PhonyList#equals(Object)
	 * @type Functional
	 * @input list=[5,8,9,23], list=[5,8,9,23]
	 * @oracle It must return true.
	 * @passed Yes
	 */
	@Test
	public void testEquals_SameLists() {
		PhonyList<Integer> list1 = list(5,8,9,23);
		PhonyList<Integer> list2 = list(5,8,9,23);
		
		assertTrue(list1.equals(list2));
		
	}
	
	/**
	 * Tests the "equals" method with another list.
	 * 
	 * @see PhonyList#equals(Object)
	 * @type Functional
	 * @input list=[5,8,9,23], list=[]
	 * @oracle It must return false.
	 * @passed Yes
	 */
	@Test
	public void testEquals_DifferentLists() {
		PhonyList<Integer> list1 = list(5,8,9,23);
		PhonyList<Integer> list2 = list();
		
		assertFalse(list1.equals(list2));
		
	}
	
	/**
	 * Tests the "equals" method with an object.
	 * 
	 * @see PhonyList#equals(Object)
	 * @type Functional
	 * @input list=[5,8,9,23], o
	 * @oracle It must return false.
	 * @passed Yes
	 */
	@Test
	public void testEquals_Object() {
		PhonyList<Integer> list1 = list(5,8,9,23);
		Object o = new Object();
		
		assertFalse(list1.equals(o));
		
	}

	/**
	 * Tests the "size" method with an empty list.
	 * 
	 * @see PhonyList#size()
	 * @type Functional
	 * @input list=[]
	 * @oracle It must return 0.
	 * @passed Yes
	 */
	@Test
    public void testSize_EmptyList() {

    	PhonyList<Integer> emptyList = list();
    	
    	assertEquals(0, emptyList.size());
    }

	/**
	 * Tests the "size" method with an empty list.
	 * 
	 * @see PhonyList#size()
	 * @type Functional
	 * @input list=[1524785]
	 * @oracle It must return 1.
	 * @passed Yes
	 */
	@Test
    public void testSize_OneElement() {

    	PhonyList<Integer> emptyList = list(1524785);
    	
    	assertEquals(1, emptyList.size());
    }
	
	/**
	 * Tests the "size" method with an empty list.
	 * 
	 * @see PhonyList#size()
	 * @type Functional
	 * @input list=[5, 48, 14654156, 5521211]
	 * @oracle It must return 4.
	 * @passed Yes
	 */
	@Test
    public void testSize_Elements() {

    	PhonyList<Integer> emptyList = list(5, 48, 14654156, 5521211);
    	
    	assertEquals(4, emptyList.size());
    }
	
	/**
	 * Tests the "isEmpty" method with an empty list.
	 * 
	 * @see PhonyList#isEmpty()
	 * @type Functional
	 * @input list=[]
	 * @oracle It must return true.
	 * @passed Yes
	 */
	@Test
    public void testIsEmpty_emptyList() {

    	PhonyList<Integer> emptyList = list();
    	
    	assertTrue(emptyList.isEmpty());
    }
	
	/**
	 * Tests the "isEmpty" method with a list of elements.
	 * 
	 * @see PhonyList#isEmpty()
	 * @type Functional
	 * @input list=[3, 4, 1]
	 * @oracle It must return false.
	 * @passed Yes
	 */
	@Test
    public void testIsEmpty_ListOfElements() {

    	PhonyList<Integer> list = list(3, 4, 1);
    	
    	assertFalse(list.isEmpty());
    }
	
	/**
	 * Tests the "contains" method with a list of elements that doesn't contain Object
	 * 
	 * @see PhonyList#contains(Object)
	 * @type Functional
	 * @input list=[3, 4, 1], o=5
	 * @oracle It must return false.
	 * @passed Yes
	 */
	@Test
    public void testContains_DoesntContain() {
		Object i=5;
    	PhonyList<Integer> list = list(3, 4, 1);
    	
    	assertFalse(list.contains(i));
    }
	
	/**
	 * Tests the "contains" method with a list of elements that does contain Object
	 * 
	 * @see PhonyList#contains(Object)
	 * @type Functional
	 * @input list=[3, 4, 1], o=3
	 * @oracle It must return true.
	 * @passed No
	 * @correction <pre>
	 * l.180
	 * -  return indexOf(o) > 0;
	 * +  return indexOf(o) > -1;
	 * </pre>
	 */
	@Test
    public void testContains_DoesContain() {
		Object i=3;
    	PhonyList<Integer> list = list(3, 4, 1);
    	
    	assertTrue(list.contains(i));
    }
	
	/**
	 * Tests the "get" method with a list of elements.
	 * 
	 * @see PhonyList#get(int)
	 * @type Functional
	 * @input list=[3, 4, 1], int=0
	 * @oracle It must return 4.
	 * @passed Yes
	 */
	@Test
    public void testGet_FirstElement() {
		int i=0;
    	PhonyList<Integer> list = list(3, 4, 1);
    	
    	assertEquals(list.get(i), (Integer)3);
    }
	
	/**
	 * Tests the "get" method with a list of elements.
	 * 
	 * @see PhonyList#get(int)
	 * @type Functional
	 * @input list=[3, 4, 1], int=2
	 * @oracle It must return 4.
	 * @passed Yes
	 */
	@Test
    public void testGet_LastElement() {
		int i=2;
    	PhonyList<Integer> list = list(3, 4, 1);
    	
    	assertEquals(list.get(i), (Integer)1);
    }
}
