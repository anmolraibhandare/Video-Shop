package shop.data;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class VideoTEST {
    
	@Test
	public void testConstructorAndAttributes() {
	    String title1 = "XX";
	    String director1 = "XY";
	    String title2 = " XX ";
	    String director2 = " XY ";
	    int year = 2002;

	    VideoObj v1 = new VideoObj(title1, year, director1);
	    assertSame(title1, v1.title());
	    assertEquals(year, v1.year());
	    assertSame(director1, v1.director());

	    VideoObj v2 = new VideoObj(title2, year, director2);
	    assertEquals(title1, v2.title());
	    assertEquals(director1, v2.director());
	  }
		
	
	@Test
	  public void testConstructorExceptionYear() {
	    try {
	      new VideoObj("X", 1800, "Y");
	      fail();
	    } catch (IllegalArgumentException e) { }
	    try {
	      new VideoObj("X", 5000, "Y");
	      fail();
	    } catch (IllegalArgumentException e) { }
	    try {
	      new VideoObj("X", 1801, "Y");
	      new VideoObj("X", 4999, "Y");
	    } catch (IllegalArgumentException e) {
	      fail();
	    }
	  }
	
	@Test
	  public void testConstructorExceptionTitle() {
	    try {
	      new VideoObj(null, 2002, "Y");
	      fail();
	    } catch (IllegalArgumentException e) { }
	    try {
	      new VideoObj("", 2002, "Y");
	      fail();
	    } catch (IllegalArgumentException e) { }
	    try {
	      new VideoObj(" ", 2002, "Y");
	      fail();
	    } catch (IllegalArgumentException e) { }
	  }
	
	@Test
	  public void testConstructorExceptionDirector() {
		  try {
		      new VideoObj("X", 2002, null);
		      fail();
		    } catch (IllegalArgumentException e) { }
		    try {
		      new VideoObj("X", 2002, "");
		      fail();
		    } catch (IllegalArgumentException e) { }
		    try {
		      new VideoObj("X", 2002, " ");
		      fail();
		    } catch (IllegalArgumentException e) { }
	  }

	@Test
	  public void testHashCode() {
	    assertEquals
	      (-875826552,
	       new VideoObj("None", 2009, "Zebra").hashCode());
	    assertEquals
	      (-1391078111,
	       new VideoObj("Blah", 1954, "Cante").hashCode());
	  }

	  public void testEquals() { 
		  String title="X";
		  int year= 2000;
		  String director ="anmol";
		  VideoObj v = new VideoObj(title,year,director);
		  
		  assertTrue(v.equals(v));
		  assertTrue(v.equals(new VideoObj(title,year,director)));
		  assertTrue(v.equals(new VideoObj(title,year,director)));
		  
		  
		  assertTrue(v.equals(new Object()));
		  assertTrue(v.equals(null));
	    
	    
	  }

	  @Test
	  public void testCompareTo() { 
		  String t1 = "X", t2="Y";
		    int y1=2000, y2=2002;
		    String d1="anmol", d2="khantil";
		    
		    VideoObj v1=new VideoObj(t1,y1,d1);
		    
		    VideoObj v2=new VideoObj(t2,y1,d1);
		    
		    assertTrue(v1.compareTo(v2)<0);
		    assertTrue(v1.compareTo(v2)== -v2.compareTo(v1));
		    assertTrue(v1.compareTo(v1)==0);
		    
		    v2=new VideoObj(t1,y1,d2);
		    assertTrue(v1.compareTo(v2)<0);
		    assertTrue(v1.compareTo(v2)== -v2.compareTo(v1));
		    
		    v2=new VideoObj(t1,y2,d1);
		    assertTrue(v1.compareTo(v2)<0);
		    assertTrue(v1.compareTo(v2)== -v2.compareTo(v1));
		    
		    v2=new VideoObj(t2,y2,d2);
		    assertTrue(v1.compareTo(v2)<0);
		    assertTrue(v1.compareTo(v2)== -v2.compareTo(v1));
		    
		    try {
		    	v1.compareTo(null);
		    	fail();
		    } catch(NullPointerException e) {}
		    catch(ClassCastException e) {}
	  }

	  @Test
	  public void testToString() { 
	    String str=new VideoObj("X",2000,"Y").toString();
	    assertEquals(str, "X (2000) : Y");
	    str = new VideoObj("X",2000,"Y").toString();
	    assertEquals(str, "X (2000) : Y");
	  }
}
