package com.dexfun.yiku.entity;

import java.util.List;

/**
 * Created by Smile on 18/5/16.
 */

public class ChooseClothesEntity extends DefaultEntity {
    /**
     * data : [{"orderDetailsId":359,"orderId":224,"clothingId":33,"clothingName":"梨花短裙","clothingNo":"3030001","clothingPrice":799,"clothingBrandName":"衣庫","clothingStockId":43,"clothingStockType":"M","clothingImgUrl":"http://p198v6g26.bkt.clouddn.com/clothing/梨花短裙/clothingImg","storage":2},{"orderDetailsId":375,"orderId":231,"clothingId":33,"clothingName":"梨花短裙","clothingNo":"3030001","clothingPrice":799,"clothingBrandName":"衣庫","clothingStockId":43,"clothingStockType":"M","clothingImgUrl":"http://p198v6g26.bkt.clouddn.com/clothing/梨花短裙/clothingImg","storage":3},{"orderDetailsId":382,"orderId":234,"clothingId":29,"clothingName":"露肩雪白长裙","clothingNo":"3020001","clothingPrice":1399,"clothingBrandName":"衣庫","clothingStockId":38,"clothingStockType":"S","clothingImgUrl":"http://p198v6g26.bkt.clouddn.com/clothing/露肩雪白长裙/clothingImg","storage":3},{"orderDetailsId":481,"orderId":279,"clothingId":82,"clothingName":"拼接毛衣复古外套","clothingNo":"1050002","clothingPrice":498,"clothingBrandName":"MO&Co","clothingStockId":160,"clothingStockType":"均码","clothingImgUrl":"http://img-cdn.xykoo.cn/clothing/拼接毛衣复古外套/clothingImg","storage":3},{"orderDetailsId":1305,"orderId":565,"clothingId":81,"clothingName":"流苏民族格纹毛衣外套","clothingNo":"1040004","clothingPrice":428,"clothingBrandName":"MO&Co","clothingStockId":159,"clothingStockType":"均码","clothingImgUrl":"http://img-cdn.xykoo.cn/clothing/流苏民族格纹毛衣外套/clothingImg","storage":1},{"orderDetailsId":1306,"orderId":565,"clothingId":79,"clothingName":"中长款鹿皮卫衣外套","clothingNo":"1060002","clothingPrice":499,"clothingBrandName":"衣库","clothingStockId":156,"clothingStockType":"均码","clothingImgUrl":"http://img-cdn.xykoo.cn/clothing/中长款鹿皮卫衣外套/clothingImg","storage":1},{"orderDetailsId":1307,"orderId":565,"clothingId":88,"clothingName":"刺绣盘扣立领外套","clothingNo":"1060003","clothingPrice":458,"clothingBrandName":"MO&Co","clothingStockId":171,"clothingStockType":"M","clothingImgUrl":"http://img-cdn.xykoo.cn/clothing/刺绣盘扣立领外套/clothingImg","storage":1},{"orderDetailsId":1323,"orderId":571,"clothingId":555,"clothingName":"联名版宽松下衣失踪","clothingNo":"1010161","clothingPrice":1566,"clothingBrandName":"GK","clothingStockId":1480,"clothingStockType":"均码","clothingImgUrl":"http://img-cdn.xykoo.cn/clothing/联名版宽松下衣失踪/clothingImg0","storage":3}]
     * success : true
     */

    private boolean success;
    private List<DataEntity> data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<DataEntity> getData() {
        return data;
    }

    public void setData(List<DataEntity> data) {
        this.data = data;
    }

    public static class DataEntity {
        /**
         * orderDetailsId : 359
         * orderId : 224
         * clothingId : 33
         * clothingName : 梨花短裙
         * clothingNo : 3030001
         * clothingPrice : 799
         * clothingBrandName : 衣庫
         * clothingStockId : 43
         * clothingStockType : M
         * clothingImgUrl : http://p198v6g26.bkt.clouddn.com/clothing/梨花短裙/clothingImg
         * storage : 2
         */

        private int orderDetailsId;
        private int orderId;
        private int clothingId;
        private String clothingName;
        private String clothingNo;
        private int clothingPrice;
        private String clothingBrandName;
        private int clothingStockId;
        private String clothingStockType;
        private String clothingImgUrl;
        private int storage;

        public int getOccupySeat() {
            return occupySeat;
        }

        public void setOccupySeat(int occupySeat) {
            this.occupySeat = occupySeat;
        }

        private int occupySeat;

        public int getOrderDetailsId() {
            return orderDetailsId;
        }

        public void setOrderDetailsId(int orderDetailsId) {
            this.orderDetailsId = orderDetailsId;
        }

        public int getOrderId() {
            return orderId;
        }

        public void setOrderId(int orderId) {
            this.orderId = orderId;
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

        public String getClothingImgUrl() {
            return clothingImgUrl;
        }

        public void setClothingImgUrl(String clothingImgUrl) {
            this.clothingImgUrl = clothingImgUrl;
        }

        public int getStorage() {
            return storage;
        }

        public void setStorage(int storage) {
            this.storage = storage;
        }
    }
}
