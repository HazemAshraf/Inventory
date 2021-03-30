package com.bankmisr.warehouse.rest;

import com.bankmisr.warehouse.Model.*;
import com.bankmisr.warehouse.Security.ApiResponse;
import com.bankmisr.warehouse.entity.*;
import com.bankmisr.warehouse.service.*;
import com.bankmisr.warehouse.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
@CrossOrigin(origins = "*", allowCredentials = "true", methods = {RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class MasterRestController {



    @Autowired
    private CategoryService categoryService;
    @Autowired
    private DBFileService dbFileService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtTokenUtil;
    @Autowired
    private MyUserDetailsService userDetailsService;
    @Autowired
    private UserServiceImpl UserService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        authenticate(authenticationRequest.getUserName(), authenticationRequest.getPassword());
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUserName());
        System.out.println(userDetails.toString());
        final String token = jwtTokenUtil.generateToken(userDetails);
        System.out.println(token.toString());
        System.out.println("walalalalalala");

        String validationMessage ="success";
        String code="200";
        return ResponseEntity.ok(new AuthenticationResponse(token,userDetails.getUsername(),code,validationMessage));
    }

@RequestMapping("/signup")
public ResponseEntity<?> Signup (@RequestBody User user) throws Exception {
    User myUser = UserService.findByUsernameOrEmail(user.getUsername(),user.getEmail());
    String validationMessage ="";
    String code="200";
    if(myUser != null){
        // send response that this username or email is already exists
        validationMessage ="This username or email is already exists";
        code="400";
        return ResponseEntity.ok(new AuthenticationResponse("",myUser.getUsername(),code,validationMessage));
    }

    UserService.saveUser(user);
        AuthenticationRequest auth = new AuthenticationRequest(user.getUsername(),user.getPassword());
        return createAuthenticationToken(auth);

}
    private void authenticate(String userName, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {

            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////

    // Category CRUD
    @GetMapping("/categories")
    public GetCategoryListResponse findAllCategories() {
       // Long countItems = itemsService.countByCategoryId(ca);

        //intialize empty list
//        List<Category> categories = new ArrayList<>();
        //loop on categories
//        for (Category cat:categories) {
//            Long countItems = itemsService.countItemsByCategory(cat);
//            cat.setNumOfItems(Integer.parseInt(String.valueOf(countItems)));
//            categories.add(cat);
//        }
        //find each object and send it to itemsService.countByCategoryId(category);
        //add this count to the category object
        //add this object to the empty list

        GetCategoryListResponse resp = new GetCategoryListResponse();
        resp.setCode(200);
        resp.setMessage("");
        resp.setData(categoryService.findAll());
        return resp;
    }


    @GetMapping("/category/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable("id") int id) {
        Category category = categoryService.findById(id);
        return ResponseEntity.ok(category);
    }

    @PostMapping("/category")
    public Category saveCategory(@RequestBody Category category){
        return categoryService.save(category);
    }

    @PutMapping("/category")
    public Category updateCategory(@RequestBody Category category){
        return categoryService.save(category);
    }

    @DeleteMapping("/category/{id}")
    public CodeAndMessageResponse deleteCategoryById(@PathVariable int id) {

        Category tempCategory = categoryService.findById(id);

        // throw exception if null

        if (tempCategory == null) {
            throw new RuntimeException("Category id not found - " + id);
        }

        categoryService.deleteById(id);

        return new CodeAndMessageResponse(200,"Deleted Category id - " + id);
    }

 ///////////////////////////////////***Uploading File***////////////////////////////////////////

    @PostMapping("/uploadFile")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file,@RequestParam("id") int id) {
        if(file == null){
            return new UploadFileResponse(401,file.getName(), "",
                    file.getContentType(), file.getSize(),id , "upload is not done. the file is null");
        }
        try {
            System.out.println("the file bytes is : " + file.getBytes());
            if(file.getBytes() == null || file.getBytes().toString().equals("0x")){
                return new UploadFileResponse(401,file.getName(), "",
                        file.getContentType(), file.getSize(),id , "upload is not done.the bytes of file is null");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(String.valueOf(id))
                .toUriString();

        ItemPictures dbFile = dbFileService.storeFile(file,id,fileDownloadUri);


        return new UploadFileResponse(200,dbFile.getName(), fileDownloadUri,
                file.getContentType(), file.getSize(),dbFile.getId() , "upload done");
    }

    @GetMapping("/downloadFile/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable int fileId) {
        // Load file from database
        ItemPictures dbFile = dbFileService.getFile(fileId);

        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getName() + "\"")
                .body(new ByteArrayResource(dbFile.getData()));
    }

    @DeleteMapping("/deleteFile/{fileId}")
    public CodeAndMessageResponse deleteFileById(@PathVariable int fileId) {

        ItemPictures tempItemPictures = dbFileService.getFile(fileId);

        // throw exception if null

        if (tempItemPictures == null) {
            throw new RuntimeException("File id not found - " + fileId);
        }

        dbFileService.deleteById(fileId);

        return new CodeAndMessageResponse(200,"Deleted File id - " + fileId);
    }
}
