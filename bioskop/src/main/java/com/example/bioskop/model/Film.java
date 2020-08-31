package com.example.bioskop.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Film implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3399362353982459317L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(nullable=false)
	private String name;
	
	@Column
	private String description;
		
	@Column(nullable=false)
	private String genre;
	
	@Column(nullable=false)
	private Long duration;
	
	@Column 
	private double rating;
	
	@JsonIgnore
	@OneToMany(mappedBy="film",fetch=FetchType.LAZY,orphanRemoval=true)
	private Set<Watched> watched=new HashSet<>();
	
	@OneToMany(mappedBy="film",fetch=FetchType.EAGER,orphanRemoval=true)
	private Set<Projection> projections=new HashSet<>();
	
	public Set<Watched> getWatched() {
		return watched;
	}

	public void setWatched(Set<Watched> watched) {
		this.watched = watched;
	}

	public Set<Projection> getProjections() {
		return projections;
	}

	public void setProjections(Set<Projection> projections) {
		this.projections = projections;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public Film(long id, String name, String description, String genre, long duration, double rating) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.genre = genre;
		this.duration = duration;
		this.rating = rating;
	}
	
	public Film() {
		rating=0;
	}
	
}
