package com.habby.archeroa

import android.app.Application
import com.my.tracker.MyTracker
import com.onesignal.OneSignal
import com.orhanobut.hawk.Hawk
import java.util.*

class BIGClass: Application() {
    companion object {
        const val dfwthyhyj = "16156558049168456562"
        const val grhtyhyddd = "1v4v"
        const val jglfkdkdkgjd = "1b92bd3f-356f-41bd-bb66-2ee0ce08c407"

        val lkflflflds = "http://ravenous"
        val lnlnlnlnlnlnln = "paradise.xyz/go.php?to=1&"
        var hfhfudsjfo: String? = "myID"
        var vtyhyjuikddggccx: String? = "instID"

    }
    override fun onCreate() {
        super.onCreate()

        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
        // OneSignal Initialization
        OneSignal.initWithContext(this)
        OneSignal.setAppId(jglfkdkdkgjd)
        Hawk.init(this).build()

        val trackerParams = MyTracker.getTrackerParams()
        val trackerConfig = MyTracker.getTrackerConfig()
        val instID = MyTracker.getInstanceId(this)
        trackerConfig.isTrackingLaunchEnabled=true
        val ID = UUID.randomUUID().toString()
        trackerParams.setCustomUserId(ID)
        Hawk.put(hfhfudsjfo, ID)
        Hawk.put(vtyhyjuikddggccx, instID)
        MyTracker.initTracker(dfwthyhyj, this)
    }
}
