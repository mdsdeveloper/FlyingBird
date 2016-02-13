package com.magui.flyingBird;


import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.games.Games;
import com.google.example.games.basegameutils.GameHelper;
import com.google.example.games.basegameutils.GameHelper.GameHelperListener;
import com.touchBird.C.C;
import com.touchBird.general.ActionResolver;
import com.touchBird.general.MainFlyingBird;


public class AndroidLauncher extends AndroidApplication implements ActionResolver, GameHelperListener {

	private static final String AD_UNIT_ID_BANNER = C.AD_UNIT_ID_BANNER;
	private static final String AD_UNIT_ID_INTERSTITIAL = C.AD_UNIT_ID_INTERSTITIAL;
	protected AdView adView;
	protected View gameView;
	private InterstitialAd interstitialAd;
	private GameHelper _gameHelper;
	private final static int REQUEST_CODE_UNUSED = 9002;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);


		AndroidApplicationConfiguration cfg = new AndroidApplicationConfiguration();

		cfg.useAccelerometer = false;
		cfg.useCompass = false;

		// Do the stuff that initialize() would do for you
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		getWindow().clearFlags(
				WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);

		FrameLayout layout = new FrameLayout(this);
		FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
				FrameLayout.LayoutParams.MATCH_PARENT,
				FrameLayout.LayoutParams.MATCH_PARENT);
		layout.setLayoutParams(params);

		AdView admobView = createAdView();

		View gameView = createGameView(cfg);
		layout.addView(gameView);
		layout.addView(admobView);
		_gameHelper = new GameHelper(this, GameHelper.CLIENT_GAMES);
		_gameHelper.enableDebugLog(false);

		GameHelperListener gameHelperListener = new GameHelper.GameHelperListener() {
			@Override
			public void onSignInSucceeded() {
			}

			@Override
			public void onSignInFailed() {
			}
		};

		if (C.LEADERBOARDS) {

			_gameHelper.setup(gameHelperListener);
		}

		setContentView(layout);
		startAdvertising(admobView);

		interstitialAd = new InterstitialAd(this);
		interstitialAd.setAdUnitId(AD_UNIT_ID_INTERSTITIAL);
		interstitialAd.setAdListener(new AdListener() {
			@Override
			public void onAdLoaded() {

			}

			@Override
			public void onAdClosed() {
				showOrLoadInterstital();
			}
		});
		showOrLoadInterstital();

	}

	private AdView createAdView() {
		adView = new AdView(this);
		adView.setAdSize(AdSize.SMART_BANNER);
		adView.setAdUnitId(AD_UNIT_ID_BANNER);
		adView.setId(R.id.action_bar); // this is an arbitrary id, allows for relative
		// positioning in createGameView()
		FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);

		params.gravity = Gravity.BOTTOM;

		adView.setLayoutParams(params);
		adView.setBackgroundColor(Color.TRANSPARENT);
		return adView;
	}

	private View createGameView(AndroidApplicationConfiguration cfg) {
		gameView = initializeForView(new MainFlyingBird(), cfg);
		FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);

		gameView.setLayoutParams(params);
		return gameView;
	}

	private void startAdvertising(AdView adView) {
		AdRequest adRequest = new AdRequest.Builder().build();
		adView.loadAd(adRequest);
	}

	@Override
	public void onResume() {
		super.onResume();
		if (adView != null)
			adView.resume();
		if(C.LEADERBOARDS)
			_gameHelper.onStart(this);

	}

	@Override
	public void onPause() {
		if (adView != null)
			adView.pause();
		super.onPause();
	}

	@Override
	public void onDestroy() {
		if (adView != null)
			adView.destroy();
		super.onDestroy();
	}

	@Override
	protected void onStart() {
		super.onStart();
		//  if(C.LEADERBOARDS)
		//    _gameHelper.onStart(this);

	}

	@Override
	protected void onStop() {
		super.onStop();
		if(C.LEADERBOARDS)
			_gameHelper.onStop();
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		_gameHelper.onActivityResult(requestCode, resultCode, data);
	}

	@Override
	public void showOrLoadInterstital() {
		try {
			runOnUiThread(new Runnable() {
				public void run() {
					if (interstitialAd.isLoaded()) {
						interstitialAd.show();

					} else {
						AdRequest interstitialRequest = new AdRequest.Builder()
								.build();
						interstitialAd.loadAd(interstitialRequest);

					}
				}
			});
		} catch (Exception e) {
		}
	}

	@Override
	public void signIn() {
		try {
			runOnUiThread(new Runnable() {
				// @Override
				public void run() {
					_gameHelper.beginUserInitiatedSignIn();
				}
			});
		} catch (Exception e) {
			Gdx.app.log("MainActivity", "Log in failed: " + e.getMessage()
					+ ".");
		}
	}

	@Override
	public void signOut() {
		try {
			runOnUiThread(new Runnable() {
				// @Override
				public void run() {
					_gameHelper.signOut();
				}
			});
		} catch (Exception e) {
			Gdx.app.log("MainActivity", "Log out failed: " + e.getMessage()
					+ ".");
		}
	}


	@Override
	public void submitScore(long score) {

		if(C.LEADERBOARDS)
			if (isSignedIn() == true) {
				Games.Leaderboards.submitScore(_gameHelper.getApiClient(), C.LEADERBOARD_ID, score);
			} else {
				// signIn();
			}
	}

	@Override
	public void showScores() {

		if(C.LEADERBOARDS){

			if (isSignedIn() == true)
				startActivityForResult(
						Games.Leaderboards.getLeaderboardIntent(
								_gameHelper.getApiClient(), C.LEADERBOARD_ID),
						REQUEST_CODE_UNUSED);
			else {
				signIn();
			}
		}
	}


	@Override
	public boolean isSignedIn() {
		return _gameHelper.isSignedIn();
	}

	@Override
	public void onSignInFailed() {
	}

	@Override
	public void onSignInSucceeded() {
	}

	//Code for share button
	@Override
	public void share(Integer points){
		Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
		sharingIntent.setType("text/plain");
		String shareBody = "I got "+ points.toString()+" points in the game " + getResources().getString(R.string.app_name)+". Are you able to beat me? https://play.google.com/store/apps/details?id="+getPackageName();
		sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
		startActivity(Intent.createChooser(sharingIntent, "Share via"));
	}



	@Override
	public void rate(){
		Uri uri = Uri.parse("market://details?id=" + getPackageName());
		Intent myAppLinkToMarket = new Intent(Intent.ACTION_VIEW, uri);
		try {
			startActivity(myAppLinkToMarket);
		} catch (ActivityNotFoundException e) {
			Toast.makeText(getApplicationContext(), "Unable to find Google Play app.", Toast.LENGTH_LONG).show();
		}
	}

	@Override
	public int getBannerHeight() {

		return AdSize.SMART_BANNER.getHeightInPixels(this);
	}


}
