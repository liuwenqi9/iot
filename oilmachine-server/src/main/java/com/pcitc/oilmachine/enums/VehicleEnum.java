package com.pcitc.oilmachine.enums;

/**
 * 
 */
public enum VehicleEnum {
	
    CARCOLOR{
        @Override
        public String toString() {
            return "carcolor";
        }
    },
    CARTYPE{
        @Override
        public String toString() {
            return "cartype";
        }
    },
    LEFT{
        @Override
        public String toString() {
            return "left";
        }
    },
    TOP{
    	 @Override
         public String toString() {
             return "top";
         }
    },
    RIGHT{
   	 @Override
        public String toString() {
            return "right";
        }
   },
   BOTTOM{
	   	 @Override
	        public String toString() {
	            return "bottom";
	        }
   },
   CARSTATUS{
	   	@Override
        public String toString() {
            return "carstatus";
        }
   },
   CARNUM{
	   	 @Override
	        public String toString() {
	            return "carnum";
	        }
	},
	CAMERAID{
	   	 @Override
	        public String toString() {
	            return "cameraid";
	        }
	}
	,
	GASSTATUS{
	   	 @Override
	        public String toString() {
	            return "gasstatus";
	        }
	}
	;
}

