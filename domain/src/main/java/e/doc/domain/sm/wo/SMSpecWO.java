package e.doc.domain.sm.wo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class SMSpecWO implements SupermagDomain {
    @JsonProperty("DOCID")
    String docId;
    @JsonProperty("DOCTYPE")
    String docType;
    @JsonProperty("SPECITEM")
    String specItem;
    @JsonProperty("ARTICLE")
    String article;
    @JsonProperty("CAUSEID")
    String causeId;
    @JsonProperty("CAUSESPECITEM")
    String causeSpecItem;
    @JsonProperty("CAUSETYPE")
    String causeType;
    @JsonProperty("DISPLAYITEM")
    String displayItem;
    @JsonProperty("ITEMPRICE")
    BigDecimal itemPrice;
    @JsonProperty("ITEMPRICECUR")
    BigDecimal itemPriceCur;
    @JsonProperty("ITEMPRICENOTAX")
    BigDecimal itemPriceNoTax;
    @JsonProperty("QUANTITY")
    BigDecimal quantity;
    @JsonProperty("TOTALPRICE")
    BigDecimal totalPrice;
    @JsonProperty("TOTALPRICECUR")
    BigDecimal totalPriceCur;
    @JsonProperty("TOTALPRICENOTAX")
    BigDecimal totalPriceNoTax;
    @JsonProperty("BARCODEEXTERNAL")
    String barcode;
    @JsonProperty("CARDFULLNAME")
    String name;
    @JsonProperty("CARDMEASUREMENTCODEISO")
    String measureCoed;

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getSpecItem() {
        return specItem;
    }

    public void setSpecItem(String specItem) {
        this.specItem = specItem;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getCauseId() {
        return causeId;
    }

    public void setCauseId(String causeId) {
        this.causeId = causeId;
    }

    public String getCauseSpecItem() {
        return causeSpecItem;
    }

    public void setCauseSpecItem(String causeSpecItem) {
        this.causeSpecItem = causeSpecItem;
    }

    public String getCauseType() {
        return causeType;
    }

    public void setCauseType(String causeType) {
        this.causeType = causeType;
    }

    public String getDisplayItem() {
        return displayItem;
    }

    public void setDisplayItem(String displayItem) {
        this.displayItem = displayItem;
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }

    public BigDecimal getItemPriceCur() {
        return itemPriceCur;
    }

    public void setItemPriceCur(BigDecimal itemPriceCur) {
        this.itemPriceCur = itemPriceCur;
    }

    public BigDecimal getItemPriceNoTax() {
        return itemPriceNoTax;
    }

    public void setItemPriceNoTax(BigDecimal itemPriceNoTax) {
        this.itemPriceNoTax = itemPriceNoTax;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getTotalPriceCur() {
        return totalPriceCur;
    }

    public void setTotalPriceCur(BigDecimal totalPriceCur) {
        this.totalPriceCur = totalPriceCur;
    }

    public BigDecimal getTotalPriceNoTax() {
        return totalPriceNoTax;
    }

    public void setTotalPriceNoTax(BigDecimal totalPriceNoTax) {
        this.totalPriceNoTax = totalPriceNoTax;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMeasureCoed() {
        return measureCoed;
    }

    public void setMeasureCoed(String measureCoed) {
        this.measureCoed = measureCoed;
    }
}
