package me.zaine.hapticstoggle

import android.os.Bundle
import android.os.VibrationAttributes
import android.provider.Settings
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.topjohnwu.superuser.Shell
import me.zaine.hapticstoggle.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    // Set settings before the main shell can be created
    companion object {
        init {
            // Set settings before the main shell can be created
            Shell.enableVerboseLogging = BuildConfig.DEBUG
            Shell.setDefaultBuilder(
                Shell.Builder.create()
                    .setFlags(Shell.FLAG_REDIRECT_STDERR)
                    .setTimeout(10)
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)


    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }

    fun requestPermission(view: View){
        Log.i("Permission", "Requesting root access...")
        Toast.makeText(applicationContext, "Root access is "+RootController.checkRootAccess(), Toast.LENGTH_SHORT).show()
    }

    fun toggleHaptics(view: View){
        when (HapticsController.toggleHapticsState()) {
            -1 -> Toast.makeText(applicationContext, "Root access is needed!", Toast.LENGTH_SHORT).show()
            0 -> Toast.makeText(applicationContext, "Haptics are off!", Toast.LENGTH_SHORT).show()
            1 -> Toast.makeText(applicationContext, "Haptics are on!", Toast.LENGTH_SHORT).show()
        }

    }

}