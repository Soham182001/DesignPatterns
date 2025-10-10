package TicTacToe.Model;

public class Player {
    public PlayingPiece playingPiece;
    public String name;

    public Player(PlayingPiece playingPiece, String name){
        this.playingPiece = playingPiece;
        this.name = name;
    }

    public String getName () {
        return name;
    }
    public PlayingPiece getPlayingPiece () {
        return playingPiece;
    }
    public void setPlayingPiece (PlayingPiece playingPiece){
        this.playingPiece = playingPiece;
    }
    public void setName (String name){
        this.name = name; 
    }
}
