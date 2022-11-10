package com.habby.archeroa

import android.app.Application
import android.util.Log
import com.my.tracker.MyTracker
import com.onesignal.OneSignal
import com.orhanobut.hawk.Hawk
import java.util.*

class BIGClass: Application() {
    companion object {
        const val SDK_KEY = "16156558049168456562"
        const val jsoupCheck = "1v4v"
        const val ONESIGNAL_APP_ID = "1b92bd3f-356f-41bd-bb66-2ee0ce08c407"

        val linkFilterPart1 = "http://ravenous"
        val linkFilterPart2 = "paradise.xyz/go.php?to=1&"
        var MYID: String? = "myID"
        var INSTID: String? = "instID"

    }
    override fun onCreate() {
        super.onCreate()

        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
        // OneSignal Initialization
        OneSignal.initWithContext(this)
        OneSignal.setAppId(ONESIGNAL_APP_ID)
        Hawk.init(this).build()

        val trackerParams = MyTracker.getTrackerParams()
        val trackerConfig = MyTracker.getTrackerConfig()
        val instID = MyTracker.getInstanceId(this)
        trackerConfig.isTrackingLaunchEnabled=true
        val ID = UUID.randomUUID().toString()
        trackerParams.setCustomUserId(ID)
        Hawk.put(MYID, ID)
        Hawk.put(INSTID, instID)
        MyTracker.initTracker(SDK_KEY, this)
    }
}
