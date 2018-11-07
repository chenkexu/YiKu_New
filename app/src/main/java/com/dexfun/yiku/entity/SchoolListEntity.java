package com.dexfun.yiku.entity;

import java.util.List;

/**
 * Created by Smile on 18/6/5.
 */

public class SchoolListEntity extends DefaultEntity {
    /**
     * data : [{"schoolId":1,"schoolName":"其他院校"}]
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
         * schoolId : 1
         * schoolName : 其他院校
         */

        private int schoolId;
        private String schoolName;

        public int getSchoolId() {
            return schoolId;
        }

        public void setSchoolId(int schoolId) {
            this.schoolId = schoolId;
        }

        public String getSchoolName() {
            return schoolName;
        }

        public void setSchoolName(String schoolName) {
            this.schoolName = schoolName;
        }
    }
}
