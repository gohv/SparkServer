package com.home.portfolio.model;

// Data access object

import java.util.List;

public interface PortfolioProjectDAO {

    boolean add(PortfolioProject idea);

    List<PortfolioProject> findAll();

}
