package com.dexfun.yiku.entity;

/**
 * Created by Smile on 17/12/4.
 */

public class LoginEntity extends DefaultEntity {


    /**
     * data : eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ3d3cuZGV4ZnVuLmNvbSIsInVzZXIiOjQ4NjEsImp0aSI6IjNEOUI4NjM0LTQ5MzYtNEYwNi05OTQ2LUI2NkJCMEE3NzMzOCJ9.UJ3IQTqgmBkrrCac3Bu1FvJ-qKPpMQKcsaCk4V-YMzQ
     * success : true
     */

    private String data;
    private boolean success;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public static class DSFLOGIN extends DefaultEntity{

        /**
         * data : {"userId":270,"token":"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ3d3cuZGV4ZnVuLmNvbSIsInVzZXIiOjI3MCwianRpIjoiRDdGOTlCN0YtNjg2Ny00OTNGLUI0OTMtRDA5QkZCOUVENkJEIn0.sYUEExqhPLS-Hj2_PHdAqc9nihF_ALGo87zwrnRjdDw"}
         * success : true
         */

        private DataEntity data;
        private boolean success;

        public DataEntity getData() {
            return data;
        }

        public void setData(DataEntity data) {
            this.data = data;
        }

        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }

        public static class DataEntity {
            /**
             * userId : 270
             * token : eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ3d3cuZGV4ZnVuLmNvbSIsInVzZXIiOjI3MCwianRpIjoiRDdGOTlCN0YtNjg2Ny00OTNGLUI0OTMtRDA5QkZCOUVENkJEIn0.sYUEExqhPLS-Hj2_PHdAqc9nihF_ALGo87zwrnRjdDw
             */

            private int userId;
            private String token;

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public String getToken() {
                return token;
            }

            public void setToken(String token) {
                this.token = token;
            }
        }
    }
}
