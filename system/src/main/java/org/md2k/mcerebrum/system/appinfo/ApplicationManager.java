package org.md2k.mcerebrum.system.appinfo;

// TODO: Ask Monowar what is and is not important here.
public class ApplicationManager {
/*
    private ArrayList<String> packageNames;
    protected Context context;
    public ApplicationManager(Context context){
        this.context = context;
        packageNames = AppCP.read(context);

    }
*/
/*
    public ArrayList<String> getByType(String type) {
        ArrayList<String> acs = new ArrayList<>();
        for(int i=0;i<packageNames.size();i++) {
            if (AppCP.getType(context, packageNames.get(i) != nu))
        }
        for (AppInfoController appInfoController : appInfoControllers) {
            if (appInfoController.getAppBasicInfo().isType(type))
                acs.add(appInfoController);
        }
        return acs;
    }


    public boolean isRequiredInstalled() {
        return getRequiredAppNotInstalled().size() == 0;
    }



*//*
*//*


*//*
    public void reset(String packageName) {
        AppInfoController appInfoController = getAppInfoController(packageName);
        if(appInfoController==null) return;
        boolean lastResult = appInfoController.getInstallInfoController().isInstalled();
        appInfoController.getInstallInfoController().reset();
        appInfoController.getAppAccess().reset();
//                appInfoControllers[i].getInstallInfoController().setInstalled();
        if (appInfoController.getInstallInfoController().isInstalled() != lastResult) {
            if (appInfoController.getInstallInfoController().isInstalled())
                appInfoController.getAppAccess().startService();
            else appInfoController.getAppAccess().stopService();
        }
    }

*//*
    Observable hasUpdate(String packageName) {
        AppInfoController appInfoController = getAppInfoController(packageName);
        if (appInfoController == null) return Observable.just(false);
        return appInfoController.getInstallInfoController().checkUpdate();
    }


    public Observable<Boolean> hasUpdate() {
        if (appInfoControllers == null || appInfoControllers.size() == 0)
            return Observable.just(false);
        ArrayList<Observable<Boolean>> observables=new ArrayList<>();
//        Observable[] observables = new Observable[getAppInfoControllers().length];
        for (int i = 0; i < appInfoControllers.size(); i++) {
            observables.add(appInfoControllers.get(i).getInstallInfoController().checkUpdate());
        }
        return Observable.merge(observables);
    }

    private AppInfoController getAppInfoController(String packageName) {
        for (AppInfoController appInfoController : appInfoControllers) {
            if (appInfoController.getPackageName().equals(packageName)) return appInfoController;
        }
        return null;
    }*/
}
