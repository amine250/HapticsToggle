package me.zaine.hapticstoggle

import com.topjohnwu.superuser.Shell;

class RootController {
    companion object{

        fun checkRootAccess(): Boolean {
            var result: Shell.Result = Shell.cmd("find /dev/block -iname boot").exec();
            return result.isSuccess
        }
    }
}