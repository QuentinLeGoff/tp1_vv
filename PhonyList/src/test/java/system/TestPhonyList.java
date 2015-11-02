package system;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

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
	
	/**
	 * Tests the "remove" method.
	 * 
	 * @see PhonyList#remove(Object)
	 * @type Functional
	 * @input list=[3, 4, 1], Object=3
	 * @oracle new list must equals list without Object..
	 * @passed Yes
	 */
	@Test
    public void testRemove() {
		Object i=3;
    	PhonyList<Integer> list = list(3, 4, 1);
    	PhonyList<Integer> list2 = list(4, 1);
    	
    	assertTrue(list.remove(i));
    	
    	assertEquals(list, list2);
    }
	
	/**
	 * Tests the "remove" method with an empty list.
	 * 
	 * @see PhonyList#remove(Object)
	 * @type Functional
	 * @input list=[], Object=3
	 * @oracle it must returns false.
	 * @passed Yes
	 */
	@Test
    public void testRemove_EmptyList() {
		Object i=3;
    	PhonyList<Integer> emptyList = list();
    	
    	assertFalse(emptyList.remove(i));
    }
	
	/**
	 * Tests the "remove" method and try to remove non existant element.
	 * 
	 * @see PhonyList#remove(Object)
	 * @type Functional
	 * @input list=[3,4,1], Object=5
	 * @oracle it must returns false.
	 * @passed Yes
	 */
	@Test
    public void testRemove_DoesntExistElemnt() {
		Object i=5;
    	PhonyList<Integer> list = list(3, 4, 1);
    	
    	assertFalse(list.remove(i));
    }
	
	/**
	 * Tests the "removeAll" method.
	 * 
	 * @see PhonyList#removeAll(Collection)
	 * @type Functional
	 * @input list=[3, 4, 1], Collection= [3,4]
	 * @oracle new list must equals list without Objects specified in Collection..
	 * @passed Yes
	 */
	@Test
    public void testRemoveAll() {
    	PhonyList<Integer> list = list(3, 4, 1);
    	PhonyList<Integer> listToCheckWith = list(1);
    	Collection<Integer> collec = new LinkedList<Integer>();
    	collec.add(3);
    	collec.add(4);
    	
    	assertTrue(list.removeAll(collec));
    	
    	assertEquals(list, listToCheckWith);
    }
	
	/**
	 * Tests the "removeAll" method with an empty list
	 * 
	 * @see PhonyList#removeAll(Collection)
	 * @type Functional
	 * @input list=[], Collection= [3,4]
	 * @oracle it must returns false
	 * @passed Yes
	 */
	@Test
    public void testRemoveAll_emptyList() {
    	PhonyList<Integer> emptyList = list();
    	Collection<Integer> collec = new LinkedList<Integer>();
    	collec.add(3);
    	collec.add(4);
    	
    	assertFalse(emptyList.removeAll(collec));
    }
	
	
	/**
	 * Tests the "removeAll" method with an arrayList implementation.
	 * 
	 * @see PhonyList#removeAll(Collection)
	 * @type Functional
	 * @input list=[3, 4, 1], Collection= [3,4]
	 * @oracle new list must equals list without Objects specified in Collection..
	 * @passed Yes
	 */
	@Test
    public void testRemoveAll_ArrayList() {
    	PhonyList<Integer> list = list(3, 4, 1);
    	PhonyList<Integer> listToCheckWith = list(1);
    	Collection<Integer> collec = new ArrayList<Integer>();
    	collec.add(3);
    	collec.add(4);
    	
    	assertTrue(list.removeAll(collec));
    	
    	assertEquals(list, listToCheckWith);
    }
	
	/**
	 * Tests the "set" method.
	 * 
	 * @see PhonyList#set(int, Integer)
	 * @type Functional
	 * @input list=[3, 4, 1], int i=2, Integer=5
	 * @oracle new list must equals the list with replaced element.
	 * @passed No
	 */
	@Test
    public void testSet() {
		Integer element = new Integer(5);
		int i = 2;
    	PhonyList<Integer> list = list(3, 4, 1);
    	PhonyList<Integer> expected = list(3, 4, 5);
    	
    	assertEquals(list.set(i, element), (Integer)1);
    	assertEquals(expected, list);
    }
	
	/**
	 * Tests the "add" method.
	 * 
	 * @see PhonyList#add(Integer)
	 * @type Functional
	 * @input list=[3, 4, 1], Integer=5
	 * @oracle new list must equals the list with added element.
	 * @passed Yes
	 */
	@Test
    public void testAdd() {
		Integer element = new Integer(5);
    	PhonyList<Integer> list = list(3, 4, 1);
    	PhonyList<Integer> expected = list(3, 4, 1, 5);
    	
    	assertTrue(list.add(element));
    	assertEquals(expected, list);
    }
	
	/**
	 * Tests the "addAll" method.
	 * 
	 * @see PhonyList#addAll(int, Collection)
	 * @type Functional
	 * @input list=[3, 4, 1], Collection=(5,6,2), i=1
	 * @oracle new list must equals the list with added collection at specified position.
	 * @passed Yes
	 */
	@Test
    public void testAddAll() {
		int i = 1;
    	PhonyList<Integer> actual = list(3, 4, 1);
    	PhonyList<Integer> expected = list(3, 5, 6, 2, 4, 1);
    	Collection<Integer> collec = new ArrayList<Integer>();
    	collec.add(5);
    	collec.add(6);
    	collec.add(2);
    	
    	assertTrue(actual.addAll(i, collec));
    	assertEquals(expected, actual);
    }
	
	/**
	 * Tests the "addAll" method with an empty list.
	 * 
	 * @see PhonyList#addAll(int, Collection)
	 * @type Functional
	 * @input list=[], Collection=(5,6,2), i=0
	 * @oracle it must return a list that contains added elements.
	 * @passed No
	 */
	@Test
    public void testAddAll_EmptyList() {
		int i = 0;
    	PhonyList<Integer> actual = list();
    	PhonyList<Integer> expected = list(5,6,2);
    	Collection<Integer> collec = new ArrayList<Integer>();
    	collec.add(5);
    	collec.add(6);
    	collec.add(2);
    	
    	assertFalse(actual.addAll(i, collec));
    	assertEquals(expected, actual);
    }
	
	
}
