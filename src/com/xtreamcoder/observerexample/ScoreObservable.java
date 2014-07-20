package com.xtreamcoder.observerexample;

import java.util.Observable;

// In order to report changes to any interested objects, such as Activities, we
// need to extend the Observable class. This enables other objects to register
// themselves as an Observer by using the addObserver() method.
public class ScoreObservable extends Observable {

	private int score = 0;
	
    // Create a method to update the Observerable's flag to true for changes and
    // notify the observers to check for a change. These are also a part of the
    // secret sauce that makes Observers and Observables communicate
    // predictably.
    public void UpdateScoreInAllFragments() {
    	
    	score = score+1;
    	
        setChanged();
        notifyObservers();
    }
    
    public String getScore(){
    	return String.valueOf(score);
    }
}