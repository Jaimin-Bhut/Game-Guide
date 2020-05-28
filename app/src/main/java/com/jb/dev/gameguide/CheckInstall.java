package com.jb.dev.gameguide;

import android.app.Activity;
import android.content.pm.PackageManager;

public class CheckInstall {

    public static boolean appInstallCheck(String uri, Activity activity) {
        PackageManager packageManager = activity.getPackageManager();
        boolean app_installed;
        try {
            packageManager.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
            app_installed = true;
        } catch (Exception e) {
            app_installed = false;
        }
        return app_installed;
    }
}
