package Model;

public class User {
    private String username;
    private String password;
    private String nickname;
    private int highScore;

    public String getUsername() {
        return username;
    }


    public String getPassword() {
        return password;
    }


    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }


    public User(String username, String password, String nickname) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.highScore = 0;
    }


    public int getHighScore() {
        return highScore;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

    @Override
    public String toString() {
        return "username : " + username + "\n" +
                "password : " + password + "\n" +
                "nickname : " + nickname + "\n" +
                "highscore : " + highScore;
    }

}
