package stores;

import java.time.LocalDate;
import interfaces.IMovies;
import structures.ArrayList;
import structures.Arrays;

public class Movies implements IMovies{
    Stores stores;

    /**
     * The constructor for the Movies data store. This is where you should
     * initialise your data structures.
     * @param stores An object storing all the different key stores,
     *               including itself
     */
    ArrayList<Integer> id;
    ArrayList<String> title;
    ArrayList<String> originalTitle;
    ArrayList<String> overview;
    ArrayList<String> tagline;
    ArrayList<String> status;
    ArrayList<Genre[]> genres;
    ArrayList<LocalDate> release;
    ArrayList<Long> budget;
    ArrayList<Long> revenue;
    ArrayList<String[]> languages;
    ArrayList<String> originalLanguage;
    ArrayList<Double> runtime;
    ArrayList<String> homepage;
    ArrayList<Boolean> adult;
    ArrayList<Boolean> video;
    ArrayList<String> poster;
    
    public Movies(Stores stores) {
        this.stores = stores;
        // TODO Add initialisation of data structure here
        id = new ArrayList<Integer>();
        title = new ArrayList<String>();
        originalTitle = new ArrayList<String>();
        overview = new ArrayList<String>();
        tagline = new ArrayList<String>();
        status = new ArrayList<String>();
        genres = new ArrayList<Genre[]>();
        release = new ArrayList<LocalDate>();
        budget = new ArrayList<Long>();
        revenue = new ArrayList<Long>();
        languages = new ArrayList<String[]>();
        originalLanguage = new ArrayList<String>();
        runtime = new ArrayList<Double>();
        homepage = new ArrayList<String>();
        adult = new ArrayList<Boolean>();
        video = new ArrayList<Boolean>();
        poster = new ArrayList<String>();
    }

    /**
     * Adds data about a film to the data structure
     * 
     * @param id               The unique ID for the film
     * @param title            The English title of the film
     * @param originalTitle    The original language title of the film
     * @param overview         An overview of the film
     * @param tagline          The tagline for the film (empty string if there is no
     *                         tagline)
     * @param status           Current status of the film
     * @param genres           An array of Genre objects related to the film
     * @param release          The release date for the film
     * @param budget           The budget of the film in US Dollars
     * @param revenue          The revenue of the film in US Dollars
     * @param languages        An array of ISO 639 language codes for the film
     * @param originalLanguage An ISO 639 language code for the original language of
     *                         the film
     * @param runtime          The runtime of the film in minutes
     * @param homepage         The URL to the homepage of the film
     * @param adult            Whether the film is an adult film
     * @param video            Whether the film is a "direct-to-video" film
     * @param poster           The unique part of the URL of the poster (empty if
     *                         the URL is not known)
     * @return TRUE if the data able to be added, FALSE otherwise
     */
    @Override
    public boolean add(int id, String title, String originalTitle, String overview, String tagline, String status, Genre[] genres, LocalDate release, long budget, long revenue, String[] languages, String originalLanguage, double runtime, String homepage, boolean adult, boolean video, String poster) {
        // TODO Implement this function
    	for(int i = 0; i < this.id.size(); i++) {
    		if(this.id.get(i) == id) {
                return false;
            }
    	}
    	this.id.add(id);
    	this.title.add(title);
    	this.originalTitle.add(originalTitle);
    	this.overview.add(overview);
    	this.tagline.add(tagline);
    	this.status.add(status);
    	this.genres.add(genres);
    	this.release.add(release);
    	this.budget.add(budget);
    	this.revenue.add(revenue);
    	this.languages.add(languages);
    	this.originalLanguage.add(originalLanguage);
    	this.runtime.add(runtime);
    	this.homepage.add(homepage);
    	this.adult.add(adult);
    	this.video.add(video);
    	this.poster.add(poster);
        return true;
    }

