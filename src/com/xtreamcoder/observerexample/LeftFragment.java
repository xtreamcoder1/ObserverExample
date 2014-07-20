package com.xtreamcoder.observerexample;

import java.util.Observable;
import java.util.Observer;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

public class LeftFragment extends Fragment implements Observer{
	
	private TextView scoreText;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
			
		View view = inflater.inflate(R.layout.fragment, container, false);
		view.setBackgroundColor(Color.parseColor("#966F33"));
		
		scoreText = (TextView) view.findViewById(R.id.score_txt);
		((TextView) view.findViewById(R.id.fragment_txt)).setText(getClass().getSimpleName());
		
		((MainActivity)getActivity()).scoreObservable.addObserver(this);
		
		view.findViewById(R.id.score_button).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				((MainActivity)getActivity()).scoreObservable.UpdateScoreInAllFragments();
			}
		});
		
		return view;
	}

	@Override
	public void update(Observable observable, Object data) {
		scoreText.setText(((MainActivity)getActivity()).scoreObservable.getScore());
	}

}