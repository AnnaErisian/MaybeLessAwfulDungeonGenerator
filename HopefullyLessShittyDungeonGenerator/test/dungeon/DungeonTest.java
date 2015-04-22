package dungeon;

import static org.junit.Assert.*;

import org.junit.Test;

import sigmaj.fun.dungeon.Dungeon;

public class DungeonTest {

	@Test
	public void testAddRows() {
		Dungeon d = new Dungeon(5,5);
		assertTrue(d.rows() == 5);
		assertTrue(d.columns() == 5);

		d.get(0, 0).setTag1(1);
		d.get(0, 4).setTag1(2);
		d.get(4, 0).setTag1(3);
		d.get(4, 4).setTag1(4);

		try
		{
			d.get(5, 4).setTag1(4);
			fail("Index out of bounds didn't throw.");
		} catch(IndexOutOfBoundsException e)
		{
			//good
		}
		try
		{
			d.get(4, 5).setTag1(4);
			fail("Index out of bounds didn't throw.");
		} catch(IndexOutOfBoundsException e)
		{
			//good
		}
		
		assertTrue(d.get(0, 0).getTag1() == 1);
		assertTrue(d.get(0, 4).getTag1() == 2);
		assertTrue(d.get(4, 0).getTag1() == 3);
		assertTrue(d.get(4, 4).getTag1() == 4);
		
		d.addRows(10);
		assertTrue(d.rows() == 15);
		assertTrue(d.get(0, 0).getTag1() == 1);
		assertTrue(d.get(0, 4).getTag1() == 2);
		assertTrue(d.get(4, 0).getTag1() == 3);
		assertTrue(d.get(4, 4).getTag1() == 4);
		
		d.get(14, 0).setTag1(9);
		d.get(14, 1).setTag1(8);
		d.get(14, 2).setTag1(7);
		d.get(14, 3).setTag1(6);

		assertTrue(d.get(14, 0).getTag1() == 9);
		assertTrue(d.get(14, 1).getTag1() == 8);
		assertTrue(d.get(14, 2).getTag1() == 7);
		assertTrue(d.get(14, 3).getTag1() == 6);
		
		try
		{
			d.get(15, 4).setTag1(4);
			fail("Index out of bounds didn't throw.");
		} catch(IndexOutOfBoundsException e)
		{
			//good
		}
		try
		{
			d.get(4, 15).setTag1(4);
			fail("Index out of bounds didn't throw.");
		} catch(IndexOutOfBoundsException e)
		{
			//good
		}

	}

	@Test
	public void testAddColumns() {
		Dungeon d = new Dungeon(5,5);
		assertTrue(d.rows() == 5);
		assertTrue(d.columns() == 5);
		
		d.get(0, 0).setTag1(1);
		d.get(0, 4).setTag1(2);
		d.get(4, 0).setTag1(3);
		d.get(4, 4).setTag1(4);
		
		try
		{
			d.get(5, 4).setTag1(4);
			fail("Index out of bounds didn't throw.");
		} catch(IndexOutOfBoundsException e)
		{
			//good
		}
		try
		{
			d.get(4, 5).setTag1(4);
			fail("Index out of bounds didn't throw.");
		} catch(IndexOutOfBoundsException e)
		{
			//good
		}
		
		assertTrue(d.get(0, 0).getTag1() == 1);
		assertTrue(d.get(0, 4).getTag1() == 2);
		assertTrue(d.get(4, 0).getTag1() == 3);
		assertTrue(d.get(4, 4).getTag1() == 4);
		
		d.addColumns(10);
		assertTrue(d.columns() == 15);
		assertTrue(d.get(0, 0).getTag1() == 1);
		assertTrue(d.get(0, 4).getTag1() == 2);
		assertTrue(d.get(4, 0).getTag1() == 3);
		assertTrue(d.get(4, 4).getTag1() == 4);
		
		d.get(0, 14).setTag1(9);
		d.get(1, 14).setTag1(8);
		d.get(2, 14).setTag1(7);
		d.get(3, 14).setTag1(6);
		
		assertTrue(d.get(0, 14).getTag1() == 9);
		assertTrue(d.get(1, 14).getTag1() == 8);
		assertTrue(d.get(2, 14).getTag1() == 7);
		assertTrue(d.get(3, 14).getTag1() == 6);
		
		try
		{
			d.get(15, 4).setTag1(4);
			fail("Index out of bounds didn't throw.");
		} catch(IndexOutOfBoundsException e)
		{
			//good
		}
		try
		{
			d.get(4, 15).setTag1(4);
			fail("Index out of bounds didn't throw.");
		} catch(IndexOutOfBoundsException e)
		{
			//good
		}
	}
}