    /**
     * Removes a film from the data structure, and any data
     * added through this class related to the film
     * 
     * @param id The film ID
     * @return TRUE if the film has been removed successfully, FALSE otherwise
     */
    @Override
    public boolean remove(int id) {
        // TODO Implement this function
    	for(int i = 0; i < this.id.size(); i++) {
    		if(this.id.get(i) == id) {
    			this.id.remove(i);
    			this.title.remove(i);
    			this.originalTitle.remove(i);
    			this.overview.remove(i);
    			this.tagline.remove(i);
    			this.status.remove(i);
    			this.genres.remove(i);
    			this.release.remove(i);
    			this.budget.remove(i);
    			this.revenue.remove(i);
    			this.languages.remove(i);
    			this.originalLanguage.remove(i);
    			this.runtime.remove(i);
    			this.homepage.remove(i);
    			this.adult.remove(i);
    			this.video.remove(i);
    			this.poster.remove(i);
                return true;
            }
    	}
        return false;
    }

    /**
     * Gets all the IDs for all films
     * 
     * @return An array of all film IDs stored
     */
    @Override
    public int[] getAllIDs() {
        // TODO Implement this function
    	int[] films = new int[this.id.size()];
    	for(int i = 0; i < this.id.size(); i++) {
            films[i] = this.id.get(i);
        }
        return films;
    }

    /**
     * Finds the film IDs of all films released within a given range. If a film is
     * released either on the start or end dates, then that film should not be
     * included
     * 
     * @param start The start point of the range of dates
     * @param end   The end point of the range of dates
     * @return An array of film IDs that were released between start and end
     */
    @Override
    public int[] getAllIDsReleasedInRange(LocalDate start, LocalDate end) {
        // TODO Implement this function
    	int[] films = new int[1010];
    	int index =0;
    	for(int i = 0; i < this.id.size(); i++) {
    		if((this.release.get(i).isAfter(start) && this.release.get(i).isBefore(end))||this.release.get(i)==start||this.release.get(i)==end) {
            films[index] = this.id.get(i);
            index++;
            }
        }
    	films = Arrays.copyOf(films, index);
        return films;
    }

    /**
     * Gets the title of a particular film, given the ID number of that film
     * 
     * @param id The movie ID
     * @return The title of the requested film. If the film cannot be found, then
     *         return null
     */
    @Override
    public String getTitle(int id) {
        // TODO Implement this function
    	for(int i = 0; i < this.id.size(); i++) {
            if(this.id.get(i) == id) {
                return this.title.get(i);
            }
        }
        return null;
    }

    /**
     * Gets the original title of a particular film, given the ID number of that
     * film
     * 
     * @param id The movie ID
     * @return The original title of the requested film. If the film cannot be
     *         found, then return null
     */
    @Override
    public String getOriginalTitle(int id) {
        // TODO Implement this function
    	for(int i = 0; i < this.id.size(); i++) {
            if(this.id.get(i) == id) {
                return this.originalTitle.get(i);
            }
        }
        return null;
    }

    /**
     * Gets the overview of a particular film, given the ID number of that film
     * 
     * @param id The movie ID
     * @return The overview of the requested film. If the film cannot be found, then
     *         return null
     */
    @Override
    public String getOverview(int id) {
        // TODO Implement this function
    	for(int i = 0; i < this.id.size(); i++) {
            if(this.id.get(i) == id) {
                return this.overview.get(i);
            }
        }
        return null;
    }

    /**
     * Gets the tagline of a particular film, given the ID number of that film
     * 
     * @param id The movie ID
     * @return The tagline of the requested film. If the film cannot be found, then
     *         return null
     */
    @Override
    public String getTagline(int id) {
        // TODO Implement this function
    	for(int i = 0; i < this.id.size(); i++) {
            if(this.id.get(i) == id) {
                return this.tagline.get(i);
            }
        }
        return null;
    }

    /**
     * Gets the status of a particular film, given the ID number of that film
     * 
     * @param id The movie ID
     * @return The status of the requested film. If the film cannot be found, then
     *         return null
     */
    @Override
    public String getStatus(int id) {
        // TODO Implement this function
    	for(int i = 0; i < this.id.size(); i++) {
            if(this.id.get(i) == id) {
                return this.status.get(i);
            }
        }
        return null;
    }

    /**
     * Gets the genres of a particular film, given the ID number of that film
     * 
     * @param id The movie ID
     * @return The genres of the requested film. If the film cannot be found, then
     *         return null
     */
    @Override
    public Genre[] getGenres(int id) {
        // TODO Implement this function
    	for(int i = 0; i < this.id.size(); i++) {
            if(this.id.get(i) == id) {
                return this.genres.get(i);
            }
        }
        return null;
    }

