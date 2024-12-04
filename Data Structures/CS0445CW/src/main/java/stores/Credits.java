package stores;

import interfaces.ICredits;
import structures.ArrayList;
import structures.Arrays;

public class Credits implements ICredits{
    Stores stores;

    /**
     * The constructor for the Credits data store. This is where you should
     * initialise your data structures.
     * 
     * @param stores An object storing all the different key stores, 
     *               including itself
     */
    ArrayList<CastCredit[]> cast;
    ArrayList<CrewCredit[]> crew;
    ArrayList<Integer> id;

    public Credits (Stores stores) {
        this.stores = stores;
        // TODO Add initialisation of data structure here
        cast = new ArrayList<CastCredit[]>();
        crew = new ArrayList<CrewCredit[]>();
        id = new ArrayList<Integer>();
    }

    /**
     * Adds data about the people who worked on a given film. The movie ID should be
     * unique
     * 
     * @param cast An array of all cast members that starred in the given film
     * @param crew An array of all crew members that worked on a given film
     * @param id   The (unique) movie ID
     * @return TRUE if the data able to be added, FALSE otherwise
     */
    @Override
    public boolean add(CastCredit[] cast, CrewCredit[] crew, int id) {
        // TODO Implement this function
    	for(int i = 0; i < this.id.size(); i++) {
    		if(this.id.get(i)==id) {
    			return false;
    		}
    	}
    	this.id.add(id);
    	this.cast.add(cast);
    	this.crew.add(crew);
        return true;
    }

    /**
     * Remove a given films data from the data structure
     * 
     * @param id The movie ID
     * @return TRUE if the data was removed, FALSE otherwise
     */
    @Override
    public boolean remove(int id) {
        // TODO Implement this function
    	for(int i = 0; i < this.id.size(); i++) {
    		if(this.id.get(i)==id) {
    	    	this.id.remove(i);
    	    	this.cast.remove(i);
    	    	this.crew.remove(i);
    			return true;
    		}
    	}
        return false;
    }

    /**
     * Gets all the cast members for a given film
     * 
     * @param filmID The movie ID
     * @return An array of CastCredit objects, one for each member of cast that is 
     *         in the given film. The cast members should be in "order" order. If
     *         there is no cast members attached to a film, or the film canot be 
     *         found, then return an empty array
     */
    @Override
    public CastCredit[] getFilmCast(int filmID) {
        // TODO Implement this function
    	CastCredit[] cast = new CastCredit[1000];
    	for(int n = 0; n < this.id.size(); n++) {
    		if(this.id.get(n)==filmID) {
    			cast = this.cast.get(n);
    			break;
    		}
    	}
	    int len = 0;
	    while(len < cast.length && cast[len] != null ) {
	    	len++;
	    }
	    cast = Arrays.copyOf(cast,len);
    	int j=cast.length;
    	//按order排序
	    for(int k=cast.length-1;k>0;k--) {
	    	for(int i=0;i<j-1;i++) {
	    		if(cast[i].getOrder()>cast[i+1].getOrder()) {
	    			CastCredit tmp=cast[i+1];
	    			cast[i+1]=cast[i];
	    			cast[i]=tmp;
	    		}
	    	}
	    	j--;
	    }
        return cast;
    }

    /**
     * Gets all the crew members for a given film
     * 
     * @param filmID The movie ID
     * @return An array of CrewCredit objects, one for each member of crew that is
     *         in the given film. The crew members should be in ID order. If there 
     *         is no crew members attached to a film, or the film canot be found, 
     *         then return an empty array
     */
    @Override
    public CrewCredit[] getFilmCrew(int filmID) {
        // TODO Implement this function
    	CrewCredit[] crew = new CrewCredit[1000];
    	for(int n = 0; n < this.id.size(); n++) {
    		if(this.id.get(n)==filmID) {
    			crew = this.crew.get(n);
    			break;
    		}
    	}
    	int len = 0;
		while(len < crew.length && crew[len] != null) {
			len++;
		}
		crew = Arrays.copyOf(crew,len);
    	int j=crew.length;
    	//按id排序
	    for(int k=crew.length-1;k>0;k--) {
	    	for(int i=0;i<j-1;i++) {
	    		if(crew[i].getID()>crew[i+1].getID()) {
	    			CrewCredit tmp=crew[i+1];
	    			crew[i+1]=crew[i];
	    			crew[i]=tmp;
	    		}
	    	}
	    	j--;
	    }
        return crew;
    }

    /**
     * Gets the number of cast that worked on a given film
     * 
     * @param filmID The movie ID
     * @return The number of cast member that worked on a given film. If the film
     *         cannot be found, then return -1
     */
    @Override
    public int sizeOfCast(int filmID) {
        // TODO Implement this function
    	for(int i = 0; i < this.id.size(); i++) {
    		if(this.id.get(i)==filmID) {
    			return this.cast.get(i).length;
    		}
    	}
        return -1;
    }

