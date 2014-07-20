package com.xtreamcoder.observerexample;

import android.app.Application;

public class BaseApplication extends Application {
	ScoreObservable scoreObservable;

	@Override
	public void onCreate() {
		super.onCreate();

		scoreObservable = new ScoreObservable();
	}

	public ScoreObservable getObserver() {
		return scoreObservable;
	}

}