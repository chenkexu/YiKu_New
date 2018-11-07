package com.dexfun.yiku.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class KnapsacEntry implements Serializable {
    public Boolean getChecked() {
        return isChecked;
    }

    public void setChecked(Boolean checked) {
        isChecked = checked;
    }

    private Boolean isChecked = false;

    /**
     * status : 200
     * msg : 购物车列表
     * data : [{"shoppingCartId":44011,"userId":270,"clothingId":1119,"clothingName":"三色几何撞色半裙","clothingNo":"3020066","clothingExplain":"通勤半裙，很有气质的一款，优雅又充满魅力，几何撞色，为这件半裙增加了更多的独特性，建议搭配雪纺面料的上衣","clothingPrice":1230,"clothingBrandName":"GUESS","clothingStockId":3404,"clothingStockType":"S","clothingStockNum":2,"clothingImgUrl":"http://img-cdn.xykoo.cn/clothing/三色几何撞色半裙/clothingImg0","classify":1,"occupySeat":1},{"shoppingCartId":48478,"userId":270,"clothingId":798,"clothingName":"缤纷音乐节连衣裙","clothingNo":"3010120","clothingExplain":"整件连衣裙都超级美，剪裁精细，裙子上的音乐符号就像一个个跳舞的精灵，什么性格的女生都能驾驭","clothingPrice":829,"clothingBrandName":"Kate Spade","clothingStockId":2986,"clothingStockType":"S","clothingStockNum":1,"clothingImgUrl":"http://img-cdn.xykoo.cn/clothing/缤纷音乐节连衣裙/clothingImg0","classify":1,"occupySeat":1},{"shoppingCartId":51425,"userId":270,"clothingId":711,"clothingName":"水洗烟灰牛仔系列","clothingNo":"2010022","clothingExplain":"烟灰色的水洗很特别，抛弃了传统的深浅蓝系列，从颜色来说更显瘦，也是日常百搭的小单品","clothingPrice":724,"clothingBrandName":"UIPPANG","clothingStockId":2899,"clothingStockType":"M","clothingStockNum":2,"clothingImgUrl":"http://img-cdn.xykoo.cn/clothing/水洗烟灰牛仔系列/clothingImg0","classify":1,"occupySeat":1},{"shoppingCartId":51431,"userId":270,"clothingId":711,"clothingName":"水洗烟灰牛仔系列","clothingNo":"2010022","clothingExplain":"烟灰色的水洗很特别，抛弃了传统的深浅蓝系列，从颜色来说更显瘦，也是日常百搭的小单品","clothingPrice":724,"clothingBrandName":"UIPPANG","clothingStockId":2898,"clothingStockType":"S","clothingStockNum":2,"clothingImgUrl":"http://img-cdn.xykoo.cn/clothing/水洗烟灰牛仔系列/clothingImg0","classify":1,"occupySeat":1}]
     * success : true
     */

    private int status;
    private String msg;
    private boolean success;
    private ArrayList<DataEntity> data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public ArrayList<DataEntity> getData() {
        return data;
    }

    public void setData(ArrayList<DataEntity> data) {
        this.data = data;
    }

    public static class DataEntity  implements Serializable,Cloneable{
        @Override
        public Object clone() {
            DataEntity stu = null;
            try{
                stu = (DataEntity)super.clone();
            }catch(CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return stu;
        }
        /**
         * shoppingCartId : 44011
         * userId : 270
         * clothingId : 1119
         * clothingName : 三色几何撞色半裙
         * clothingNo : 3020066
         * clothingExplain : 通勤半裙，很有气质的一款，优雅又充满魅力，几何撞色，为这件半裙增加了更多的独特性，建议搭配雪纺面料的上衣
         * clothingPrice : 1230
         * clothingBrandName : GUESS
         * clothingStockId : 3404
         * clothingStockType : S
         * clothingStockNum : 2
         * clothingImgUrl : http://img-cdn.xykoo.cn/clothing/三色几何撞色半裙/clothingImg0
         * classify : 1
         * occupySeat : 1
         */

        private boolean copy;
        private int shoppingCartId;
        private int userId;
        private int clothingId;
        private String clothingName;
        private String clothingNo;
        private String clothingExplain;
        private int clothingPrice;
        private String clothingBrandName;
        private int clothingStockId;
        private String clothingStockType;
        private int clothingStockNum;
        private String clothingImgUrl;
        private int classify;
        private int occupySeat;

        public boolean isCopy() {
            return copy;
        }

        public void setCopy(boolean copy) {
            this.copy = copy;
        }

        public int getShoppingCartId() {
            return shoppingCartId;
        }

        public void setShoppingCartId(int shoppingCartId) {
            this.shoppingCartId = shoppingCartId;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getClothingId() {
            return clothingId;
        }

        public void setClothingId(int clothingId) {
            this.clothingId = clothingId;
        }

        public String getClothingName() {
            return clothingName;
        }

        public void setClothingName(String clothingName) {
            this.clothingName = clothingName;
        }

        public String getClothingNo() {
            return clothingNo;
        }

        public void setClothingNo(String clothingNo) {
            this.clothingNo = clothingNo;
        }

        public String getClothingExplain() {
            return clothingExplain;
        }

        public void setClothingExplain(String clothingExplain) {
            this.clothingExplain = clothingExplain;
        }

        public int getClothingPrice() {
            return clothingPrice;
        }

        public void setClothingPrice(int clothingPrice) {
            this.clothingPrice = clothingPrice;
        }

        public String getClothingBrandName() {
            return clothingBrandName;
        }

        public void setClothingBrandName(String clothingBrandName) {
            this.clothingBrandName = clothingBrandName;
        }

        public int getClothingStockId() {
            return clothingStockId;
        }

        public void setClothingStockId(int clothingStockId) {
            this.clothingStockId = clothingStockId;
        }

        public String getClothingStockType() {
            return clothingStockType;
        }

        public void setClothingStockType(String clothingStockType) {
            this.clothingStockType = clothingStockType;
        }

        public int getClothingStockNum() {
            return clothingStockNum;
        }

        public void setClothingStockNum(int clothingStockNum) {
            this.clothingStockNum = clothingStockNum;
        }

        public String getClothingImgUrl() {
            return clothingImgUrl;
        }

        public void setClothingImgUrl(String clothingImgUrl) {
            this.clothingImgUrl = clothingImgUrl;
        }

        public int getClassify() {
            return classify;
        }

        public void setClassify(int classify) {
            this.classify = classify;
        }

        public int getOccupySeat() {
            return occupySeat;
        }

        public void setOccupySeat(int occupySeat) {
            this.occupySeat = occupySeat;
        }
    }
}
