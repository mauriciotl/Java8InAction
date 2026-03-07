package lambdasinaction.chap2.mauPractice03_GenericsPredicate.domain;


public class Song {

    private String songName;
    private String artistName;
    private String spotifyId;

    public Song(String songName, String artistName, String spotifyId) {
        this.songName = songName;
        this.artistName = artistName;
        this.spotifyId = spotifyId;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public void setSpotifyId(String spotifyId) {
        this.spotifyId = spotifyId;
    }

    public String getSongName() {
        return songName;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getSpotifyId() {
        return spotifyId;
    }
}
