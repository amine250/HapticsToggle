package me.zaine.hapticstoggle

import com.topjohnwu.superuser.Shell.getShell

class RootController {
    companion object{
        fun checkRootAccess(): Boolean {
            return getShell().isRoot
        }
    }
}