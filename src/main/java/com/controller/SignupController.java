package com.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bean.userBean;
import com.dao.userDAO;

@Controller
public class SignupController {
	
	@Autowired
	userDAO userDao;
	
	@RequestMapping(value="/signup",method=RequestMethod.GET)
	public String signUp(Model model){
		userBean user=new userBean();
		model.addAttribute("user",user);
		return "SignUp";
	}
	
	@RequestMapping(value="/userdata",method=RequestMethod.POST)
	public String userdata(@ModelAttribute("user") @Validated userBean userbean,BindingResult result ,Model model, List<MultipartFile> file){
		System.out.println("Firstname:" +userbean.getFirstName());
		System.out.println("LastName: "+userbean.getLastName());
		model.addAttribute("user",userbean);
		System.out.println(result);
		
		String path="E:\\workspace\\Spring-Web\\src\\main\\webapp\\images\\";
		String fpath="";
		file=userbean.getFile();
		int userId=17;
		//int randomId=(int) (Math.random()*10000);
		List<String> fileNames=new ArrayList<String>();
		for (MultipartFile multipartFile : file) {
			String fileName=(String)multipartFile.getOriginalFilename();
			fileNames.add(fileName);
			
			try {
				byte data[]=multipartFile.getBytes();
				FileOutputStream fos=new FileOutputStream(path+"\\"+userId+"\\"+fileName);
				BufferedOutputStream bos=new BufferedOutputStream(fos);
				bos.write(data);
				bos.flush();
				bos.close();	
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		for(int i=0;i<fileNames.size();i++) {
			fpath=fpath+fileNames.get(i)+",";
		}
		userbean.setFilePath(userId+"\\"+fpath);
		if(result.hasErrors()){
			return "SignUp";
		}else{
			userDao.Insert(userbean);
			return "redirect:/listuser";
		}
	}
	
	@RequestMapping(value = "listuser",method = RequestMethod.GET)
	public String listuser(Model model) {
		List<userBean> users=userDao.listUser();
		model.addAttribute("users",users);
		return "User";
	}
	
	@RequestMapping(value="edituser/{id}",method = RequestMethod.GET)
	public String editUser(@PathVariable("id") int id,Model model) {
		List<userBean> userbyId=userDao.editUser(id);
		model.addAttribute("userById",(userBean)userbyId.get(0));
		return "Update";
	}
	
	@RequestMapping(value="/updateuser",method=RequestMethod.POST)
	public String updateuser(@ModelAttribute("user") @Validated userBean userbean,BindingResult result ,Model model, List<MultipartFile> file){
		System.out.println("Firstname:" +userbean.getFirstName());
		System.out.println("LastName: "+userbean.getLastName());
		model.addAttribute("user",userbean);
		System.out.println(result);
		
		String path="E:\\workspace\\Spring-Web\\src\\main\\webapp\\images\\";
		String fpath="";
		file=userbean.getFile();
		int userId=17;
		//int randomId=(int) (Math.random()*10000);
		List<String> fileNames=new ArrayList<String>();
		for (MultipartFile multipartFile : file) {
			String fileName=multipartFile.getOriginalFilename();
			fileNames.add(fileName);
			try {
				byte data[]=multipartFile.getBytes();
				FileOutputStream fos=new FileOutputStream(path+"\\"+userId+"\\"+fileName);
				BufferedOutputStream bos=new BufferedOutputStream(fos);
				bos.write(data);
				bos.flush();
				bos.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for(int i=0;i<fileNames.size();i++) {
			fpath=fpath+fileNames.get(i)+",";
		}
		userbean.setFilePath(userId+"\\"+fpath);
		if(result.hasErrors()){
			return "SignUp";
		}else{
			userDao.Update(userbean);
			return "redirect:/listuser";
		}
	}
	
	@RequestMapping(value = "deleteuser/{id}",method = RequestMethod.GET)
	public String deleteUser(@PathVariable("id") int id) {
		userDao.Delete(id);
		return "redirect:/listuser";
	}
}
