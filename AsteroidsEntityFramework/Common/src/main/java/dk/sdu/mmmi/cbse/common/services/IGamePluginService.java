package dk.sdu.mmmi.cbse.common.services;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;

// GameData: contains Time since last update, and data such as width and height of screen
// World: contains all entities and vector-data, in order to draw the "world"/game
//start(): Adds data on component install
//start(): Removes data on components when the game is done
public interface IGamePluginService {
    void start(GameData gameData, World world);

    void stop(GameData gameData, World world);
}