    /**
     * Gets the release date of a particular film, given the ID number of that film
     * 
     * @param id The movie ID
     * @return The release date of the requested film. If the film cannot be found,
     *         then return null
     */
    @Override
    public LocalDate getRelease(int id) {
        // TODO Implement this function
    	for(int i = 0; i < this.id.size(); i++) {
            if(this.id.get(i) == id) {
                return this.release.get(i);
            }
        }
        return null;
    }

    /**
     * Gets the budget of a particular film, given the ID number of that film
     * 
     * @param id The movie ID
     * @return The budget of the requested film. If the film cannot be found, then
     *         return -1
     */
    @Override
    public long getBudget(int id) {
        // TODO Implement this function
    	for(int i = 0; i < this.id.size(); i++) {
            if(this.id.get(i) == id) {
                return this.budget.get(i);
            }
        }
        return -1;
    }

    /**
     * Gets the revenue of a particular film, given the ID number of that film
     * 
     * @param id The movie ID
     * @return The revenue of the requested film. If the film cannot be found, then
     *         return -1
     */
    @Override
    public long getRevenue(int id) {
        // TODO Implement this function
    	for(int i = 0; i < this.id.size(); i++) {
            if(this.id.get(i) == id) {
                return this.revenue.get(i);
            }
        }
        return -1;
    }

    /**
     * Gets the languages of a particular film, given the ID number of that film
     * 
     * @param id The movie ID
     * @return The languages of the requested film. If the film cannot be found,
     *         then return null
     */
    @Override
    public String[] getLanguages(int id) {
        // TODO Implement this function
    	for(int i = 0; i < this.id.size(); i++) {
            if(this.id.get(i) == id) {
                return this.languages.get(i);
            }
        }
        return null;
    }

    /**
     * Gets the original language of a particular film, given the ID number of that
     * film
     * 
     * @param id The movie ID
     * @return The original language of the requested film. If the film cannot be
     *         found, then return null
     */
    @Override
    public String getOriginalLanguage(int id) {
        // TODO Implement this function
    	for(int i = 0; i < this.id.size(); i++) {
            if(this.id.get(i) == id) {
                return this.originalLanguage.get(i);
            }
        }
        return null;
    }

    /**
     * Gets the runtime of a particular film, given the ID number of that film
     * 
     * @param id The movie ID
     * @return The runtime of the requested film. If the film cannot be found, then
     *         return -1
     */
    @Override
    public double getRuntime(int id) {
        // TODO Implement this function
    	for(int i = 0; i < this.id.size(); i++) {
            if(this.id.get(i) == id) {
                return this.runtime.get(i);
            }
        }
        return -1;
    }

    /**
     * Gets the homepage of a particular film, given the ID number of that film
     * 
     * @param id The movie ID
     * @return The homepage of the requested film. If the film cannot be found, then
     *         return null
     */
    @Override
    public String getHomepage(int id) {
        // TODO Implement this function
    	for(int i = 0; i < this.id.size(); i++) {
            if(this.id.get(i) == id) {
                return this.homepage.get(i);
            }
        }
        return null;
    }

    /**
     * Gets weather a particular film is classed as "adult", given the ID number of
     * that film
     * 
     * @param id The movie ID
     * @return The "adult" status of the requested film. If the film cannot be
     *         found, then return false
     */
    @Override
    public boolean getAdult(int id) {
        // TODO Implement this function
    	for(int i = 0; i < this.id.size(); i++) {
            if(this.id.get(i) == id) {
                return this.adult.get(i);
            }
        }
        return false;
    }

    /**
     * Gets weather a particular film is classed as "direct-to-video", given the ID
     * number of that film
     * 
     * @param id The movie ID
     * @return The "direct-to-video" status of the requested film. If the film
     *         cannot be found, then return false
     */
    @Override
    public boolean getVideo(int id) {
        // TODO Implement this function
    	for(int i = 0; i < this.id.size(); i++) {
            if(this.id.get(i) == id) {
                return this.video.get(i);
            }
        }
        return false;
    }

