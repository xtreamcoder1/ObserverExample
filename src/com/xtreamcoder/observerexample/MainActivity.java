package com.xtreamcoder.observerexample;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends ActionBarActivity {

	private TopFragment tFragment;
	private LeftFragment lFragment;
	private RightFragment rFragment;
	public ScoreObservable scoreObservable;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		BaseApplication bApp = (BaseApplication) getApplication();
		scoreObservable = bApp.getObserver();
		
		tFragment = new TopFragment();
		lFragment = new LeftFragment();
		rFragment = new RightFragment();
		
		FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
		transaction.addToBackStack(null);
		transaction.replace(R.id.framelayout1, tFragment);
		transaction.replace(R.id.framelayout2, lFragment);
		transaction.replace(R.id.framelayout3, rFragment);
		transaction.commit();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    getMenuInflater().inflate(R.menu.main, menu);
	    return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle presses on the action bar items
	    switch (item.getItemId()) {
	        case R.id.score_menu:
	        	scoreObservable.UpdateScoreInAllFragments();
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
	
}