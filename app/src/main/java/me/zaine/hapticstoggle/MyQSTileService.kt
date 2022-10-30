package me.zaine.hapticstoggle

import android.graphics.drawable.Icon
import android.service.quicksettings.Tile
import android.service.quicksettings.TileService
import me.zaine.hapticstoggle.HapticsController.Companion.getHapticsState

class MyQSTileService : TileService() {

    data class StateModel(val enabled: Boolean, val label: String, val icon: Icon)
    // Called when the user adds your tile.
    override fun onTileAdded() {
        super.onTileAdded()
    }
    // Called when your app can update your tile.
    override fun onStartListening() {
        super.onStartListening()
        val state = getHapticsState()
        qsTile.state = if (state) Tile.STATE_ACTIVE else Tile.STATE_INACTIVE
        qsTile.updateTile()
    }

    // Called when your app can no longer update your tile.
    override fun onStopListening() {
        super.onStopListening()
        val tile:Tile = qsTile;

    }

    // Called when the user taps on your tile in an active or inactive state.
    override fun onClick() {
        super.onClick()
        val tile:Tile = qsTile;
        val state = HapticsController.toggleHapticsState()
        qsTile.state = if (state) Tile.STATE_ACTIVE else Tile.STATE_INACTIVE
        tile.updateTile()

    }
    // Called when the user removes your tile.
    override fun onTileRemoved() {
        super.onTileRemoved()
    }

}