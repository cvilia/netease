package com.cvilia.netease.bean;

import java.util.List;

/**
 * author: lzy
 * date: 2020/10/29
 * describe：歌曲url
 */
public class SongUrl {

    /**
     * data : [{"id":33894312,"url":"http://m7.music.126.net/20201029172036/396a1514f3b3bc89817c5e6f72e11351/ymusic/0fd6/4f65/43ed/a8772889f38dfcb91c04da915b301617.mp3","br":320000,"size":10691439,"md5":"a8772889f38dfcb91c04da915b301617","code":200,"expi":1200,"type":"mp3","gain":0,"fee":0,"uf":null,"payed":0,"flag":128,"canExtend":false,"freeTrialInfo":{"start":90,"end":120},"level":"exhigh","encodeType":"mp3"},{"id":405998841,"url":"http://m7.music.126.net/20201029172036/b045a90ce1816894fa052053d97c4043/ymusic/obj/w5zDlMODwrDDiGjCn8Ky/3338741765/7266/3563/ee25/23947886151d49a69a2ff01a0f2c311c.","br":128012,"size":481115,"md5":"23947886151d49a69a2ff01a0f2c311c","code":200,"expi":1200,"type":"mp3","gain":0,"fee":1,"uf":null,"payed":0,"flag":1028,"canExtend":false,"freeTrialInfo":{"start":90,"end":120},"level":"","encodeType":""}]
     * code : 200
     */

    private int code;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 33894312
         * url : http://m7.music.126.net/20201029172036/396a1514f3b3bc89817c5e6f72e11351/ymusic/0fd6/4f65/43ed/a8772889f38dfcb91c04da915b301617.mp3
         * br : 320000
         * size : 10691439
         * md5 : a8772889f38dfcb91c04da915b301617
         * code : 200
         * expi : 1200
         * type : mp3
         * gain : 0
         * fee : 0
         * uf : null
         * payed : 0
         * flag : 128
         * canExtend : false
         * freeTrialInfo : {"start":90,"end":120}
         * level : exhigh
         * encodeType : mp3
         */

        private int id;
        private String url;
        private int br;
        private int size;
        private String md5;
        private int code;
        private int expi;
        private String type;
        private int gain;
        private int fee;
        private Object uf;
        private int payed;
        private int flag;
        private boolean canExtend;
        private FreeTrialInfoBean freeTrialInfo;
        private String level;
        private String encodeType;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getBr() {
            return br;
        }

        public void setBr(int br) {
            this.br = br;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public String getMd5() {
            return md5;
        }

        public void setMd5(String md5) {
            this.md5 = md5;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public int getExpi() {
            return expi;
        }

        public void setExpi(int expi) {
            this.expi = expi;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getGain() {
            return gain;
        }

        public void setGain(int gain) {
            this.gain = gain;
        }

        public int getFee() {
            return fee;
        }

        public void setFee(int fee) {
            this.fee = fee;
        }

        public Object getUf() {
            return uf;
        }

        public void setUf(Object uf) {
            this.uf = uf;
        }

        public int getPayed() {
            return payed;
        }

        public void setPayed(int payed) {
            this.payed = payed;
        }

        public int getFlag() {
            return flag;
        }

        public void setFlag(int flag) {
            this.flag = flag;
        }

        public boolean isCanExtend() {
            return canExtend;
        }

        public void setCanExtend(boolean canExtend) {
            this.canExtend = canExtend;
        }

        public FreeTrialInfoBean getFreeTrialInfo() {
            return freeTrialInfo;
        }

        public void setFreeTrialInfo(FreeTrialInfoBean freeTrialInfo) {
            this.freeTrialInfo = freeTrialInfo;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public String getEncodeType() {
            return encodeType;
        }

        public void setEncodeType(String encodeType) {
            this.encodeType = encodeType;
        }

        public static class FreeTrialInfoBean {
            /**
             * start : 90
             * end : 120
             */

            private int start;
            private int end;

            public int getStart() {
                return start;
            }

            public void setStart(int start) {
                this.start = start;
            }

            public int getEnd() {
                return end;
            }

            public void setEnd(int end) {
                this.end = end;
            }
        }
    }
}
