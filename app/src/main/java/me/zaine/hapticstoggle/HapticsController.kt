package me.zaine.hapticstoggle

import com.topjohnwu.superuser.Shell

class HapticsController  {
    companion object {

        //Gets current haptics state : Active or Inactive
        fun getHapticsState(): Boolean{
            var state = Shell.cmd("cat /sys/class/leds/vibrator/level").exec().out[0].toInt();

            println("Haptics current state is $state");
            return (state != 0)
        }

        //Toggles haptics state
        fun toggleHapticsState(): Boolean {
            return if (getHapticsState()){
                //disabling
                Shell.cmd("echo 0 > /sys/class/leds/vibrator/level").exec();
                false
            }else{
                //enabling
                Shell.cmd("echo 3 > /sys/class/leds/vibrator/level").exec();
                true
            }
        }
    }
}