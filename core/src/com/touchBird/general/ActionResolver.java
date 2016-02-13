package com.touchBird.general;

public interface ActionResolver {

    public void showOrLoadInterstital();
    public void signIn();
    public void submitScore(long score);
    public boolean isSignedIn();
    public void share(Integer points);
    public void rate();
    public int getBannerHeight();
    public void signOut();
    public void showScores();
}
