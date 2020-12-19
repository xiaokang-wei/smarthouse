package com.ruoyi.project.product.view.domain;

public class ProView {
    private Integer pdId;
    private String pdType;
    private String pdName;
    private String pdImg;
    private String pdSeries;
    private String pdStyle;
    private String pdPecs;
    private String pdMaterials;
    private String pdPlace;
    private String pdPrice;
    private String pdNum;
    private String pdTotal;


    public ProView() {
    }

    public ProView(Integer pdId, String pdType, String pdName, String pdImg, String pdSeries, String pdStyle, String pdPecs, String pdMaterials, String pdPlace, String pdPrice, String pdNum, String pdTotal) {
        this.pdId = pdId;
        this.pdType = pdType;
        this.pdName = pdName;
        this.pdImg = pdImg;
        this.pdSeries = pdSeries;
        this.pdStyle = pdStyle;
        this.pdPecs = pdPecs;
        this.pdMaterials = pdMaterials;
        this.pdPlace = pdPlace;
        this.pdPrice = pdPrice;
        this.pdNum = pdNum;
        this.pdTotal = pdTotal;
    }

    /**
     * 获取
     * @return pdId
     */
    public Integer getPdId() {
        return pdId;
    }

    /**
     * 设置
     * @param pdId
     */
    public void setPdId(Integer pdId) {
        this.pdId = pdId;
    }

    /**
     * 获取
     * @return pdType
     */
    public String getPdType() {
        return pdType;
    }

    /**
     * 设置
     * @param pdType
     */
    public void setPdType(String pdType) {
        this.pdType = pdType;
    }

    /**
     * 获取
     * @return pdName
     */
    public String getPdName() {
        return pdName;
    }

    /**
     * 设置
     * @param pdName
     */
    public void setPdName(String pdName) {
        this.pdName = pdName;
    }

    /**
     * 获取
     * @return pdImg
     */
    public String getPdImg() {
        return pdImg;
    }

    /**
     * 设置
     * @param pdImg
     */
    public void setPdImg(String pdImg) {
        this.pdImg = pdImg;
    }

    /**
     * 获取
     * @return pdSeries
     */
    public String getPdSeries() {
        return pdSeries;
    }

    /**
     * 设置
     * @param pdSeries
     */
    public void setPdSeries(String pdSeries) {
        this.pdSeries = pdSeries;
    }

    /**
     * 获取
     * @return pdStyle
     */
    public String getPdStyle() {
        return pdStyle;
    }

    /**
     * 设置
     * @param pdStyle
     */
    public void setPdStyle(String pdStyle) {
        this.pdStyle = pdStyle;
    }

    /**
     * 获取
     * @return pdPecs
     */
    public String getPdPecs() {
        return pdPecs;
    }

    /**
     * 设置
     * @param pdPecs
     */
    public void setPdPecs(String pdPecs) {
        this.pdPecs = pdPecs;
    }

    /**
     * 获取
     * @return pdMaterials
     */
    public String getPdMaterials() {
        return pdMaterials;
    }

    /**
     * 设置
     * @param pdMaterials
     */
    public void setPdMaterials(String pdMaterials) {
        this.pdMaterials = pdMaterials;
    }

    /**
     * 获取
     * @return pdPlace
     */
    public String getPdPlace() {
        return pdPlace;
    }

    /**
     * 设置
     * @param pdPlace
     */
    public void setPdPlace(String pdPlace) {
        this.pdPlace = pdPlace;
    }

    /**
     * 获取
     * @return pdPrice
     */
    public String getPdPrice() {
        return pdPrice;
    }

    /**
     * 设置
     * @param pdPrice
     */
    public void setPdPrice(String pdPrice) {
        this.pdPrice = pdPrice;
    }

    /**
     * 获取
     * @return pdNum
     */
    public String getPdNum() {
        return pdNum;
    }

    /**
     * 设置
     * @param pdNum
     */
    public void setPdNum(String pdNum) {
        this.pdNum = pdNum;
    }

    /**
     * 获取
     * @return pdTotal
     */
    public String getPdTotal() {
        return pdTotal;
    }

    /**
     * 设置
     * @param pdTotal
     */
    public void setPdTotal(String pdTotal) {
        this.pdTotal = pdTotal;
    }

    public String toString() {
        return "ProView{pdId = " + pdId + ", pdType = " + pdType + ", pdName = " + pdName + ", pdImg = " + pdImg + ", pdSeries = " + pdSeries + ", pdStyle = " + pdStyle + ", pdPecs = " + pdPecs + ", pdMaterials = " + pdMaterials + ", pdPlace = " + pdPlace + ", pdPrice = " + pdPrice + ", pdNum = " + pdNum + ", pdTotal = " + pdTotal + "}";
    }
}
