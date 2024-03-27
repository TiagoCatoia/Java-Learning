import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Team {
    private final String name;
    private final String baseLocation;
    private final String coachName;
    private final Player[] players = new Player[18];
    private int numPlayers = 0;
    private int numOutfieldedPlayers = 0;
    private int numFildedPlayers = 0;
    private Player captain;


    public Team(String name, String baseLocation, String coachName) {
        this.name = name;
        this.baseLocation = baseLocation;
        this.coachName = coachName;
    }

    public void addPlayer(Player newPlayer) {
        if (numPlayers == 18) {
            throw new ArrayStoreException("The team already has 18 players.");
        }

        if (newPlayer.getIsFielded()) {
            if (this.numFildedPlayers == 11) {
                throw new IllegalArgumentException("Team already has 11 players on the field.");
            }
        } else {
            if (this.numOutfieldedPlayers == 7) {
                throw new IllegalArgumentException("Team already has 7 players out the field.");
            }
        }

        this.players[numPlayers++] = newPlayer;
        newPlayer.setTeam(this.name);
    }

    public void removePlayer(Player player) {
        Player auxPlayer = this.players[numPlayers-1];
        int positionPlayer = -1;
        for (int i = 0; i < this.numPlayers; i++) {
            if (this.players[i].equals(player)) {
                positionPlayer = i;
                break;
            }
        }
        if (positionPlayer == -1) {
            throw new IllegalArgumentException("That player is not on the team");
        } else if (player.getIsFielded()) {
            this.numFildedPlayers--;
        } else {
            this.numOutfieldedPlayers--;
        }
        this.players[numPlayers-1] = player;
        this.players[positionPlayer] = auxPlayer;
        this.numPlayers--;
    }

    public void substitute(Player substitute, Player starter) {
        boolean starterInTeam = false;
        boolean substituteInTeam = false;
        for (int i = 0; i < this.numPlayers; i++) {
            if (this.players[i] == null) {
                continue;
            } else if (this.players[i].equals(starter)) {
                starterInTeam = true;
                continue;
            } else if (this.players[i].equals(substitute)) {
                substituteInTeam = true;
                continue;
            }
        }
        if (!starterInTeam) {
            throw new IllegalArgumentException("The starting player is not in the team.");
        } else if (!substituteInTeam) {
            throw new IllegalArgumentException("The substitute player is not in the team.");
        }

        starter.setIsFielded(false);
        substitute.setIsFielded(true);

        if (this.captain.equals(starter)) {
            this.captain = substitute;
        }
    }

    public void setCaptain(Player newCaptain) {
        boolean newCaptainInTeam = false;
        for (Player eachPlayer : this.players) {
            if (eachPlayer == null) {
                continue;
            }else if (eachPlayer.equals(newCaptain)) {
                    newCaptainInTeam = true;
            }
        }
        if (!newCaptainInTeam) {
            throw new IllegalArgumentException("The new captain is not in the team.");
        }
        if (this.captain == newCaptain) {
            throw new IllegalArgumentException("That player is already the current captain.");
        }
        this.captain = newCaptain;
    }

    public Player[] getFieldedPlayers() {
        Player[] fieldedPlayers = new Player[numFildedPlayers];
        int countFielded = 0;
        for (Player eachPlayer : this.players) {
            if (eachPlayer == null) {
                continue;
            }else if (eachPlayer.getIsFielded()) {
                fieldedPlayers[countFielded++] = eachPlayer;
            }
        }
        return fieldedPlayers;
    }

    public Player[] getOutfieldedPlayers() {
        Player[] outfieldedPlayers = new Player[numOutfieldedPlayers];
        int countOutfielded = 0;
        for (Player eachPlayer : this.players) {
            if (eachPlayer == null) {
                continue;
            }else if (!eachPlayer.getIsFielded()) {
                outfieldedPlayers[countOutfielded++] = eachPlayer;
            }
        }
        return outfieldedPlayers;
    }

    public String getName() {
        return this.name;
    }

    public String getBaseLocation() {
        return this.baseLocation;
    }

    public String getCoachName() {
        return this.coachName;
    }

    public Player getCaptain() {
        return this.captain;
    }

    public Player[] getPlayers() {
        return this.players;
    }
}