    /**
     * Gets the poster URL of a particular film, given the ID number of that film
     * 
     * @param id The movie ID
     * @return The poster URL of the requested film. If the film cannot be found,
     *         then return null
     */
    @Override
    public String getPoster(int id) {
        // TODO Implement this function
    	for(int i = 0; i < this.id.size(); i++) {
            if(this.id.get(i) == id) {
                return this.poster.get(i);
            }
        }
        return null;
    }

    /**
     * Sets the average IMDb score and the number of reviews used to generate this
     * score, for a particular film
     * 
     * @param id          The movie ID
     * @param voteAverage The average score on IMDb for the film
     * @param voteCount   The number of reviews on IMDb that were used to generate
     *                    the average score for the film
     * @return TRUE if the data able to be added, FALSE otherwise
     */
    
	double[] scores = new double[2000];
	int[] votecount = new int[2000];
	@Override
    public boolean setVote(int id, double voteAverage, int voteCount) {
        // TODO Implement this function
    	for(int i = 0; i < this.id.size(); i++) {
    		if(this.id.get(i)==id) {
    			scores[i] = voteAverage;
                votecount[i] = voteCount;
                return true;
    		}
    	}
        return false;
    }

    /**
     * Gets the average score for IMDb reviews of a particular film, given the ID
     * number of that film
     * 
     * @param id The movie ID
     * @return The average score for IMDb reviews of the requested film. If the film
     *         cannot be found, then return -1
     */
    @Override
    public double getVoteAverage(int id) {
        // TODO Implement this function
    	for(int i = 0; i < this.id.size(); i++) {
            if(this.id.get(i) == id) {
                return scores[i];
            }
        }
        return -1;
    }

    /**
     * Gets the amount of IMDb reviews used to generate the average score of a
     * particular film, given the ID number of that film
     * 
     * @param id The movie ID
     * @return The amount of IMDb reviews used to generate the average score of the
     *         requested film. If the film cannot be found, then return -1
     */
    @Override
    public int getVoteCount(int id) {
        // TODO Implement this function
    	for(int i = 0; i < this.id.size(); i++) {
            if(this.id.get(i) == id) {
                return votecount[i];
            }
        }
        return -1;
    }

    /**
     * Adds a given film to a collection. The collection is required to have an ID
     * number, a name, and a URL to a poster for the collection
     * 
     * @param filmID                 The movie ID
     * @param collectionID           The collection ID
     * @param collectionName         The name of the collection
     * @param collectionPosterPath   The URL where the poster can
     *                               be found
     * @param collectionBackdropPath The URL where the backdrop can
     *                               be found
     * @return TRUE if the data able to be added, FALSE otherwise
     */
    ArrayList<Integer> filmID = new ArrayList<>();
    ArrayList<Integer> collectionID = new ArrayList<>();
    ArrayList<String> collectionName = new ArrayList<>();
    ArrayList<String> collectionPosterPath = new ArrayList<>();	
    ArrayList<String> collectionBackdropPath = new ArrayList<>();
    
    @Override
    public boolean addToCollection(int filmID, int collectionID, String collectionName, String collectionPosterPath, String collectionBackdropPath) {
        // TODO Implement this function
    	int n =0;
    	for(int i = 0; i < this.id.size(); i++) {
    		if(this.id.get(i) == filmID) {
    			n = 1;
                break;
            }
    	}
    	if(n==0) {
    		return false;
    	}
    	for(int i = 0; i< this.filmID.size(); i++) {
    		if(this.filmID.get(i) == filmID) {
    				return false;
            }
    	}
    	this.filmID.add(filmID);
		this.collectionID.add(collectionID);
		this.collectionName.add(collectionName);
		this.collectionPosterPath.add(collectionPosterPath);
		this.collectionBackdropPath.add(collectionBackdropPath);
		return true;
    }

    /**
     * Get all films that belong to a given collection
     * 
     * @param collectionID The collection ID to be searched for
     * @return An array of film IDs that correspond to the given collection ID. If
     *         there are no films in the collection ID, or if the collection ID is
     *         not valid, return an empty array.
     */
    @Override
    public int[] getFilmsInCollection(int collectionID) {
        // TODO Implement this function
    	int[] filmIDs = new int[1000];
    	int index = 0;
    	for(int i = 0; i < this.collectionID.size(); i++) {
    		if(this.collectionID.get(i) == collectionID) {
                filmIDs[index] = this.filmID.get(i);
                index ++;
            }
    	}
    	filmIDs = Arrays.copyOf(filmIDs,index);
        return filmIDs;
    }

