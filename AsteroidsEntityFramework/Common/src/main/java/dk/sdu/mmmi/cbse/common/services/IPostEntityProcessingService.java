package dk.sdu.mmmi.cbse.common.services;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;

/**
 *
 * @author jcs
 */

// GameData: contains Time since last update, and data such as width and height of screen
// World: contains all entities and vector-data, in order to draw the "world"/game

public interface IPostEntityProcessingService  {
        void process(GameData gameData, World world);
}
