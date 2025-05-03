package com.romitshrivastava.Design_Patterns.Behavioral_Pattern.State_Design_Pattern;

// State Interface
 interface State {
    void handleRequest();
}



// Concrete State A - Playing state
 class PlayingState implements State {
    private MusicPlayer player;

    public PlayingState(MusicPlayer player) {
        this.player = player;
    }

    @Override
    public void handleRequest() {
        System.out.println("Music is now playing.");
        player.setState(player.getPausedState());  // Transition to PausedState
    }
}

// Concrete State B - Paused state
 class PausedState implements State {
    private MusicPlayer player;

    public PausedState(MusicPlayer player) {
        this.player = player;
    }

    @Override
    public void handleRequest() {
        System.out.println("Music is paused.");
        player.setState(player.getStoppedState());  // Transition to StoppedState
    }
}

// Concrete State C - Stopped state
 class StoppedState implements State {
    private MusicPlayer player;

    public StoppedState(MusicPlayer player) {
        this.player = player;
    }

    @Override
    public void handleRequest() {
        System.out.println("Music is stopped.");
        player.setState(player.getPlayingState());  // Transition to PlayingState
    }
}



// Context Class - MusicPlayer
 class MusicPlayer {
    private State playingState;
    private State pausedState;
    private State stoppedState;
    private State currentState;

    public MusicPlayer() {
        playingState = new PlayingState(this);
        pausedState = new PausedState(this);
        stoppedState = new StoppedState(this);

        currentState = stoppedState;  // Initial state
    }

    public void setState(State state) {
        currentState = state;
    }

    public void request() {
        currentState.handleRequest();
    }

    public State getPlayingState() {
        return playingState;
    }

    public State getPausedState() {
        return pausedState;
    }

    public State getStoppedState() {
        return stoppedState;
    }
}





// Client Code - Main
public class Main {
    public static void main(String[] args) {
        MusicPlayer player = new MusicPlayer();

        // Change states
        player.request();  // Output: Music is stopped. Transitioning to Playing state.
        player.request();  // Output: Music is now playing. Transitioning to Paused state.
        player.request();  // Output: Music is paused. Transitioning to Stopped state.
    }
}
