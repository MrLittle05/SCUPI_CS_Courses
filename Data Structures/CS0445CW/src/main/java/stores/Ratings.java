package stores;

import java.time.LocalDateTime;
import interfaces.IRatings;
import structures.ArrayList;
import structures.Arrays;

public class Ratings implements IRatings {
    Stores stores;

    /**
     * The constructor for the Ratings data store. This is where you should
     * initialise your data structures.
     * @param stores An object storing all the different key stores,
     *               including itself
     */
    ArrayList<Integer> userid;
    ArrayList<Integer> movieid;
    ArrayList<Float> rating;
    ArrayList<LocalDateTime> time;

    public Ratings(Stores stores) {
        this.stores = stores;
        // TODO Add initialisation of data structure here
        userid = new ArrayList<Integer>();
        movieid = new ArrayList<Integer>();
        rating = new ArrayList<Float>();
        time = new ArrayList<LocalDateTime>();
    }

    /**
     * Adds a rating to the data structure. The rating is made unique by its user ID
     * and its movie ID
     * 
     * @param userID    The user ID
     * @param movieID   The movie ID
     * @param rating    The rating gave to the film by this user (between 0 and 5
     *                  inclusive)
     * @param timestamp The time at which the rating was made
     * @return TRUE if the data able to be added, FALSE otherwise
     */
    @Override
    public boolean add(int userid, int movieid, float rating, LocalDateTime timestamp) {
        // TODO Implement this function
    	 for(int i =0; i<this.userid.size(); i++) {
    		 if(this.userid.get(i) == userid && this.movieid.get(i) == movieid) {
                 return false;
             }
    	 }
    	 this.userid.add(userid);
    	 this.movieid.add(movieid);
    	 this.rating.add(rating);
    	 this.time.add(timestamp);
    	 return true;
    }

    /**
     * Removes a given rating, using the user ID and the movie ID as the unique
     * identifier
     * 
     * @param userID  The user ID
     * @param movieID The movie ID
     * @return TRUE if the data was removed successfully, FALSE otherwise
     */
    @Override
    public boolean remove(int userid, int movieid) {
        // TODO Implement this function
    	
    	for(int i =0; i<this.userid.size(); i++) {
   		 if(this.userid.get(i) == userid && this.movieid.get(i) == movieid) {
   			this.userid.remove(i);
   			this.movieid.remove(i);
   			this.rating.remove(i);
   			this.time.remove(i);
   			return true;
            }
   	 }
        return false;
    }

    /**
     * Sets a rating for a given user ID and movie ID. Therefore, should the given
     * user have already rated the given movie, the new data should overwrite the
     * existing rating. However, if the given user has not already rated the given
     * movie, then this rating should be added to the data structure
     * 
     * @param userID    The user ID
     * @param movieID   The movie ID
     * @param rating    The new rating to be given to the film by this user (between
     *                  0 and 5 inclusive)
     * @param timestamp The time at which the rating was made
     * @return TRUE if the data able to be added/updated, FALSE otherwise
     */
    @Override
    public boolean set(int userid, int movieid, float rating, LocalDateTime timestamp) {
    	for(int i =0; i<this.userid.size(); i++) {
      		 if(this.userid.get(i) == userid && this.movieid.get(i) == movieid) {
      			   this.rating.set(i, rating);
                   this.time.set(i, timestamp);
                   return true;
               }
      		 }
    	
    	this.add(userid, movieid, rating, timestamp);
        return true;
    }

    /**
     * Get all the ratings for a given film
     * 
     * @param movieID The movie ID
     * @return An array of ratings. If there are no ratings or the film cannot be
     *         found, then return an empty array
     */
    @Override
    public float[] getMovieRatings(int movieid) { 
    	int size=0,index=0;
    	for(int i =0; i<this.movieid.size(); i++) {
    		if(movieid==this.movieid.get(i)) {
    			size++;
    		}
    	}
    	float[] movieratings = new float[size];
    	for(int i =0; i<this.movieid.size(); i++) {
    		if(movieid==this.movieid.get(i)) {
    			movieratings[index]=this.rating.get(i);
    			index++;
            }
    	}
        return movieratings;
    }

    /**
     * Get all the ratings for a given user
     * 
     * @param userID The user ID
     * @return An array of ratings. If there are no ratings or the user cannot be
     *         found, then return an empty array
     */
    @Override
    public float[] getUserRatings(int userid) {
    	int size=0,index=0;
    	for(int i =0; i<this.userid.size(); i++) {
    		if(userid==this.userid.get(i)) {
    			size++;
    		}
    	}
    	float[] userratings = new float[size];
    	for(int i =0; i<this.userid.size(); i++) {
    		if(userid==this.userid.get(i)) {
    			userratings[index]=this.rating.get(i);
    			index++;
            }
    	}
        return userratings;
    }

    /**
     * Get the average rating for a given film
     * 
     * @param movieID The movie ID
     * @return Produces the average rating for a given film. 
     *         If the film cannot be found in ratings, but does exist in the movies store, return 0.0f. 
     *         If the film cannot be found in ratings or movies stores, return -1.0f.
     */
    @Override
    public float getMovieAverageRating(int movieid) {
    	float[] ratings = this.getMovieRatings(movieid);
    	int length = ratings.length;
    	if(length==0) {
    		return -1;
    	}
    	float sum = 0;
    	for(int i=0; i<length; i++) {
    		sum+=ratings[i];
    	}
    	float average = sum/length;
        return average;
    }