    /**
     * Gets the number of crew that worked on a given film
     * 
     * @param filmID The movie ID
     * @return The number of crew member that worked on a given film. If the film
     *         cannot be found, then return -1
     */
    @Override
    public int sizeofCrew(int filmID) {
        // TODO Implement this function
    	for(int i = 0; i < this.id.size(); i++) {
    		if(this.id.get(i)==filmID) {
    			return this.crew.get(i).length;
    		}
    	}
        return -1;
    }

    /**
     * Gets the number of films stored in this data structure
     * 
     * @return The number of films in the data structure
     */
    @Override
    public int size() {
        // TODO Implement this function
        return this.id.size();
    }

    /**
     * Gets a list of all unique cast members present in the data structure
     * 
     * @return An array of all unique cast members as Person objects. If there are 
     *         no cast members, then return an empty array
     */
    @Override
    public Person[] getUniqueCast() {
        // TODO Implement this function
    	Person[] cast = new Person[1000000];
    	for(int i=0;i<this.cast.size();i++) {
    		for(int j=0;j<this.cast.get(i).length;j++) {
    			Person p = new Person(this.cast.get(i)[j].getID(),this.cast.get(i)[j].getName(),this.cast.get(i)[j].getProfilePath());
    			int k=0;
    			while(cast[k] != null) {
    				if(cast[k].getID()==p.getID() && cast[k].getName()==p.getName() && cast[k].getProfilePath()==p.getProfilePath()) {
    					break;
    				}
    				k++;
    			}
    			if(cast[k] == null) {
    				    cast[k] = p;
    			}
    		}
    	}
    	int len = 0;
    	while(cast[len] != null) {
            len++;
        }
    	cast = Arrays.copyOf(cast, len);
        return cast;
    }

    /**
     * Gets a list of all unique crew members present in the data structure
     * 
     * @return An array of all unique crew members as Person objects. If there are
     *         no crew members, then return an empty array
     */
    @Override
    public Person[] getUniqueCrew() {
        // TODO Implement this function
    	Person[] crew = new Person[1000000];
    	for(int i=0;i<this.crew.size();i++) {
    		for(int j=0;j<this.crew.get(i).length;j++) {
    			Person p = new Person(this.crew.get(i)[j].getID(),this.crew.get(i)[j].getName(),this.crew.get(i)[j].getProfilePath());
    			int k=0;
    			while(crew[k] != null) {
    				if(crew[k].getID()==p.getID() && crew[k].getName()==p.getName() && crew[k].getProfilePath()==p.getProfilePath()) {
    					break;
    				}
    				k++;
    			}
    			if(crew[k] == null) {
    				    crew[k] = p;
    			}
    		}
    	}
    	int len = 0;
    	while(crew[len] != null) {
            len++;
        }
    	crew = Arrays.copyOf(crew, len);
    	return crew;
    }

    /**
     * Get all the cast members that have the given string within their name
     * 
     * @param cast The string that needs to be found
     * @return An array of unique Person objects of all cast members that have the 
     *         requested string in their name
     */
    @Override
    public Person[] findCast(String cast) {
        // TODO Implement this function
    	Person[] p=this.getUniqueCast();
    	if(p == null) {
    		return null;
    	}
    	Person[] findcast = new Person[p.length];
    	int index = 0;
    	for(int i=0;i<p.length;i++) {
    		if(p[i].getName().contains(cast)) {
                findcast[index] = p[i];
                index++;
            }
    	}
    	findcast = Arrays.copyOf(findcast,index);
        return findcast;
    }

    /**
     * Get all the crew members that have the given string within their name
     * 
     * @param crew The string that needs to be found
     * @return An array of unique Person objects of all crew members that have the 
     *         requested string in their name
     */
    @Override
    public Person[] findCrew(String crew) {
        // TODO Implement this function
    	Person[] p=this.getUniqueCrew();
    	if(p==null) {
    		return null;
    	}
    	Person[] findcrew = new Person[p.length];
    	int index = 0;
    	for(int i=0;i<p.length;i++) {
    		if(p[i].getName().contains(crew)) {
                findcrew[index] = p[i];
                index++;
            }
    	}
    	findcrew = Arrays.copyOf(findcrew,index);
        return findcrew;
    }

    /**
     * Gets the Person object corresponding to the cast ID
     * 
     * @param castID The cast ID of the person to be found
     * @return The Person object corresponding to the cast ID provided. 
     *         If a person cannot be found, then return null
     */
    @Override
    public Person getCast(int castID) {
        // TODO Implement this function
    	Person[] p=this.getUniqueCast();
    	if(p==null) {
            return null;
        }
        for(int i =0; i<p.length;i++) {
        	if(p[i].getID()==castID) {
        		return p[i];
        	}
        }
        return null;
    }

