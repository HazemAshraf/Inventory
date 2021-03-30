/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bankmisr.warehouse.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@Table(name = "items", catalog = "warehouse", schema = "")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Items.findAll", query = "SELECT i FROM Items i"),
        @NamedQuery(name = "Items.findById", query = "SELECT i FROM Items i WHERE i.id = :id"),
        @NamedQuery(name = "Items.findByDescription", query = "SELECT i FROM Items i WHERE i.description = :description"),
        @NamedQuery(name = "Items.findByAssetTagType", query = "SELECT i FROM Items i WHERE i.assetTagType = :assetTagType"),
        @NamedQuery(name = "Items.findByItemCode", query = "SELECT i FROM Items i WHERE i.itemCode = :itemCode"),
        @NamedQuery(name = "Items.findBySerialNo", query = "SELECT i FROM Items i WHERE i.serialNo = :serialNo"),
        @NamedQuery(name = "Items.findByQuantity", query = "SELECT i FROM Items i WHERE i.quantity = :quantity"),
        @NamedQuery(name = "Items.findByType", query = "SELECT i FROM Items i WHERE i.type = :type"),
        @NamedQuery(name = "Items.findByBrand", query = "SELECT i FROM Items i WHERE i.brand = :brand"),
        @NamedQuery(name = "Items.findByModel", query = "SELECT i FROM Items i WHERE i.model = :model"),
        @NamedQuery(name = "Items.findByLocationLevel1", query = "SELECT i FROM Items i WHERE i.locationLevel1 = :locationLevel1"),
        @NamedQuery(name = "Items.findByLocationLevel2", query = "SELECT i FROM Items i WHERE i.locationLevel2 = :locationLevel2"),
        @NamedQuery(name = "Items.findByLocationLevel3", query = "SELECT i FROM Items i WHERE i.locationLevel3 = :locationLevel3"),
        @NamedQuery(name = "Items.findByLocationLevel4", query = "SELECT i FROM Items i WHERE i.locationLevel4 = :locationLevel4"),
        @NamedQuery(name = "Items.findByUserCode", query = "SELECT i FROM Items i WHERE i.userCode = :userCode"),
        @NamedQuery(name = "Items.findByUserName", query = "SELECT i FROM Items i WHERE i.userName = :userName"),
        @NamedQuery(name = "Items.findByBusinessLine", query = "SELECT i FROM Items i WHERE i.businessLine = :businessLine"),
        @NamedQuery(name = "Items.findByNotes", query = "SELECT i FROM Items i WHERE i.notes = :notes"),
        @NamedQuery(name = "Items.findByPurchaseDate", query = "SELECT i FROM Items i WHERE i.purchaseDate = :purchaseDate"),
        @NamedQuery(name = "Items.findByOperationDate", query = "SELECT i FROM Items i WHERE i.operationDate = :operationDate"),
        @NamedQuery(name = "Items.findBySupplierName", query = "SELECT i FROM Items i WHERE i.supplierName = :supplierName"),
        @NamedQuery(name = "Items.findByUsefulLife", query = "SELECT i FROM Items i WHERE i.usefulLife = :usefulLife"),
        @NamedQuery(name = "Items.findByWarrantyEndDate", query = "SELECT i FROM Items i WHERE i.warrantyEndDate = :warrantyEndDate"),
        @NamedQuery(name = "Items.findByPrice", query = "SELECT i FROM Items i WHERE i.price = :price")})
public class Items implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "description")
    private String description;
    @Column(name = "asset_tag_type")
    private String assetTagType;
    @Column(name = "item_code")
    private String itemCode;
    @Column(name = "serial_no")
    private String serialNo;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "type")
    private String type;
    @Column(name = "brand")
    private String brand;
    @Column(name = "model")
    private String model;
    @Column(name = "location_level_1")
    private String locationLevel1;
    @Column(name = "location_level_2")
    private String locationLevel2;
    @Column(name = "location_level_3")
    private String locationLevel3;
    @Column(name = "location_level_4")
    private String locationLevel4;
    @Column(name = "user_code")
    private String userCode;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "business_line")
    private String businessLine;
    @Column(name = "notes")
    private String notes;
    @Column(name = "purchase_date")
    @Temporal(TemporalType.DATE)
    private Date purchaseDate;
    @Column(name = "operation_date")
    @Temporal(TemporalType.DATE)
    private Date operationDate;
    @Column(name = "supplier_name")
    private String supplierName;
    @Column(name = "useful_life")
    private String usefulLife;
    @Column(name = "warranty_end_date")
    @Temporal(TemporalType.DATE)
    private Date warrantyEndDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price")
    private Double price;
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Category categoryId;
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Department departmentId;
    @JoinColumn(name = "picture_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private ItemPictures pictureId;

    public Items() {
    }

    public Items(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAssetTagType() {
        return assetTagType;
    }

    public void setAssetTagType(String assetTagType) {
        this.assetTagType = assetTagType;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getLocationLevel1() {
        return locationLevel1;
    }

    public void setLocationLevel1(String locationLevel1) {
        this.locationLevel1 = locationLevel1;
    }

    public String getLocationLevel2() {
        return locationLevel2;
    }

    public void setLocationLevel2(String locationLevel2) {
        this.locationLevel2 = locationLevel2;
    }

    public String getLocationLevel3() {
        return locationLevel3;
    }

    public void setLocationLevel3(String locationLevel3) {
        this.locationLevel3 = locationLevel3;
    }

    public String getLocationLevel4() {
        return locationLevel4;
    }

    public void setLocationLevel4(String locationLevel4) {
        this.locationLevel4 = locationLevel4;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBusinessLine() {
        return businessLine;
    }

    public void setBusinessLine(String businessLine) {
        this.businessLine = businessLine;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Date getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(Date operationDate) {
        this.operationDate = operationDate;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getUsefulLife() {
        return usefulLife;
    }

    public void setUsefulLife(String usefulLife) {
        this.usefulLife = usefulLife;
    }

    public Date getWarrantyEndDate() {
        return warrantyEndDate;
    }

    public void setWarrantyEndDate(Date warrantyEndDate) {
        this.warrantyEndDate = warrantyEndDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }

    public Department getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Department departmentId) {
        this.departmentId = departmentId;
    }

    public ItemPictures getPictureId() {
        return pictureId;
    }

    public void setPictureId(ItemPictures pictureId) {
        this.pictureId = pictureId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Items)) {
            return false;
        }
        Items other = (Items) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Items[ id=" + id + " ]";
    }

}