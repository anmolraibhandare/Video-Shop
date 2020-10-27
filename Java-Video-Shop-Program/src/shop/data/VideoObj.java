package shop.data;

/**
 * Implementation of Video interface.
 * @see Data
 */
public class VideoObj implements Video {
  private final String _title;
  private final int    _year;
  private final String _director;

  /**
   * Initialize all object attributes.
   * Title and director are "trimmed" to remove leading and final space.
   * @throws IllegalArgumentException if object invariant violated.
   */
  VideoObj(String title, int year, String director) {
	if((title == null) ||(title == "")|| (title == " ") ||(director == "")||(director == null) || (director == " ") || (year >= 5000) || (year <= 1800))
		throw new IllegalArgumentException();
	
	_title = title.trim();
    _director = director.trim();
    _year = year;
  }

  public String director() {
    // TODO
	  return _director;
  }

  public String title() {
    // TODO
	  return _title;
  }

  public int year() {
    // TODO
	  return _year;
  }

  public boolean equals(Object thatObject) {
    // TODO
	  if(thatObject instanceof VideoObj) {
		  VideoObj v = (VideoObj) thatObject;
		  
		  return (this._director.equals(v.director())
				  && this._title.equals(v.title())
				   && this._year == v.year());
	  }
	  
	  return false;
  }

  public int hashCode() {
    // TODO
	  int result = 17;
	  result = 37*result + _title.hashCode();
	  result = 37*result + _year;
	  result = 37*result + _director.hashCode();
	  return result;
  }

  public int compareTo(Video that) {
    // TODO
	    int titlec=_title.compareTo(that.title());
	    if(titlec!=0) {return titlec;}
	    
	    int yearc=Integer.compare(_year,that.year());
	    if(yearc!=0) {return yearc;}
	    
	    int directorc=_director.compareTo(that.director());
	    if(directorc!=0) {return directorc;}
		
	    return 0;
  }

  public String toString() {
    // TODO
	    StringBuilder buffer=new StringBuilder();
	    buffer.append(_title + " (" + _year + ") : " + _director);
	    return buffer.toString();
  }
}