    /**
     * Gets the Person object corresponding to the crew ID
     * 
     * @param crewID The crew ID of the person to be found
     * @return The Person object corresponding to the crew ID provided. 
     *         If a person cannot be found, then return null
     */
    @Override
    public Person getCrew(int crewID){
        // TODO Implement this function
    	Person[] p=this.getUniqueCrew();
    	if(p==null) {
            return null;
        }
        for(int i =0; i<p.length;i++) {
        	if(p[i].getID()==crewID) {
        		return p[i];
        	}
        }
        return null;
    }

    
    /**
     * Get an array of film IDs where the cast member has starred in
     * 
     * @param castID The cast ID of the person
     * @return An array of all the films the member of cast has starred
     *         in. If there are no films attached to the cast member, 
     *         then return an empty array
     */
    @Override
    public int[] getCastFilms(int castID){
        // TODO Implement this function
    	int[] films = new int[this.id.size()];
    	int index = 0;
    	for(int i =0; i<this.cast.size();i++) {
    		for(int j =0; j<this.cast.get(i).length;j++) {
    		if(this.cast.get(i)[j].getID()==castID) {
    			films[index] = this.id.get(i);
    			index++;
    			break;
    			}
    		}
    	}
    	films = Arrays.copyOf(films,index);
        return films;
    }

    /**
     * Get an array of film IDs where the crew member has starred in
     * 
     * @param crewID The crew ID of the person
     * @return An array of all the films the member of crew has starred
     *         in. If there are no films attached to the crew member, 
     *         then return an empty array
     */
    @Override
    public int[] getCrewFilms(int crewID) {
        // TODO Implement this function
    	int[] films = new int[this.id.size()];
    	int index = 0;
    	for(int i =0; i<this.crew.size();i++) {
    		for(int j =0; j<this.crew.get(i).length;j++) {
    		if(this.crew.get(i)[j].getID()==crewID) {
    			films[index] = this.id.get(i);
    			index++;
    			break;
    			}
    		}
    	}
    	films = Arrays.copyOf(films,index);
        return films;
    }

    /**
     * Get the films that this cast member stars in (in the top 3 cast
     * members/top 3 billing). This is determined by the order field in
     * the CastCredit class
     * 
     * @param castID The cast ID of the cast member to be searched for
     * @return An array of film IDs where the the cast member stars in.
     *         If there are no films where the cast member has starred in,
     *         or the cast member does not exist, return an empty array
     */
    @Override
    public int[] getCastStarsInFilms(int castID){
        // TODO Implement this function
    	int[] films = new int[this.id.size()];
    	int index = 0;
    	for(int i =0; i<this.cast.size();i++) {
    		for(int j =0; j<this.cast.get(i).length;j++) {
    		if(this.cast.get(i)[j].getID()==castID && this.cast.get(i)[j].getOrder()<=3) {
    			films[index] = this.id.get(i);
    			index++;
    			break;
    			}
    		}
    	}
    	films = Arrays.copyOf(films,index);
        return films;
    }
    
    /**
     * Get Person objects for cast members who have appeared in the most
     * films. If the cast member has multiple roles within the film, then
     * they would get a credit per role played. For example, if a cast
     * member performed as 2 roles in the same film, then this would count
     * as 2 credits. The list should be ordered by the highest number of credits.
     * 
     * @param numResults The maximum number of elements that should be returned
     * @return An array of Person objects corresponding to the cast members
     *         with the most credits, ordered by the highest number of credits.
     *         If there are less cast members that the number required, then the
     *         list should be the same number of cast members found.
     */
    @Override
    public Person[] getMostCastCredits(int numResults) {
        // TODO Implement this function
    	Person[] cast = new Person[1000];
    	int[] number = new int[1000];
    	for(int i=0;i<this.cast.size();i++) {
    		for(int j=0;j<this.cast.get(i).length;j++) {
    			Person p = new Person(this.cast.get(i)[j].getID(),this.cast.get(i)[j].getName(),this.cast.get(i)[j].getProfilePath());
    			int k=0;
    			while(cast[k] != null) {
    				if(cast[k].getID() == p.getID() && cast[k].getName() == p.getName() && cast[k].getProfilePath() == p.getProfilePath()) {
    					number[k]++;
    				}
    				k++;
    			}
    			if(cast[k] == null) {
    				    cast[k] = p;
    				    number[k] = 1;
    			}
    		}
    	}
    	int len = 0;
    	while(len < number.length && number[len] >=1) {
    		len++;
    	}
    	cast = Arrays.copyOf(cast, len);
    	number = Arrays.copyOf(number, len);
    	cast = Arrays.rank(cast, number);
    	if(len-numResults<=0) {
    		return cast;
    	}
    	else
    		return Arrays.copyOf(cast, numResults);
    }

    /**
     * Get the number of credits for a given cast member. If the cast member has
     * multiple roles within the film, then they would get a credit per role
     * played. For example, if a cast member performed as 2 roles in the same film,
     * then this would count as 2 credits.
     * 
     * @param castID A cast ID representing the cast member to be found
     * @return The number of credits the given cast member has. If the cast member
     *         cannot be found, return -1
     */
    @Override
    public int getNumCastCredits(int castID) {
        // TODO Implement this function
    	int num=-1;
    	for(int i=0;i<this.cast.size();i++) {
    		for(int j=0;j<this.cast.get(i).length;j++) {
    			if(this.cast.get(i)[j].getID()==castID) {
    				if(num==-1) {
    					num=1;
    				}
    				else
    					num++;
    			}
    		}
    	}
        return num;
    }

}
