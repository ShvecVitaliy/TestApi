package com.example.testapi.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelGet {
        @SerializedName("Id")
        @Expose
        private Integer id;
        @SerializedName("ActualTime")
        @Expose
        private Integer actualTime;
        @SerializedName("Comment")
        @Expose
        private String comment;
        @SerializedName("Pair")
        @Expose
        private String pair;
        @SerializedName("Cmd")
        @Expose
        private Integer cmd;
        @SerializedName("TradingSystem")
        @Expose
        private Integer tradingSystem;
        @SerializedName("Period")
        @Expose
        private String period;
        @SerializedName("Price")
        @Expose
        private Double price;
        @SerializedName("Sl")
        @Expose
        private Double sl;
        @SerializedName("Tp")
        @Expose
        private Double tp;

    public ModelGet(Integer id, Integer actualTime, String comment,
                    String pair, Integer cmd, Integer tradingSystem,
                    String period, Double price, Double sl, Double tp) {
        this.id = id;
        this.actualTime = actualTime;
        this.comment = comment;
        this.pair = pair;
        this.cmd = cmd;
        this.tradingSystem = tradingSystem;
        this.period = period;
        this.price = price;
        this.sl = sl;
        this.tp = tp;
    }

    public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getActualTime() {
            return actualTime;
        }

        public void setActualTime(Integer actualTime) {
            this.actualTime = actualTime;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public String getPair() {
            return pair;
        }

        public void setPair(String pair) {
            this.pair = pair;
        }

        public Integer getCmd() {
            return cmd;
        }

        public void setCmd(Integer cmd) {
            this.cmd = cmd;
        }

        public Integer getTradingSystem() {
            return tradingSystem;
        }

        public void setTradingSystem(Integer tradingSystem) {
            this.tradingSystem = tradingSystem;
        }

        public String getPeriod() {
            return period;
        }

        public void setPeriod(String period) {
            this.period = period;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }

        public Double getSl() {
            return sl;
        }

        public void setSl(Double sl) {
            this.sl = sl;
        }

        public Double getTp() {
            return tp;
        }

        public void setTp(Double tp) {
            this.tp = tp;
        }

    }