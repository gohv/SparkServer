package com.home.portfolio.model;


import java.util.ArrayList;
import java.util.List;

public class SimpleProjectDAO implements PortfolioProjectDAO {
    private List<PortfolioProject> ideas;

    public SimpleProjectDAO(){
        ideas = new ArrayList<>();
    }

    @Override
    public boolean add(PortfolioProject idea) {
        return ideas.add(idea);
    }

    @Override
    public List<PortfolioProject> findAll() {
        return new ArrayList<>(ideas);
    }
}