    /**
     * Get the average rating for a given user
     * 
     * @param userID The user ID
     * @return Produces the average rating for a given user. If the user cannot be
     *         found, or there are no rating, return -1
     */
    @Override
    public float getUserAverageRating(int userid) {
    	float[] ratings = this.getUserRatings(userid);
    	int length = ratings.length;
    	if(length==0) {
    		return -1;
    	}
    	float sum = 0;
    	for(int i=0; i<length; i++) {
    		sum+=ratings[i];
    	}
    	float average = sum/length;
        return average;
    }

    /**
     * Gets the top N movies with the most ratings, in order from most to least
     * 
     * @param num The number of movies that should be returned
     * @return A sorted array of movie IDs with the most ratings. The array should be
     *         no larger than num. If there are less than num movies in the store,
     *         then the array should be the same length as the number of movies
     */
    @Override
    public int[] getMostRatedMovies(int num) {
    	int[] id = new int[this.movieid.size()];
    	int [] number = new int[this.movieid.size()];
		for(int i=0; i<this.movieid.size(); i++) {
			int j=0;
			while(id[j]>0) {
				if(id[j]==this.movieid.get(i)) {
					number[j]++;
					break;
				}
				j++;
			}
			if(id[j]<=0) {
                number[j]=1;
                id[j]=this.movieid.get(i);
            }
		}
		int len = 0;
		while(id[len]>0) {
			len++;
		}
		id = Arrays.copyOf(id, len);
		number = Arrays.copyOf(number, len);
		id = Arrays.rank(id, number);
    	if(len-num<=0) {
    		return id;
    	}
    	else
    		return Arrays.copyOf(id, num);
    }
    
    /**
     * Gets the top N users with the most ratings, in order from most to least
     * 
     * @param num The number of users that should be returned
     * @return A sorted array of user IDs with the most ratings. The array should be
     *         no larger than num. If there are less than num users in the store,
     *         then the array should be the same length as the number of users
     */
    @Override
    public int[] getMostRatedUsers(int num) {
    	int[] id = new int[this.userid.size()];
    	int [] number = new int[this.userid.size()];
		for(int i=0; i<this.userid.size(); i++) {
			int j=0;
			while(id[j]>0) {
				if(id[j]==this.userid.get(i)) {
					number[j]++;
					break;
				}
				j++;
			}
			if(id[j]<=0) {
                number[j]=1;
                id[j]=this.userid.get(i);
            }
		}
		int len = 0;
		while(id[len]>0) {
			len++;
		}
		id = Arrays.copyOf(id, len);
		number = Arrays.copyOf(number, len);
		id = Arrays.rank(id, number);
    	if(len-num<=0) {
    		return id;
    	}
    	else
    		return Arrays.copyOf(id, num);
    }

    /**
     * Gets the number of ratings in the data structure
     * 
     * @return The number of ratings in the data structure
     */
    @Override
    public int size() {
    	return this.userid.size();
    }

    /**
     * Get the number of ratings that a movie has
     * 
     * @param movieid The movie id to be found
     * @return The number of ratings the specified movie has. 
     *         If the movie exists in the movies store, but there
     *         are no ratings for it, then return 0. If the movie
     *         does not exist in the ratings or movies store, then
     *         return -1
     */
    @Override
    public int getNumRatings(int movieid) {
    	int number=0;
    	for(int i =0; i < this.movieid.size(); i++) {
    		if(this.movieid.get(i)==movieid) {
    			number++;
    		}
    	}
        return number;
    }

    /**
     * Get the highest average rated film IDs, in order of there average rating
     * (hightst first).
     * 
     * @param numResults The maximum number of results to be returned
     * @return An array of the film IDs with the highest average ratings, highest
     *         first. If there are less than num movies in the store,
     *         then the array should be the same length as the number of movies
     */
    @Override
    public int[] getTopAverageRatedMovies(int numResults) {
    	int[] id = new int[this.movieid.size()];
    	float[] number = new float[this.movieid.size()];
    	int[] n = new int[this.movieid.size()];
		for(int i=0; i<this.movieid.size(); i++) {
			int j=0;
			while(id[j]>0) {
				if(id[j]==this.movieid.get(i)) {
					float sum = number[j]*n[j];
					n[j]++;
					number[j]=(this.rating.get(i) + sum)/n[j];
					break;
				}
				j++;
			}
			if(id[j]<=0) {
                number[j]=this.rating.get(i);
                id[j]=this.movieid.get(i);
                n[j]=1;
            }
		}
		int len = 0;
		while(id[len]>0) {
			len++;
		}
		id = Arrays.copyOf(id, len);
		number = Arrays.copyOf(number, len);
        id = Arrays.rank(id, number);
    	if(len-numResults<=0) {
    		return id;
    	}
    	else
    		return Arrays.copyOf(id, numResults);
    }
}
