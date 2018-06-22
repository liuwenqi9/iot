package com.pcitc.oilmachine.dao.relationdao;

import java.util.List;
import java.util.Map;

import com.pcitc.oilmachine.model.AdInfo;
import com.pcitc.oilmachine.model.AdInfoDetail;
import com.pcitc.oilmachine.model.AdTags;
import com.pcitc.oilmachine.model.CameraDevicesArea;
import com.pcitc.oilmachine.model.Devices;
import com.pcitc.oilmachine.model.DevicesArea;
import com.pcitc.oilmachine.model.Dictionary;
import com.pcitc.oilmachine.model.DictionaryData;
import com.pcitc.oilmachine.model.MqSendException;
import com.pcitc.oilmachine.model.PreAuthorization;
import com.pcitc.oilmachine.model.SellDiscounts;
import com.pcitc.oilmachine.model.SellOrderView;
import com.pcitc.oilmachine.model.SellProduct;
import com.pcitc.oilmachine.model.UserLoginfo;
import com.pcitc.oilmachine.model.UserTags;

public interface RelationMapper {
    
    List<MqSendException> selectMqSendExceptionPageList(Map<String, Object> map);
    
    List<AdInfo> selectAdInfoPageList(Map<String, Object> map);
    
    List<AdInfoDetail> selectAdInfoDetailPageList(Map<String, Object> map);
    
    List<AdTags> selectAdTagsPageList(Map<String, Object> map);
    
    List<UserTags> selectUserTagsPageList(Map<String, Object> map);
    
    List<Devices> selectDevicesPageList(Map<String, Object> map);
    
    List<DevicesArea> selectDevicesAreaPageList(Map<String, Object> map);

	List<Dictionary> selectDictionaryPageList(Map<String, Object> condition);
	
	List<DictionaryData> selectDictionaryDataPageList(Map<String, Object> condition);
    
	List<CameraDevicesArea> selectCameraDevicesAreaList(Map<String, Object> map);

	List<SellOrderView> selectSellOrderList(Map<String, Object> condition);

	List<SellProduct> selectSellProductList(Map<String, Object> condition);

	List<SellDiscounts> selectSellDiscountsList(Map<String, Object> condition);

	List<PreAuthorization> selectPreAuthorizationList(Map<String, Object> condition);
	
	List<UserLoginfo>  selectUserlogininfoPageList(Map<String, Object> condition);
}