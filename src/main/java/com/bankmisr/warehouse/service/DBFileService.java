package com.bankmisr.warehouse.service;

import com.bankmisr.warehouse.dao.DBFileRepo;
import com.bankmisr.warehouse.entity.ItemPictures;
import com.bankmisr.warehouse.entity.Items;
import com.bankmisr.warehouse.exception.FileStorageException;
import com.bankmisr.warehouse.exception.MyFileNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DBFileService {

    @Autowired
    private DBFileRepo dbFileRepo;
    @Autowired
    private ItemRepo itemRepo;

    public ItemPictures storeFile(MultipartFile file,int id,String fileDownloadUri) {
        String fileName = "";
        if(file != null) {
            // Normalize file name
             fileName = StringUtils.cleanPath(file.getOriginalFilename());
        }
        try {
            ItemPictures dbFile = new ItemPictures();
            if(file != null) {
                // Check if the file's name contains invalid characters
                if (fileName.contains("..")) {
                    throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
                }

                //  ItemPictures dbFile = new ItemPictures(fileName, file.getContentType(), file.getBytes());

                dbFile.setName(fileName);
                dbFile.setType(file.getContentType());
                dbFile.setData(file.getBytes());
                dbFile.setUrl(fileDownloadUri);
            }
            dbFile.setId(id);


            return dbFileRepo.save(dbFile);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public ItemPictures getFile(int fileId)  {
        ItemPictures itemPictures = dbFileRepo.findById(fileId);
        if(itemPictures != null) return dbFileRepo.findById(fileId);
        else throw new MyFileNotFoundException("File not found with id " + fileId);
    }

    //deleteById
    public void deleteById(int id){
        List<Items> itemsList = new ArrayList<Items>();
        itemsList = itemRepo.findAll();
        if(itemsList != null) {
            for (Items item : itemsList) {
                if (item.getPictureId().getId() == id) {
                    item.setPictureId(null);
                    itemRepo.save(item);
                }
            }
        }
        else{
            throw new RuntimeException("there are no items - ");
        }
        dbFileRepo.deleteById(id);
    }

}
