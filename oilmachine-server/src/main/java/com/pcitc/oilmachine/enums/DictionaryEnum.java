package com.pcitc.oilmachine.enums;

/**
 * 
 */
public enum DictionaryEnum {

	DEVICESTYPE{
        @Override
        public String toString() {
            return "0001";//设备类型
        }
    },
    CAR_COLOR{
        @Override
        public String toString() {
            return "car_color";//车身颜色
        }
    },
    CAR_SHAPE{
        @Override
        public String toString() {
            return "0002";//车型
        }
    },
    TIMEOUT{
        @Override
        public String toString() {
            return "003";//车型
        }
    },
    CODE2EIGHTCODE{
        @Override
        public String toString() {
            return "oil_code2eightcode";//加油机编与石化编码对照关系
        }
    },
    BUSINESSPARAM{
        @Override
        public String toString() {
            return "business_param";//业务参数
        }
    },
    SYSPARAMSOUTER{
        @Override
        public String toString() {
            return "sys_params_outer";//业务参数
        }
    }
	;
}