    /**
     * Gets the name of a given collection
     * 
     * @param collectionID The collection ID
     * @return The name of the collection. If the collection cannot be found, then
     *         return null
     */
    @Override
    public String getCollectionName(int collectionID) {
        // TODO Implement this function
    	for(int i = 0; i < this.collectionID.size(); i++) {
    		if(this.collectionID.get(i) == collectionID) {
                return this.collectionName.get(i);
            }
    	}
        return null;
    }

    /**
     * Gets the poster URL for a given collection
     * 
     * @param collectionID The collection ID
     * @return The poster URL of the collection. If the collection cannot be found,
     *         then return null
     */
    @Override
    public String getCollectionPoster(int collectionID) {
        // TODO Implement this function
    	for(int i = 0; i < this.collectionID.size(); i++) {
    		if(this.collectionID.get(i) == collectionID) {
                return this.collectionPosterPath.get(i);
            }
    	}
        return null;
    }

    /**
     * Gets the backdrop URL for a given collection
     * 
     * @param collectionID The collection ID
     * @return The backdrop URL of the collection. If the collection cannot be
     *         found, then return null
     */
    @Override
    public String getCollectionBackdrop(int collectionID) {
        // TODO Implement this function
    	for(int i = 0; i < this.collectionID.size(); i++) {
    		if(this.collectionID.get(i) == collectionID) {
                return this.collectionBackdropPath.get(i);
            }
    	}
        return null;
    }

    /**
     * Gets the collection ID of a given film
     * 
     * @param filmID The movie ID
     * @return The collection ID for the requested film. If the film cannot be
     *         found, then return -1
     */
    @Override
    public int getCollectionID(int filmID) {
        // TODO Implement this function
    	for(int i = 0; i < this.collectionID.size(); i++) {
    		if(this.filmID.get(i) == filmID) {
                return this.collectionID.get(i);
            }
    	}
        return -1;
    }

    /**
     * Sets the IMDb ID for a given film
     * 
     * @param filmID The movie ID
     * @param imdbID The IMDb ID
     * @return TRUE if the data able to be set, FALSE otherwise
     */
    ArrayList<Integer> movie0 = new ArrayList<Integer>();
    ArrayList<String> imdbID = new ArrayList<>();
    @Override
    public boolean setIMDB(int filmID, String imdbID) {
        // TODO Implement this function
    	for(int i = 0; i< movie0.size(); i++) {
    		if(movie0.get(i)==filmID) {
    			this.imdbID.set(i, imdbID);
    			return true;
    		}
    	}
    	for(int i = 0; i< this.id.size(); i++) {
    		if(this.id.get(i)==filmID) {
    			movie0.add(filmID);
                this.imdbID.add(imdbID);
                return true;
            }
    	}
        return false;
    }

    /**
     * Gets the IMDb ID for a given film
     * 
     * @param filmID The movie ID
     * @return The IMDb ID for the requested film. If the film cannot be found,
     *         return null
     */
    @Override
    public String getIMDB(int filmID) {
        // TODO Implement this function
    	for(int i = 0; i < this.id.size(); i++) {
            if(this.id.get(i) == filmID) {
                return this.imdbID.get(i);
            }
        }
        return null;
    }

    /**
     * Sets the popularity of a given film. If the popularity for a film already exists, replace it with the new value
     * 
     * @param id         The movie ID
     * @param popularity The popularity of the film
     * @return TRUE if the data able to be set, FALSE otherwise
     */
    ArrayList<Integer> movie1 = new ArrayList<Integer>();
    ArrayList<Double> popularity = new ArrayList<>();
    @Override
    public boolean setPopularity(int id, double popularity) {
        // TODO Implement this function
    	for(int i = 0; i< movie1.size(); i++) {
    		if(movie1.get(i)==id) {
    			this.popularity.set(i, popularity);
    			return true;
    		}
    	}
    	for(int i = 0; i< this.id.size(); i++) {
    		if(this.id.get(i)==id) {
    			movie1.add(id);
                this.popularity.add(popularity);
                return true;
            }
    	}
    	
        return false;
    }

