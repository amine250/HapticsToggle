package me.zaine.hapticstoggle

import android.content.Context;
import android.os.VibrationAttributes;
import android.os.Vibrator;
import android.provider.Settings
import android.util.Log

class HapticsController {
    companion object {

        //Gets current haptics state : Active or Inactive
        fun getHapticsState(): Boolean{
            var state:Boolean = true
            println("Haptics current state is $state");
            return state
        }

        //Toggles haptics state
        fun toggleHapticsState(): Int {


            val hapticFeedbackEnabled: Int = VibrationAttributes.USAGE_TOUCH
            Log.i("Haptics", "are "+ hapticFeedbackEnabled)



            //Checking root access
            if(RootController.checkRootAccess()){
                Log.i("Haptics","haptics state is "+ hapticFeedbackEnabled)
                //Getting current haptics state
                if (Settings.System.HAPTIC_FEEDBACK_ENABLED == "18") {
                    Log.i("Haptics", "toggled OFF!!!")
                    return 0
                }else{
                    Log.i("Haptics", "toggled ON!!!")
                    return 1
                }
            }else{
                return -1
            }

        }
    }
}