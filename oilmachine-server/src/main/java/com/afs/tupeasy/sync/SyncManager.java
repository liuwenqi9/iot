package com.afs.tupeasy.sync;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SyncManager {

	private static Map<String,SyncCallBack> syncContainer = new ConcurrentHashMap<String,SyncCallBack>();;
	
    public static void addSyncCallBackObject(String id,SyncCallBack callBack){
    	syncContainer.put(id, callBack);
    }
    
    public static void removeSyncCallBackObject(String id){
    	syncContainer.remove(id);
    }
    
    public static SyncCallBack getSyncCallBackObject(String id){
    	return syncContainer.get(id);
    }
}