    /**
     * Gets the popularity of a given film
     * 
     * @param id The movie ID
     * @return The popularity value of the requested film. If the film cannot be
     *         found, then return -1.0. If the popularity has not been set, return 0.0
     */
    @Override
    public double getPopularity(int id) {
        // TODO Implement this function
    	for(int i = 0;i < movie1.size(); i++) {
    		if(this.movie1.get(i)==id) {
    			return this.popularity.get(i);
    		}
    	}
    	for(int i = 0;i<this.id.size(); i++) {
    		if(this.id.get(i)==id) {
                return 0.0;
            }
    	}
        return -1.0;
    }

    /**
     * Adds a production company to a given film
     * 
     * @param id      The movie ID
     * @param company A Company object that represents the details on a production
     *                company
     * @return TRUE if the data able to be added, FALSE otherwise
     */
    ArrayList<Integer> movie2 = new ArrayList<Integer>();
    ArrayList<Company> company = new ArrayList<>();
    @Override
    public boolean addProductionCompany(int id, Company company) {
        // TODO Implement this function
    	for(int i = 0; i<this.id.size(); i++) {
    		if(this.id.get(i)==id) {
    			movie2.add(id);
                this.company.add(company);
                return true;
            }
    	}
    	return false;
    }

    /**
     * Adds a production country to a given film
     * 
     * @param id      The movie ID
     * @param country A ISO 3166 string containing the 2-character country code
     * @return TRUE if the data able to be added, FALSE otherwise
     */
    ArrayList<Integer> movie3 = new ArrayList<Integer>();
    ArrayList<String> country = new ArrayList<>();
    @Override
    public boolean addProductionCountry(int id, String country) {
        // TODO Implement this function
    	for(int i = 0; i<this.id.size(); i++) {
    		if(this.id.get(i)==id) {
    			movie3.add(id);
                this.country.add(country);
                return true;
            }
    	}
    	return false;
    }

    /**
     * Gets all the production companies for a given film
     * 
     * @param id The movie ID
     * @return An array of Company objects that represent all the production
     *         companies that worked on the requested film. If the film cannot be
     *         found, then return null
     */
    @Override
    public Company[] getProductionCompanies(int id) {
        // TODO Implement this function
    	if(this.id.contains(id)==false){
    		return null;
    	}
    	Company[] companies = new Company[100];
    	int index = 0;
    	for(int i = 0; i<movie2.size(); i++) {
            if(movie2.get(i)==id) {
               companies[index]=this.company.get(i);
               index++;
            }
        }
    	companies = Arrays.copyOf(companies, index);
        return companies;
    }

    /**
     * Gets all the production companies for a given film
     * 
     * @param id The movie ID
     * @return An array of Strings that represent all the production countries (in
     *         ISO 3166 format) that worked on the requested film. If the film
     *         cannot be found, then return null
     */
    @Override
    public String[] getProductionCountries(int id) {
        // TODO Implement this function
    	if(this.id.contains(id)==false){
    		return null;
    	}
    	String[] countries = new String[100];
        int index = 0;
        for(int i = 0; i<movie3.size(); i++) {
            if(movie3.get(i)==id) {
               countries[index]=this.country.get(i);
               index++;
            }
        }
        countries = Arrays.copyOf(countries, index);
        return countries;
    }

    /**
     * States the number of movies stored in the data structure
     * 
     * @return The number of movies stored in the data structure
     */
    @Override
    public int size() {
        // TODO Implement this function
        return this.id.size();
    }

    /**
     * Produces a list of movie IDs that have the search term in their title,
     * original title or their overview
     * 
     * @param searchTerm The term that needs to be checked
     * @return An array of movie IDs that have the search term in their title,
     *         original title or their overview. If no movies have this search term,
     *         then an empty array should be returned
     */
    @Override
    public int[] findFilms(String searchTerm) {
        // TODO Implement this function
    	int[] result = new int[1010];
    	int index = 0;
    	for(int i =0; i < this.id.size(); i++) {
    		if(this.title.get(i).contains(searchTerm) || this.originalTitle.get(i).contains(searchTerm) || this.overview.get(i).contains(searchTerm)) {
                result[index] = this.id.get(i);
                index++;
            }
    	}
    	result = Arrays.copyOf(result, index);
        return result;
    }
}
